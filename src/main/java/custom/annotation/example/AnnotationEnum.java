package custom.annotation.example;

import custom.annotation.AutumnSeason;
import custom.annotation.SpringSeason;
import custom.annotation.SummerSeason;
import custom.annotation.WinterSeason;
import custom.annotation.example.dto.Car;
import custom.annotation.example.dto.Scooter;

import java.lang.annotation.Annotation;

public enum AnnotationEnum {
    SUMMER_SEASON(Car.class.getDeclaredAnnotation(SummerSeason.class)),
    WINTER_SEASON(Car.class.getDeclaredAnnotation(WinterSeason.class)),
    SPRING_SEASON(Scooter.class.getDeclaredAnnotation(SpringSeason.class)),
    AUTUMN_SEASON(Scooter.class.getDeclaredAnnotation(AutumnSeason.class));
    private Annotation annotation;

    <A extends Annotation> AnnotationEnum(A a) {
        this.annotation = a;
    }

    public Annotation value() {
        return annotation;
    }
}
