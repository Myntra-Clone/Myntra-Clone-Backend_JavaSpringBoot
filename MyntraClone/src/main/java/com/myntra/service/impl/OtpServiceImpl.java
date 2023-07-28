package com.myntra.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import com.myntra.Constants;
import com.myntra.dto.OtpDetailsDto;
import com.myntra.dto.StringInputDto;
import com.myntra.entity.OtpDetails;
import com.myntra.repository.OtpDetailsRepository;
import com.myntra.service.declaration.OtpService;

@Service
public class OtpServiceImpl implements OtpService{
	
	@Autowired
	OtpDetailsRepository otpDetailsRepository;
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	JavaMailSenderImpl mailSender;

	@Override
	public Integer generateOtp(StringInputDto email) {
		Random random=new Random();
		int otp=random.nextInt(1001, 10000);
		otpDetailsRepository.save(new OtpDetails(email.getInput(), otp, LocalDateTime.now().plusMinutes(Constants.OTP_VALIDITY)));
		return otp;
	}

	@Override
	public boolean validateOtp(OtpDetailsDto otpDetailsDto) {
		OtpDetails otpDetails = modelMapper.map(otpDetailsDto, OtpDetails.class);
		Optional<OtpDetails> details = otpDetailsRepository.findById(otpDetails.getEmail());
		if(details.isPresent()) {
			if(details.get().getOtpTime().isAfter(LocalDateTime.now()) && otpDetails.getOtp()==details.get().getOtp()){
				otpDetailsRepository.deleteById(details.get().getEmail());
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void sendOtpByEmail(String email, String otp) {
		SimpleMailMessage message=new SimpleMailMessage();
		message.setFrom("myntraotp@outlook.in");
		message.setTo(email);
		message.setSubject("OTP from Myntra to verify Email");
		message.setText("Your OTP to verify email  "+email+" is:\r\n "+otp+"\r\nIt is valid for 5 minutes.");
		mailSender.send(message);
	}
}

