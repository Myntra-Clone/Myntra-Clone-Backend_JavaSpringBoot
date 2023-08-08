package com.myntra.security;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;

import com.myntra.Constants;
import com.myntra.entity.BlockedJwt;
import com.myntra.repository.BlockedJwtRepo;

@Service
public class LogoutService implements LogoutHandler {

	@Autowired
	BlockedJwtRepo blockedJwtRepo;
	@Autowired
	JwtHelper jwtHelper;
	
	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
		String authHeader = request.getHeader("Authorization");
		String token = authHeader.substring(7);
		blockedJwtRepo.save(new BlockedJwt(token));
		SecurityContextHolder.clearContext();
	}
	
	@Scheduled(fixedDelay = Constants.FIXED_DELAY)
	private void cleanup() {
		blockedJwtRepo.findAll().forEach(token -> {
			if (jwtHelper.extractExpiration(token.getJwt()).before(new Date())) {
				blockedJwtRepo.delete(token);
			}
		});
	}

}
