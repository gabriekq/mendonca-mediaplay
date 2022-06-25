package com.mendonca.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mendonca.model.User;

@Repository
public interface  UserRepository extends JpaRepository<User,Integer> {


    Optional<User> findByUserName(String userName);
}
