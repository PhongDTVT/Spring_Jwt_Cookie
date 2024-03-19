package com.fi.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fi.user.UserRepository;

@Service
public class UserRegistrationDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    
    public UserRegistrationDetailsService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .map(UserRegistrationDetails::new)
                .orElseThrow(()-> new UsernameNotFoundException("User not found"));
    }
}
