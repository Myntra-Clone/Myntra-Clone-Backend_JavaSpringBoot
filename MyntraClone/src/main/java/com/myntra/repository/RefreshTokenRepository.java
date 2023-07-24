package com.myntra.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.myntra.entity.JwtRefreshToken;
import java.util.List;
import java.util.Optional;


public interface RefreshTokenRepository extends MongoRepository<JwtRefreshToken, String> {
	Optional<JwtRefreshToken> findByToken(String token);
}
