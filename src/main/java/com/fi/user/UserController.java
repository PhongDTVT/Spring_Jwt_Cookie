package com.fi.user;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fi.reqres.JwtAuthRes;
import com.fi.reqres.RefreshTokenReq;
import com.fi.reqres.ReqRes;
import com.fi.reqres.SignInRequest;

@RestController
@RequestMapping("/users")
@CrossOrigin("http://localhost:5173")
public class UserController {
    private final UserService userService;
    
     public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping
    public List<User> getUsers(){
        return userService.getUsers();
    }
	
	@PostMapping("/login")
	@CrossOrigin("http://localhost:5173/login")
	public ResponseEntity<ReqRes> login(@RequestBody ReqRes login){
		
		return ResponseEntity.ok(userService.login(login));
	}
	
	@PostMapping("/refreshToken")
	@CrossOrigin("http://localhost:5173")
	public ResponseEntity<ReqRes> refreshToken(@RequestBody ReqRes refreshJwt){
		
		return ResponseEntity.ok(userService.refreshToken(refreshJwt));
		
	}
}
