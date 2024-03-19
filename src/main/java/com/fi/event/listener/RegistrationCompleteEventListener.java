package com.fi.event.listener;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.fi.event.RegistrationCompleteEvent;
import com.fi.registration.token.VerificationTokenRepository;
import com.fi.user.User;
import com.fi.user.UserService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;


@Component
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {
	private static final Logger log = LoggerFactory.getLogger(RegistrationCompleteEventListener.class);
	
 private final UserService userService;

 private final JavaMailSender mailSender;
 private  User theUser;
 private final VerificationTokenRepository tokenRepo;
 
 

    public RegistrationCompleteEventListener(UserService userService, JavaMailSender mailSender,VerificationTokenRepository tokenRepo) {
	super();
	this.userService = userService;
	this.mailSender = mailSender;
	this.tokenRepo = tokenRepo;
}
    
	@Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        // 1. Get the newly registered user
        theUser = event.getUser();
        //2. Create a verification token for the user
        String verificationToken = UUID.randomUUID().toString();
        //3. Save the verification token for the user
        userService.saveUserVerificationToken(theUser, verificationToken);
        //4 Build the verification url to be sent to the user
        String url = event.getApplicationUrl()+"/register/verifyEmail?token="+verificationToken;
        //5. Send the email.
        try {
            sendVerificationEmail(url);
        } catch (MessagingException | UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        
        log.info("Click the link to verify your registration :  {}", url);
    }
    public void sendVerificationEmail(String url) throws MessagingException, UnsupportedEncodingException {
        String subject = "Email Verification";
        String senderName = "User Registration Portal Service";
        String mailContent = "<p> Hi, "+ theUser.getFirstname()+ ", </p>"+
                "<p>Thank you for registering with us,"+"" +
                "Please, follow the link below to complete your registration.</p>"+
                "<a href=\"" +url+ "\">Verify your email to activate your account</a>"+
                "<p> Thank you <br> Users Registration Portal Service";
        MimeMessage message = mailSender.createMimeMessage();
        var messageHelper = new MimeMessageHelper(message);
        messageHelper.setFrom("phong.th.q@gmail.com", senderName);
        messageHelper.setTo(theUser.getEmail());
        messageHelper.setSubject(subject);
        messageHelper.setText(mailContent, true);
        mailSender.send(message);
    }
    
}
