package com.learning.telusko.dao;

import com.learning.telusko.entity.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITouristRepository extends JpaRepository<Tourist,Long> {

}
