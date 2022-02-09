package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.LoginDTO;
import com.example.demo.dto.Response;
import com.example.demo.dto.UserDTO;
import com.example.demo.model.UserModel;

@Service
public interface IUserService {
	
	UserModel addUser(UserModel userModel);
	
	List<UserModel> getUser();
	
	UserModel getUserById(int id);
	
	UserModel updateUser(int id, UserModel userModel);
	
	void deleteUserById(int id);
	
	Response login(LoginDTO loginDTO);

	Response forgotPassword(String email, String password);

	

	

	


	

	

}
