package custom.annotation.example;

import custom.annotation.AutumnSeason;
import custom.annotation.SummerSeason;
import custom.annotation.example.dto.Car;
import custom.annotation.example.dto.Scooter;

import java.lang.annotation.Annotation;
import java.util.Random;

public class TestCustomAnnotation {
    private final Random random = new Random();

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        TestCustomAnnotation testCustomAnnotation = new TestCustomAnnotation();
        testCustomAnnotation.dynamicInvoke();

    }

    private void dynamicInvoke() {
        Object[] objects = {new Car(), new Scooter()};
        AnnotationEnum[] annoEnums = AnnotationEnum.values();
        Class<? extends Annotation> customAnnotation = annoEnums[random.nextInt(annoEnums.length)].value().annotationType();
        Object object = objects[random.nextInt(objects.length)];
        String objectType = object.getClass().getSimpleName();
        String annotationName = customAnnotation.getSimpleName();
        if (object.getClass().isAnnotationPresent(customAnnotation)) {
            System.out.printf("%n %s is annotated with : %s", objectType, annotationName);
        } else {
            System.out.printf("%n %s is not annotated with : %s", objectType, annotationName);
        }
    }
}
