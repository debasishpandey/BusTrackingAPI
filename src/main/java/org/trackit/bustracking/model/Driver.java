package org.trackit.bustracking.model;

import jakarta.annotation.Nullable;
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

    private String contact;

    private String username;

    private String password;

    @OneToOne(mappedBy = "assignedDriver")
    @JoinColumn(name = "bus", nullable = true)
    private Bus bus;

}
