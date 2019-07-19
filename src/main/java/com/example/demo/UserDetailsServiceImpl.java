package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserRepository userRe;

	@Override
	public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {

		com.example.demo.entity.User user = userRe.findByLoginId(loginId);

		if (user == null) {
			throw new UsernameNotFoundException("User" + loginId + "was not found in the database");
		}

		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		GrantedAuthority authority = new SimpleGrantedAuthority("USER");
		grantList.add(authority);



		UserDetails userDetails = (UserDetails) new User(user.getLoginId(),user.getPassword(),
				grantList);

		return userDetails;
	}

}
