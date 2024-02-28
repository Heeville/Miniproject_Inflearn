package com.preproject.inflearnhomework.controller.fruit;

import com.preproject.inflearnhomework.domain.fruit.Fruit2;
import com.preproject.inflearnhomework.dto.fruit.request.CreateFruitRequest;
import com.preproject.inflearnhomework.dto.fruit.request.FruitRecordRequest;
import com.preproject.inflearnhomework.dto.fruit.response.FruitCountResponse;
import com.preproject.inflearnhomework.dto.fruit.response.FruitListResponse;
import com.preproject.inflearnhomework.dto.fruit.response.FruitPriceSumResponse;
import com.preproject.inflearnhomework.service.fruit.FruitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FruitController {

    private final FruitService fruitService;

    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @PostMapping("/api/v1/fruit")
    public void saveFruit(@RequestBody CreateFruitRequest request){
        fruitService.save(request);
    }

    @PutMapping("/api/v1/fruit")
    public void recordFruit(@RequestBody FruitRecordRequest request){
        fruitService.recordFruit(request.getId());
    }

    @GetMapping("api/v1/fruit/stat")
    public FruitPriceSumResponse fruitResponse(@RequestParam String name){
        return fruitService.SalesPrice(name);
    }

    @GetMapping("api/v1/fruit/count")
    public FruitCountResponse fruitCountResponse(@RequestParam String name){
        return fruitService.fruitCount(name);
    }

    @GetMapping("api/v1/fruit/list")
    public List<FruitListResponse> fruitListResponses
            (@RequestParam String option,@RequestParam long price)
    {
        return fruitService.fruitListResponses(option,price);
    }
}
