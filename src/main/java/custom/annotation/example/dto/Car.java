package custom.annotation.example.dto;

import custom.annotation.SummerSeason;
import custom.annotation.WinterSeason;
import lombok.Data;

@WinterSeason(name = "Car is comfortable in winter season")
@SummerSeason(name = "Car is comfortable at summer season")
@Data
public class Car {
    private int capacity;
    private String season;
    private double serviceCost;

}
