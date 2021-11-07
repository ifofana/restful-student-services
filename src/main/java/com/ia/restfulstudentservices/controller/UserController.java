package com.ia.restfulstudentservices.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ia.restfulstudentservices.jwt.JwtTokenProvider;
import com.ia.restfulstudentservices.model.Role;
import com.ia.restfulstudentservices.model.User;
import com.ia.restfulstudentservices.service.UserService;

/**
 * 
 * @author ibrah
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {
	 
	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	@Autowired
	UserService userService;

	@GetMapping(path = "/api/users")
	public List<User> getAllUsers() {
		return userService.findAllUsers();
	}
	
	@PostMapping("/api/user/registration")
    public ResponseEntity<?> register(@RequestBody User user){
        if(userService.findByUsername(user.getUsername()) != null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        user.setRole(Role.USER);
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

	@GetMapping("/api/user/login")
    public ResponseEntity<?> login(Principal principal){
        if(principal == null){
            //This should be ok http status because this will be used for logout path.
            return ResponseEntity.ok(principal);
        }
        UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) principal;
        User user = userService.findByUsername(authenticationToken.getName());
        user.setToken(jwtTokenProvider.generateToken(authenticationToken));
        System.out.println("TOKEN=" + user.getToken());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
