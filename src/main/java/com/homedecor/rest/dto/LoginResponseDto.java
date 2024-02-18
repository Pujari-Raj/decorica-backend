package com.homedecor.rest.dto;




import lombok.Data;

@Data
public class LoginResponseDto {
     private String userName;
     private Long userId;
     private Long roleId;
     private String roleName;
     private String token;

}

