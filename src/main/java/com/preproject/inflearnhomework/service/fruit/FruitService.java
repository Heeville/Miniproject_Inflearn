package com.preproject.inflearnhomework.service.fruit;

import com.preproject.inflearnhomework.domain.fruit.Fruit2;
import com.preproject.inflearnhomework.domain.fruit.Fruit2Repository;
import com.preproject.inflearnhomework.dto.fruit.request.CreateFruitRequest;
import com.preproject.inflearnhomework.dto.fruit.response.FruitCountResponse;
import com.preproject.inflearnhomework.dto.fruit.response.FruitListResponse;
import com.preproject.inflearnhomework.dto.fruit.response.FruitPriceSumResponse;
import com.preproject.inflearnhomework.exception.InvalidOptionException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FruitService {
    private final Fruit2Repository fruitRepository;

    public FruitService(Fruit2Repository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    public void save(CreateFruitRequest request){
        fruitRepository.save(new Fruit2(request.getName(), request.getWarehousingDate(),request.getPrice(), request.isSales()));

    }

    public void recordFruit(Long id){
        boolean b = fruitRepository.existsById(id);
        if (!b){
            throw new IllegalArgumentException();
        }
    }

    public FruitPriceSumResponse SalesPrice(String name){
        boolean isin = fruitRepository.existsByName(name);
        if (!isin){
            throw new IllegalArgumentException();
        }
        long sales=fruitRepository.findAllByNameAndSales(name,true)
                .stream().mapToLong(Fruit2::getPrice).sum();
        long notsales=fruitRepository.findAllByNameAndSales(name,false)
                .stream().mapToLong(Fruit2::getPrice).sum();
        return new FruitPriceSumResponse(sales,notsales);
    }

    public FruitCountResponse fruitCount(String name){
        boolean isin = fruitRepository.existsByName(name);
        if (!isin){
            throw new IllegalArgumentException();
        }
        long counts=fruitRepository.findAllByName(name)
                .stream().count();
        return new FruitCountResponse(counts);
    }

    public List<FruitListResponse> fruitListResponses(String option,long price)
    {
        if (option.equals("GTE")){
            List<Fruit2> fruit2s=fruitRepository.findAllByPriceGreaterThanEqual(price);
            return fruitRepository.findAllByPriceGreaterThanEqual(price).stream()
                    .map(fruit2 -> new FruitListResponse(fruit2.getName(),fruit2.getPrice(),LocalDate.ofInstant(fruit2.getWarehousing_date().toInstant(),ZoneId.systemDefault())))
                    .collect(Collectors.toList());
        }
        else if (option.equals("LTE")){
            List<Fruit2> fruit2s=fruitRepository.findAllByPriceLessThanEqual(price);
            return fruitRepository.findAllByPriceLessThanEqual(price).stream()
                    .map(fruit2 -> new FruitListResponse(fruit2.getName(),fruit2.getPrice(),fruit2.getWarehousing_date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()))
                    .collect(Collectors.toList());
        }
        else{
            throw new InvalidOptionException("잘못 입력하였습니다.");
        }

    }
}
