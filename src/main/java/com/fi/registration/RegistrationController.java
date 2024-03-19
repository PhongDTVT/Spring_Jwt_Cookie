package com.fi.registration;

import java.io.UnsupportedEncodingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fi.event.RegistrationCompleteEvent;
import com.fi.event.listener.RegistrationCompleteEventListener;
import com.fi.registration.token.VerificationToken;
import com.fi.registration.token.VerificationTokenRepository;
import com.fi.user.User;
import com.fi.user.UserService;

import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/register")
@CrossOrigin("http://localhost:5173")
public class RegistrationController {
	private static final Logger log = LoggerFactory.getLogger(RegistrationController.class);
	private final HttpServletRequest servletRequest;
    private final UserService userService;
    private final ApplicationEventPublisher publisher;
    private final VerificationTokenRepository tokenRepository;
    private final RegistrationCompleteEventListener eventListener;
    
    public RegistrationController(UserService userService, ApplicationEventPublisher publisher,
			VerificationTokenRepository tokenRepository,RegistrationCompleteEventListener eventListener,HttpServletRequest servletRequest) {
		super();
		this.userService = userService;
		this.publisher = publisher;
		this.tokenRepository = tokenRepository;
		this.eventListener = eventListener;
		this.servletRequest = servletRequest;
	}

	@PostMapping
	@CrossOrigin("http://localhost:5173/signup")
    public String registerUser(@RequestBody RegistrationRequest registrationRequest, final HttpServletRequest request){
        User user = userService.registerUser(registrationRequest);
        publisher.publishEvent(new RegistrationCompleteEvent(user, applicationUrl(request)));
        return "Success!  Please, check your email for to complete your registration";
    }

    @GetMapping("/verifyEmail")
    public String verifyEmail(@RequestParam("token") String token){
        var theToken = tokenRepository.findByToken(token);
        String url = applicationUrl(servletRequest)+"/register/resend-verification-token?token="+token;
        if (theToken.getUser().isEnabled()){
            return "This account has already been verified, please, login.";
        }
        String verificationResult = userService.validateToken(token);
        if (verificationResult.equalsIgnoreCase("valid")){
            return "Email verified successfully. Now you can login to your account";
        }
        return "Invalid verification token,  <a href=\"" + url+"\">get a new link</a>";
    }
    
    @GetMapping("/resend-verification-token")
    public String resendVerificationToken(@RequestParam("token") String oldToken,final HttpServletRequest http) throws UnsupportedEncodingException, MessagingException {
    	VerificationToken verificationToken = userService.generateNewVerificationToken(oldToken); 
    	User theUser = verificationToken.getUser();
    	resendVerificationTokenEmail(theUser, applicationUrl(http), verificationToken);
		return "A new verification link has been sent to your email";
    	
    }



    private void resendVerificationTokenEmail(User theUser, String applicationUrl,VerificationToken verificationToken) throws UnsupportedEncodingException, MessagingException {
		// TODO Auto-generated method stub
		String url = applicationUrl + "/register/verifyEmail?token="+verificationToken.getToken();
		eventListener.sendVerificationEmail(url);
		log.info("Click the link to verify your registration: {}",url);
	}

	public String applicationUrl(HttpServletRequest request) {
        return "http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
    }
}
