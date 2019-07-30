package com.ia.restfulstudentservices.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ia.restfulstudentservices.model.User;
import com.ia.restfulstudentservices.model.UserRole;
import com.ia.restfulstudentservices.repository.AccoutRepository;
import com.ia.restfulstudentservices.repository.RoleRepository;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
	
	@Autowired 
	private AccoutRepository accoutRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoderBean;

	@Override
	@Transactional
	public User registerNewUserAccount(User user) {
		
		Set<UserRole> authorities = new HashSet<>();
		authorities.add(new UserRole("ROLE_STUDENT", user));
		
		user.setAuthorities(authorities);		
		user.setPassword(passwordEncoderBean.encode(user.getPassword()));
		user.setEnabled(Boolean.TRUE);
		
		
		
		return accoutRepository.save(user);
	}

	@Override
	public void deleteById(long id) {
		
		accoutRepository.deleteById(id);
	}

	@Override
	public User findById(long id) {
		
		return accoutRepository.findById(id).get();
	}

	@Override
	public List<User> getAllUsers() {
		
		return accoutRepository.findAll();
	}

	@Override
	public User findByUsername(String username) {
		
		return accoutRepository.findByUsername(username);
	}

}
