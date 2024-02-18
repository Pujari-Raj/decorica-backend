package com.homedecor.rest.controller;

import com.homedecor.rest.common.exceptions.RecordNotFoundException;
import com.homedecor.rest.dto.CategoryDto;
import com.homedecor.rest.dto.LoginDto;
import com.homedecor.rest.dto.LoginResponseDto;
import com.homedecor.rest.dto.UserDto;
import com.homedecor.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import org.springframework.security.authentication.AuthenticationManager;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

//    @Autowired
//    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;


    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody UserDto userDto){

        // add check for username exists in a DB
        if(userService.existsByUsername(userDto.getUserName())){
            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
        }

        // add check for email exists in DB
        if(userService.existsByEmail(userDto.getEmail())){
            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
        }


        userService.createOrUpdateUser(userDto);


        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);

    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
        UserDto userDto = userService.findByUserNameAndPassword(loginDto.getUsernameOrEmail(),loginDto.getUsernameOrEmail(),loginDto.getPassword());
        if (userDto==null) {
            return new ResponseEntity<>("Username is invalid!",  HttpStatus.BAD_REQUEST);
        }
        if(!userDto.getPassword().contentEquals(loginDto.getPassword())){
            throw new RecordNotFoundException("Invalid username or password");
        }
        LoginResponseDto loginResponseDto =new LoginResponseDto();
        loginResponseDto.setToken(Auth0TokenGetter.getAccessToken());
        loginResponseDto.setUserName(userDto.getUserName());
        loginResponseDto.setUserId(userDto.getUserId());
        if(userDto.getRoleDto()!=null) {
            loginResponseDto.setRoleId(userDto.getRoleDto().getRoleId());
            loginResponseDto.setRoleName(userDto.getRoleDto().getName());
        }
        return new ResponseEntity<LoginResponseDto>(loginResponseDto, HttpStatus.OK);
    }
}

