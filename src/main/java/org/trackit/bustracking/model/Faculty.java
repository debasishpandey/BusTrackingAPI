package org.trackit.bustracking.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Faculty {

    @Id
    private Long id;

    private String name;

    private String username;

    private String password;

    private String contact;

//    @Version
//    private Integer version;  // This enables optimistic locking
}
