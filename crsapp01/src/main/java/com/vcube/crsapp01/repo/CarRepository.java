package com.vcube.crsapp01.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vcube.crsapp01.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

}
