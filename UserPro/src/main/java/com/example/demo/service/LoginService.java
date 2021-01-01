package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.dto.UserDto;
import com.example.demo.pojo.User;

@Service
public class LoginService {
	
	@Autowired
	private UserDao userDao;
	
	
	public UserDto getUserByUsernameAndPassword(String username,String password) {
		
		
		User user = userDao.getUserByUsernameAndPassword(username, password);
		
		if(user == null) {
			return null;
		}else {
			UserDto userDto = new UserDto();
			
			BeanUtils.copyProperties(user, userDto);
			
			
			return userDto;
		}
		
	}


	public List<UserDto> findAllUsers() {
		List<User> users =  userDao.findAll();
		
		List<UserDto> userDtos = new ArrayList<UserDto>();
		
		for(User user : users) {
			UserDto userDto = new UserDto();
			
			BeanUtils.copyProperties(user, userDto);
			
			userDtos.add(userDto);
		}
		
		return userDtos;
	}


	public void save(UserDto formData) {
		
		User user = new User();
		
		BeanUtils.copyProperties(formData, user);
		
		userDao.save(user);
		
	}


	public void updateUser(UserDto formData) {
		User user = new User();
		
		BeanUtils.copyProperties(formData, user);
		
		userDao.update(user);
		
		
	}

}
