package com.myntra.security;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import com.myntra.Constants;
import com.myntra.entity.BlockedJwt;
import com.myntra.repository.BlockedJwtRepo;

@Service
public class LogoutService {

	@Autowired
	BlockedJwtRepo blockedJwtRepo;
	@Autowired
	JwtHelper jwtHelper;

	public void logout(HttpServletRequest request) {
		String authHeader = request.getHeader("Authorization");
		String token = authHeader.substring(7);
		try {
			BlockedJwt blockedJwt = new BlockedJwt();
			blockedJwt.setJwt(token);
			blockedJwt.setExpirationTime(jwtHelper.extractExpiration(token));
			blockedJwtRepo.save(blockedJwt);
			SecurityContextHolder.clearContext();
		} catch (Exception e) {
			BlockedJwt blockedJwt = new BlockedJwt();
			blockedJwt.setJwt(token);
			blockedJwt.setExpirationTime(new Date());
			blockedJwtRepo.save(blockedJwt);
			SecurityContextHolder.clearContext();
			System.out.println(e.getMessage());
			e.printStackTrace();
		} 
	}

	@Scheduled(fixedDelay = Constants.FIXED_DELAY)
	private void cleanup() {
		blockedJwtRepo.findAll().forEach(token -> {
			if (token.getExpirationTime().before(new Date())) {
				blockedJwtRepo.delete(token);
			}
		});
	}
}
