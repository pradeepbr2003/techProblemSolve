package custom.annotation.example.dto;

import custom.annotation.SummerSeason;
import custom.annotation.WinterSeason;
import lombok.Data;

@WinterSeason
@SummerSeason
@Data
public class Car {
    private int capcity;
    private String season;
    private double serviceCost;

}
