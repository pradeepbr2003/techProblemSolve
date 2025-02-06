package custom.annotation.example.dto;

import custom.annotation.example.season.AutumnSeason;
import custom.annotation.example.season.SpringSeason;
import lombok.Data;

@AutumnSeason(name = "Scooter riding is good in autumn season")
@SpringSeason(name = "Scooter riding is good in spring season")
@Data
public class Scooter {
    private int capcity;
    private String season;
    private double serviceCost;

}
