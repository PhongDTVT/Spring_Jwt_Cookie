package com.fi.user;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.BeanIds;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



import com.fi.exception.UserAlreadyExistsException;

import com.fi.registration.RegistrationRequest;
import com.fi.registration.token.VerificationToken;
import com.fi.registration.token.VerificationTokenRepository;
import com.fi.reqres.JwtAuthRes;
import com.fi.reqres.RefreshTokenReq;
import com.fi.reqres.ReqRes;
import com.fi.reqres.SignInRequest;
import com.fi.servie.JWTUtils;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class UserService implements IUserService {
	@Autowired
    private final UserRepository userRepository;
	@Autowired
    private final PasswordEncoder passwordEncoder;
    private final VerificationTokenRepository tokenRepository;
    
    @Autowired
    private final AuthenticationManager authenManager;
    private final JWTUtils jwtUtil;
    
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder,
			VerificationTokenRepository tokenRepository,AuthenticationManager authenManager,JWTUtils jwtUtil) {
		super();
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.tokenRepository = tokenRepository;
		this.authenManager = authenManager;
		this.jwtUtil = jwtUtil;

	}
    
	@Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User registerUser(RegistrationRequest request) {
       Optional<User> user = this.findByEmail(request.email());
       if (user.isPresent()){
           throw new UserAlreadyExistsException(
                   "User with email "+request.email() + " already exists");
       }
       var newUser = new User();
       newUser.setFirstname(request.firstname());
       newUser.setLastname(request.lastname());
       newUser.setEmail(request.email());
       newUser.setPassword(passwordEncoder.encode(request.password()));
       newUser.setRole(request.role());
        return userRepository.save(newUser);
    }

    @Override
    public Optional<User> findByEmail(String email) {
    	return userRepository.findByEmail(email);
    }

    @Override
    public void saveUserVerificationToken(User theUser, String token) {
        var verificationToken = new VerificationToken(token, theUser);
        tokenRepository.save(verificationToken);
    }

    @Override
    public String validateToken(String theToken) {
        VerificationToken token = tokenRepository.findByToken(theToken);
        if(token == null){
            return "Invalid verification token";
        }
        User user = token.getUser();
        Calendar calendar = Calendar.getInstance();
        if ((token.getExpirationTime().getTime() - calendar.getTime().getTime()) <= 0){
            tokenRepository.delete(token);
            return "Token already expired";
        }
        user.setEnabled(true);
        userRepository.save(user);
        return "valid";
    }

	@Override
	public VerificationToken generateNewVerificationToken(String oldToken) {
		// TODO Auto-generated method stub
		VerificationToken verificationToken = tokenRepository.findByToken(oldToken);
		var verificationTime = new VerificationToken();
		verificationToken.setToken(UUID.randomUUID().toString());
		verificationToken.setExpirationTime(verificationTime.getTokenExpirationTime());
		return tokenRepository.save(verificationToken);
	}
	
	@Override
	public ReqRes login(ReqRes login) {
		ReqRes jwtAuthres = new ReqRes();

		/*
		 * var check = userRepository.getOneByEmail(login.getEmail()); if(check == null)
		 * { throw new UserAlreadyExistsException("Tài khoản hoặc mật khẩu không đúng");
		 * } if(!passwordEncoder.matches(login.getPassword(), check.getPassword()) &&
		 * check != null) { throw new
		 * UserAlreadyExistsException("Tài khoản hoặc mật khẩu không đúng"); }
		 */
		try {
		authenManager.authenticate(new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword()));
		var user = userRepository.findByEmail(login.getEmail()).orElseThrow();
		var jwt = jwtUtil.generateToken(user);
		var refreshToken = jwtUtil.generateRefreshToken(new HashMap<>(), user);
		jwtAuthres.setStatusCode(200);
		jwtAuthres.setToken(jwt);
		jwtAuthres.setRefreshToken(refreshToken);
		jwtAuthres.setExpirationTime("120s");
		jwtAuthres.setMessage("Successfully Signed In");
		}catch(Exception e) {
			jwtAuthres.setStatusCode(500);
			jwtAuthres.setError(e.getMessage());
		}
		return jwtAuthres;
	}

	@Override
	public ReqRes refreshToken(ReqRes req) {
		// TODO Auto-generated method stub
		ReqRes rToken = new ReqRes();
		String ourEmail = jwtUtil.extractUsername(req.getToken());
		User user = userRepository.findByEmail(ourEmail).orElseThrow();
		if (!jwtUtil.isTokenValid(req.getToken(), user)) {
            var jwt = jwtUtil.generateToken(user);
            rToken.setStatusCode(200);
            rToken.setToken(jwt);
            rToken.setRefreshToken(jwtUtil.generateRefreshToken(new HashMap<>(), user));
            rToken.setExpirationTime("120s");
            rToken.setMessage("Successfully Refreshed Token");
            rToken.setStatusCode(200);
            return rToken;
        }
		rToken.setStatusCode(500);
        return rToken;
	}
	
	
}
