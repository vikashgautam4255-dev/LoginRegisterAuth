package in.vk.main.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import in.vk.main.dto.LoginRequest;
import in.vk.main.dto.RegisterRequest;
import in.vk.main.entity.User;
import in.vk.main.repository.UserRepository;

@Service
public class AuthService {
	
	private final UserRepository userRepository;
	
	private final PasswordEncoder passwordEncoder;
	
	public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		
		
	}
	
	public User register(RegisterRequest request) {
		
		if(userRepository.existsByEmail(request.getEmail())) {
			
		
		}
		User user = new User();
		
		user.setName(request.getName());
		user.setEmail(request.getEmail());
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		user.setProvider("LOCAL");
		return userRepository.save(user);
		
	}
	
	public User login(LoginRequest request) {
		
		User user = userRepository.findByEmail(request.getEmail()).orElseThrow(() -> new RuntimeException(
				
				));
		
		if(!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
			
			throw new RuntimeException(
					"Invalide Email or Password"
					);
		}
		
		return user ;
		
	}

}
