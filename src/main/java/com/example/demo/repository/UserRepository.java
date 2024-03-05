package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

    User save(User user);

    User findUserByNameAndSurnameAndEmail(String name,String surname,String email);
}
