package org.trackit.bustracking.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.trackit.bustracking.model.OtpToken;
import org.trackit.bustracking.repository.OtpRepository;

import java.time.LocalDateTime;

@Service
public class OtpService {

    @Autowired
    private OtpRepository otpRepository;

    public void saveOtp(String email, String otpCode) {
        OtpToken otp = new OtpToken();
        otp.setEmail(email);
        otp.setOtp(otpCode);
        otpRepository.save(otp);
    }

    public boolean validateOtp(String email, String inputOtp) {
        return otpRepository.findByEmail(email)
                .map(otp -> otp.getOtp().equals(inputOtp) &&
                        otp.getCreatedAt().isAfter(LocalDateTime.now().minusMinutes(5)))
                .orElse(false);
    }

    @Scheduled(fixedRate = 30000) // Every 1 minute
    public void deleteExpiredOtps() {
        otpRepository.deleteExpiredOtps(LocalDateTime.now().minusMinutes(5));
    }
}
