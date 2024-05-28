package com.operazionicrud.operazionicrud.DAO;

import com.operazionicrud.operazionicrud.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarDAO extends JpaRepository<Car, Long> {
}
