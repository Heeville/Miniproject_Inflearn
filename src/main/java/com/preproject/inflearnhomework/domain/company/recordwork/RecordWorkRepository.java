package com.preproject.inflearnhomework.domain.company.recordwork;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface RecordWorkRepository extends JpaRepository<MemberRecordWorks,Long> {
    Optional<MemberRecordWorks> findByNameAndToday(String worker, LocalDate today);

}
