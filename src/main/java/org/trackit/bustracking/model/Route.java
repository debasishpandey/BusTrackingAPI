package org.trackit.bustracking.model;

import jakarta.persistence.*;

@Entity
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String routeName;

    @Lob
    private String coordinates;
}
