package com.myntra.service;

import com.myntra.dto.StringInputDto;
import com.myntra.exception.MyntraException;

public interface RefreshTokenService {

	String getRefreshToken(String emailDto);

	String tokenValidation(StringInputDto refreshToken) throws MyntraException;
}
