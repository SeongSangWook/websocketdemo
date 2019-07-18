/*
package com.example.websocketdemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

//import com.example.websocketdemo.domain.Question;
import com.example.websocketdemo.domain.User;
//import com.example.websocketdemo.QuestionEntity;
import com.example.websocketdemo.entity.UserEntity;
import com.example.websocketdemo.exception.ResourceNotFoundException;
import com.example.websocketdemo.repository.UserRepository;

@Service//("userService")
public class UserServiceImpl implements UserService {

	@Autowired UserRepository repository;
	//id순서
	@Override
	public User getUserById(long id) {
		UserEntity userEntity = null;
		try {
			userEntity = repository.findById(id).orElseThrow(() 
					-> new ResourceNotFoundException("not found " + id ));
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userEntity.buildDomain();
	}

	@Override
	public User getUserByUserId(String userId) {
		UserEntity userEntity = userEntity = repository.findByUserId(userId);
		if(userEntity == null)
			return null;
		return userEntity.buildDomain();
	}

	@Override
	public List<User> getUsers() {
		List<User> users = new ArrayList<User>();
		List<UserEntity> entities = repository.findAll();
		for(UserEntity entity : entities) {
			User user = entity.buildDomain();
			users.add(user);
		}
		return users;
	}
	// 이름기준 오름차순 정렬
	@Override
	public List<User> getUsersByName(String name) { 
		List<UserEntity> entities = repository.findAll(new Sort(Sort.Direction.ASC, "name"));
		
		List<User> users = new ArrayList<User>();
		for(UserEntity entity : entities) {
			User user = entity.buildDomain();
			users.add(user);
		}
		return users;	
	}

	@Override
	public List<User> getUsersByCompany(String company) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUsersByPage(int index, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		UserEntity entity = new UserEntity();
		entity.buildEntity(user);
		repository.save(entity);
	}
	@Override
	public void updateUser(User user) {
		UserEntity entity = new UserEntity();
		entity.buildEntity(user);
		repository.save(entity);
	}

	@Override
	public void deleteUser(User user) {
		UserEntity entity = new UserEntity();
		entity.buildEntity(user);
		repository.delete(entity);
	}		
}
*/