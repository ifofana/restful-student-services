package com.ia.restfulstudentservices.jwt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ia.restfulstudentservices.model.User;
import com.ia.restfulstudentservices.repository.AccoutRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private AccoutRepository accoutRepository;

	//	static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();

	//  static {
	//    inMemoryUserList.add(new JwtUserDetails(1L, "fofana",
	//        "$2a$10$6FtpIgxSaXJUWopep.d.6eSaxSfSfX0gU4yFAB/IiwTJvoFG.kkmm", "ROLE_USER_2"));
	//  }

	@Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	//    Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
	//        .filter(user -> user.getUsername().equals(username)).findFirst();
	//
	//    if (!findFirst.isPresent()) {
	//      throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
	//    }
	//
	//    return findFirst.get();
		  User user = accoutRepository.findByUsername(username);
		  JwtUserDetails findFirst = null;
		  if(user != null) {
			  findFirst = new JwtUserDetails(user.getId(), user.getUsername(), user.getPassword(), user.getAuthorities().toString());
		  }
		  
		  if(findFirst == null) {
			  throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
		  }
		  
		  return findFirst;
	  }

}


