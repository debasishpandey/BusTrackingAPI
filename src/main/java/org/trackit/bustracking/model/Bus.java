package org.trackit.bustracking.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Bus {

    @Id
    private Long id;

    private String busNumber;

    @OneToOne
    @JoinColumn(name = "driver_id",nullable = true)
    private Driver assignedDriver;

    private String routeName;
    @OneToMany(mappedBy = "assignedBus")
    private List<Student> students;

    private double latitude;
    private double longitude;
    private boolean status;

}
