package com.example.polls.repository;

import com.example.polls.model.Address;
import com.example.polls.model.House;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author hhtt
 * @date 2020/8/4 18:23
 * description:
 */
public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findByParentId(Long parentId);
    Boolean existsByNameAndParentId(String name,Long parentId);
}
