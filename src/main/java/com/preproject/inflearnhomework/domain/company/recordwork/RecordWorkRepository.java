package com.preproject.inflearnhomework.domain.company.recordwork;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordWorkRepository extends JpaRepository<MemberRecordWorks,Long> {
   // boolean existsByName(String worker);

}
