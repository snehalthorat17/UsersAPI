package com.example.demo.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.LoginDTO;
import com.example.demo.dto.Response;
import com.example.demo.dto.UserDTO;
import com.example.demo.model.UserModel;
import com.example.demo.service.IUserService;

@RestController
public class UserController {

	@Autowired
	IUserService iUserService;
	
	@PostMapping("/addUser")
	public UserModel addUser(@RequestBody UserModel userModel) {
		
		return iUserService.addUser(userModel);
	}
	
	@GetMapping("/getUser")
	public List<UserModel> getUser() {
		return iUserService.getUser();
	}
	
	@GetMapping("/getUserById/{id}")
	public UserModel getUserById(@PathVariable("id") int id) {
//		System.out.print("getUserByid controller");
		return iUserService.getUserById(id);
	}
	
	@PutMapping("/updateUser/{id}")
	public UserModel updateUser(@RequestBody UserModel userModel,@PathVariable("id") int id) {
		return iUserService.updateUser(id, userModel);
	}

	@DeleteMapping("/deleteUserById/{id}")
	public String deleteUserById(@PathVariable("id")int id) {
		iUserService.deleteUserById(id);
		return "Record deleted successfully";
	}
	
	@PostMapping("/login")
	public Response login(@RequestBody LoginDTO loginDTO) {
		
		return iUserService.login(loginDTO);
	}
	
	@PutMapping("/forgotPassword")
	public Response forgotPassword(@RequestParam String email, String password) {
		
		return  iUserService.forgotPassword(email,password);
	}
}
