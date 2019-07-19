
package com.example.websocketdemo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

//import com.example.websocketdemo.domain.Question;
import com.example.websocketdemo.domain.User;
import com.example.websocketdemo.exception.ResourceNotFoundException;
import com.example.websocketdemo.repository.UserRepository;
import com.example.websocketdemo.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
	@Autowired UserService userService; 
	// 의존성 주입(Dependency Injection)
	// @Component, @Controller, @Repository, @Service 표시된 클래스형 빈 객체를 스프링이 스캔하여 등록하고, @Autowired 등 요청시 주입 	
	
	@PostMapping("")
	public String createUser(@Valid User formUser, Model model) {
		userService.saveUser(formUser); 
		model.addAttribute("user", formUser);
		return "/users/welcome";
	}	
	@GetMapping("") //사용자목록 출력, 로그인 아닐 시 로그인 폼으로 이동
	public String getAllUser(Model model, HttpSession session) {
		model.addAttribute("users", userService.getUsers());
		
		if(session.getAttribute("user") == null) {
			System.out.println("id error : ");
			return "redirect:/users/login-form";
		}
		return "/users/list";
	}	
	
	@GetMapping("/name")	//사용자목록 출력, 이름 기준 정렬
	public String getUsersByName(Model model, HttpSession session, String name) {
		if(session.getAttribute("user") == null) {
			System.out.println("id error : ");
			return "redirect:/users/login-form";
		}
		List<User> users = userService.getUsersByName(name);
		model.addAttribute("users", users);
		return "/users/list"; 
	}	
	
	@GetMapping("/{id}") //로그인 한 사용자 정보 보기
	public String getUserById(@PathVariable(value = "id") Long id, Model model) {
		User user = userService.getUserById(id);
		model.addAttribute("user", user);
		return "/users/info";
	}
	
	@PutMapping("/{id}")
	public String updateUserById(@PathVariable(value = "id") Long id, @Valid User formUser, Model model, HttpSession session) {
		User user = userService.getUserById(id);
		user.setUserPw(formUser.getUserPw());
		user.setName(formUser.getName());
		userService.updateUser(user);		
		model.addAttribute("user", user);
		session.setAttribute("user", user);
		return "/users/info";
	}	
	@DeleteMapping("/{id}")
	public String deleteUserById(@PathVariable(value = "id") Long id, @Valid User formUser, Model model) {
		userService.deleteUser(formUser);
		model.addAttribute("name", formUser.getName());
		return "redirect:/users";
	}
	
	/*
	@PatchMapping("/users/{id}")
	//@RequestBody 사용하는 경우 
	public ResponseEntity<User> patchUserById(@PathVariable(value = "id") Long userId, @Valid  User userDetails, Model model)
			throws ResourceNotFoundException {
		// orElseThrow() : 해당 값이 존재하는 경우 반환하고, 없는 경우 제공자(supplier)에 의해 제공되는 예외 반환
		User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
		user.setName(userDetails.getName());
		//user.setCompany(userDetails.getCompany());
		User userUpdate = userRepo.save(user);
		return ResponseEntity.ok(userUpdate);
		// 
		//return ResponseEntity.ok().body(user);
	}

	@GetMapping("/users/n")
	public String getEmployeeByName(@Param(value = "name") String name, Model model)
			throws ResourceNotFoundException {
		System.out.println(name);
		List<User> users = userRepo.findByNameOrderByIdAsc(name);
		model.addAttribute("users", users);
		return "user-list";
	}
	@GetMapping("/users/c")
	public String getUserByCompany(@Param(value = "company") String company, Model model)
			throws ResourceNotFoundException {
		List<User> users = userRepo.findByCompany(company);
		model.addAttribute("users", users);
		return "user-list";
	}
	*/
}
