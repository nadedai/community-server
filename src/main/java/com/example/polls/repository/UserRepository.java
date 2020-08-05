package com.example.polls.repository;

import com.example.polls.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByPhone(String phone);

    List<User> findByIdIn(List<Long> userIds);

    List<User> findByUsernameLike(String name);

    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByPhone(String phone);

}
