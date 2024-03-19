package com.fi.user;

import java.util.List;
import java.util.Optional;

import com.fi.registration.RegistrationRequest;
import com.fi.registration.token.VerificationToken;
import com.fi.reqres.JwtAuthRes;
import com.fi.reqres.RefreshTokenReq;
import com.fi.reqres.ReqRes;
import com.fi.reqres.SignInRequest;

public interface IUserService {
	List<User> getUsers();
    User registerUser(RegistrationRequest request);
    Optional<User> findByEmail(String email);

    void saveUserVerificationToken(User theUser, String verificationToken);

    String validateToken(String theToken);
    
    VerificationToken generateNewVerificationToken(String oldToken);
    
	ReqRes login(ReqRes login);

	ReqRes refreshToken(ReqRes req);
}
