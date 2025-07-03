package org.trackit.bustracking.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Location {

    @Id
    private Long id;
    private String name;
    private Double latitude;

    private Double longitude;

    private LocalDateTime updatedAt;

}
