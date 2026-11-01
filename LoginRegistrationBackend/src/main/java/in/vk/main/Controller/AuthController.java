package in.vk.main.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.vk.main.dto.LoginRequest;
import in.vk.main.dto.RegisterRequest;
import in.vk.main.entity.User;
import in.vk.main.service.AuthService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins="http://localhost:5173")
public class AuthController {	
	   
	
	private final AuthService authService;
	
	public AuthController(AuthService authService) {
		this.authService = authService;
		
	}

	@PostMapping("/register")
	public User register(@RequestBody RegisterRequest request) {
		return authService.register(request);
		
	}
	
	@PostMapping("/login")
	public User login(@RequestBody LoginRequest request) {
		return authService.login(request);
		
	}
}


