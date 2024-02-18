package com.homedecor.rest.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.homedecor.rest.common.messages.BaseResponse;
import com.homedecor.rest.dto.CartItemResponseDto;
import com.homedecor.rest.model.Message;
import com.homedecor.rest.service.UserService;
import com.homedecor.rest.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.homedecor.rest.dto.UserDto;


@RestController
@RequestMapping("/secured/user")
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping(value = "/getAllUsers")
	public ResponseEntity<List<UserDto>> getAllUsers() {
		List<UserDto> list = userService.getAllUsers();
		return new ResponseEntity<List<UserDto>>(list, HttpStatus.OK);
	}

	@GetMapping(value = "/get/by-id")
	public ResponseEntity<UserDto> getUserById(@NotNull(message = "Id can't be null") @RequestParam Long id) {
		UserDto list = userService.findByUserId(id);
		return new ResponseEntity<UserDto>(list, HttpStatus.OK);
	}

	@PostMapping(value = { "/add", "/update" })
	public ResponseEntity<BaseResponse> createOrUpdateUser(@RequestBody UserDto userDto) {
		BaseResponse response = userService.createOrUpdateUser(userDto);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<BaseResponse> deleteUserById(@PathVariable("id") Long id) {
		BaseResponse response = userService.deleteUserById(id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping(value = "/getUsersByRoleId")
	public ResponseEntity<List<UserDto>> getUserByRoleId(@NotNull(message = "roleId can't be null") @RequestParam Long roleId) {
		List<UserDto> list = userService.getUsersByRoleId(roleId);
		return new ResponseEntity<List<UserDto>>(list, HttpStatus.OK);
	}

	@GetMapping(value = "/public")
	public Message publicEndpoint() {
		return new Message("All good. You DO NOT need to be authenticated to call /api/public.");
	}

	@GetMapping(value = "/private")
	public Message privateEndpoint() {
		return new Message("All good. You can see this because you are Authenticated.");
	}
}
