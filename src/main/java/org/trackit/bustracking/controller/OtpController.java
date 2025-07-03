package org.trackit.bustracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.trackit.bustracking.Service.OtpService;
import org.trackit.bustracking.model.UserCredentials;
import org.trackit.bustracking.utill.MailSender;

import java.util.Random;

@RestController
@RequestMapping("/otp")
public class OtpController {

    @Autowired
    private OtpService otpService;

    @Autowired
    private MailSender mailSender;

    @PostMapping("/send")
    public ResponseEntity<String> sendOtp(@RequestParam String email) {
        String otp = generateOtp(); // You can use RandomStringUtils or SecureRandom
        otpService.saveOtp(email, otp);
        mailSender.sendMail(email,"OTP",otp);
        return ResponseEntity.ok("OTP sent");
    }

    @PostMapping("/validate")
    public ResponseEntity<String> validateOtp(@RequestBody UserCredentials userCredentials) {
        if (otpService.validateOtp(userCredentials.getUsername(), userCredentials.getPassword())) {
            return ResponseEntity.ok("OTP is valid");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid or expired OTP");
    }

    private String generateOtp() {
        return String.format("%06d", new Random().nextInt(999999));
    }
}
