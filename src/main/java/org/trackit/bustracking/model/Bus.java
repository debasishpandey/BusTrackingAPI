package org.trackit.bustracking.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String busNumber;
    @Setter
    @OneToOne
    @JoinColumn(name = "driver_id", nullable = true)
    @JsonIgnoreProperties("bus") // prevent recursion when serializing bus
    private Driver assignedDriver;

    private String routeName;

    @OneToMany(mappedBy = "assignedBus")
    @Column(nullable = true)
    @JsonManagedReference
    private List<Student> students;

    @Column(nullable = true)
    private double latitude;
    @Column(nullable = true)
    private double longitude;
    @Column(nullable = false)
    private boolean status=false;


    public Boolean getStatus() {
        return this.status;
    }

}
