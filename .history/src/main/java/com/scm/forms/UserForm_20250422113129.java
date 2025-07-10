package com.scm.forms;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserForm {

 @NotBlank(message = "name is required")
 @Size(min = 3, message = "min 3 character is required")   
 private String name;

 @Email(message = "email is not valid")
 private String email;

 @NotBlank(message = "password is required")
 @Size(min = 6, message = "min 6 character is required")
 private String password;

 @NotBlank(message = "about is required")
 private String about;

 @Size(min = 8, max = 10, message = "Invalid Phone Number")
 private String phoneNumber;    
 
}
