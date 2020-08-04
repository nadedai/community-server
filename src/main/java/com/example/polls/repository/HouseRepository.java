package com.example.polls.repository;

import com.example.polls.model.House;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author hhtt
 * @date 2020/8/3 17:41
 * description:
 */
public interface HouseRepository extends JpaRepository<House, Long> {
    Optional<House> findById(Long id);
}
