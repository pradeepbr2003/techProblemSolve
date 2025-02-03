package tech.logic;

import tech.logic.dto.Employee;

import java.util.List;
import java.util.Random;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TechUtility {
    private static final Random random = new Random();

    public static void main(String[] args) {

//        generateAlphbets();
//        generatePrimeSeries();
//        generateFibnocciSeries();
//        testEmployeePopulate();
    }

    private static void generateAlphbets() {
        String capLetters = IntStream.range(65, 65 + 26).mapToObj(i -> String.valueOf((char) i)).collect(Collectors.joining());
        String smallLetters = IntStream.range(97, 97 + 26).mapToObj(i -> String.valueOf((char) i)).collect(Collectors.joining());
        System.out.printf("%n Cap-Letters = %s  and %n Small Alphabets = %s", capLetters, smallLetters);
    }

    private static void generatePrimeSeries() {
        IntStream.rangeClosed(2, 100).filter(TechUtility::isPrime).forEach(i -> System.out.printf("%d , ", i));
    }

    private static boolean isPrime(int i) {
        IntPredicate intPredicate = num -> (i % num) == 0;
        return IntStream.range(2, i / 2).noneMatch(intPredicate);
    }

    private static void generateFibnocciSeries() {
        Stream.iterate(new int[]{0, 1}, arr -> new int[]{arr[1], arr[0] + arr[1]})
                .limit(20).mapToInt(arr -> arr[0]).forEach(i -> System.out.printf("%d ,", i));
    }

    private static void testEmployeePopulate() {
        List<Employee> employeeList = IntStream.rangeClosed(1, 10).mapToObj(TechUtility::addEmployee)
                .collect(Collectors.toList());
        System.out.printf("%n Employees : %s", employeeList);
    }

    private static Employee addEmployee(int id) {
        return Employee.builder().empId(id).empName("name-" + id).comp("comp-" + id)
                .phone(random.longs(123456789, 999999999).findFirst().getAsLong()).build();
    }
}
