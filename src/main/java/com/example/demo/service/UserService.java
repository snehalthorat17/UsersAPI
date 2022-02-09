package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.LoginDTO;
import com.example.demo.dto.Response;
import com.example.demo.dto.UserDTO;
import com.example.demo.exception.UserException;
import com.example.demo.model.UserModel;
import com.example.demo.repository.IUserRepository;
import com.example.demo.util.TokenUtil;

@Service
public class UserService implements IUserService{

	@Autowired
	IUserRepository iUserRepository;
	@Autowired
	TokenUtil tokenUtil;
	
	@Override
	public UserModel addUser(UserModel userModel) {
		return iUserRepository.save(userModel);
	}
	
	@Override
	public List<UserModel> getUser() {
		return (List<UserModel>)iUserRepository.findAll();
	}
	
	@Override
	public UserModel getUserById(int id) {
		return iUserRepository.findById(id).get();
	}
	
	@Override
	public UserModel updateUser(int id, UserModel userModel) {
		Optional<UserModel> isUserPresent = iUserRepository.findById(id);
		System.out.println(isUserPresent.isEmpty());
		if(isUserPresent.isPresent()) {
			isUserPresent.get().setFirstName(userModel.getFirstName());
			isUserPresent.get().setLastName(userModel.getLastName());
			isUserPresent.get().setMobileNo(userModel.getMobileNo());
			isUserPresent.get().setEmail(userModel.getEmail());
			isUserPresent.get().setPassword(userModel.getPassword());
			
			return iUserRepository.save(isUserPresent.get());
		}else {
			throw new UserException((long) 400, "User not found");
		}
	}
	
	@Override
	public void deleteUserById(int id) {
		iUserRepository.deleteById(id);
	}
	
	@Override
	public Response login(LoginDTO loginDTO) {
		Optional<UserModel> isUserPresent = iUserRepository.findByEmail(loginDTO.getEmail());
		if(isUserPresent.isPresent()) {
			if(isUserPresent.get().getPassword().equals(loginDTO.getPassword())) {
				return new Response("Login Successful",(long) 200, tokenUtil.createToken(isUserPresent.get().getId()));
			}
		}
		throw new UserException((long) 400, "User not found");
	}

	@Override
	public Response forgotPassword(String email, String password) {
		Optional<UserModel> isUserPresent = iUserRepository.findByEmail(email);
		if(isUserPresent.isPresent()) {
				isUserPresent.get().setPassword(password);
				iUserRepository.save(isUserPresent.get());
				return new Response("Password reset Successful",(long) 200, null);
		}
		throw new UserException((long) 400, "User not found");
	}



	

	


	
	
	

}
