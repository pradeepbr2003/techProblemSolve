package custom.annotation.example.dto;

import custom.annotation.AutumnSeason;
import custom.annotation.SpringSeason;
import lombok.Data;

@AutumnSeason
@SpringSeason
@Data
public class Scooter {
    private int capcity;
    private String season;
    private double serviceCost;

}
