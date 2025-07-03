package org.trackit.bustracking.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RoutePoint {
    private String route;
    private double lat;
    private double lon;
}
