package org.trackit.bustracking.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.trackit.bustracking.model.OtpToken;

import java.time.LocalDateTime;
import java.util.Optional;

public interface OtpRepository extends JpaRepository<OtpToken, Long> {
    Optional<OtpToken> findByEmail(String email);

    @Modifying
    @Transactional
    @Query("DELETE FROM OtpToken o WHERE o.createdAt < :expiryTime")
    void deleteExpiredOtps(@Param("expiryTime") LocalDateTime expiryTime);
}