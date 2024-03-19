package com.fi.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
		Optional<User> findByEmail(String email);
	    
	    @Query("SELECT u FROM user u WHERE u.email =:email")
	    User getOneByEmail(@Param("email") String email);
    
}
