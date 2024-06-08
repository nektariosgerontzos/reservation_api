package com.nekos.cruddemo.repository;

import com.nekos.cruddemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    // methods


}
