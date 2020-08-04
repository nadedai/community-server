package com.example.polls.repository;

import com.example.polls.model.Const;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author hhtt
 * @date 2020/8/3 23:30
 * description:
 */
public interface ConstRepository extends JpaRepository<Const, Long> {
    Optional<Const> findConstByText(String text);
}
