package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.UserModel;

public interface IUserRepository extends JpaRepository<UserModel, Integer>{

	Optional<UserModel> findByEmail(String email);
	
	

}
