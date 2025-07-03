package org.trackit.bustracking.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Driver {
    @Id
    private Integer id;

    private String name;

    @Column(unique = true)
    private String contact;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String username;

    private String password;


    @OneToOne(mappedBy = "assignedDriver")
    @JsonIgnoreProperties("assignedDriver") // prevents loop when serializing
    private Bus bus;

    @Column(nullable = true)
    private String profile;

}
