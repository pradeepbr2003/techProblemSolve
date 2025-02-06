package tech.logic.main;

import tech.logic.util.TechUtilEnum;
import tech.logic.dto.Employee;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Random;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TechUtility {
    private final Random random = new Random();

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        TechUtility techUtility = new TechUtility();
        techUtility.dynamicInvoke();
//        techUtility.staticInvoke();
    }

    private void dynamicInvoke() throws NoSuchMethodException {
        TechUtilEnum[] utilEnums = TechUtilEnum.values();
        String methodName = utilEnums[random.nextInt(utilEnums.length)].value();
        Method method = this.getClass().getDeclaredMethod(methodName, null);
        try {
            method.invoke(this, null);
        } catch (IllegalAccessException | InvocationTargetException e) {
            System.out.printf("%n Exception occurred : %s", e.getMessage());
        }
    }

    private void staticInvoke() {
        multiplicationTable();
        generateAlphbets();
        generatePrimeSeries();
        generateFibnocciSeries();
        testEmployeePopulate();
    }

    private void multiplicationTable() {
        System.out.printf("%n Multiplication Table %n");
        List<List<Integer>> multiplicationTable = IntStream.rangeClosed(2, 20)
                .mapToObj(num -> IntStream.rangeClosed(1, 10).map(i -> num * i).boxed()
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());

        List<Integer> multipliTableFlatWay = IntStream.rangeClosed(2, 20)
                .flatMap(num -> IntStream.rangeClosed(1, 10).map(i -> num * i)).boxed()
                .collect(Collectors.toList());

        multiplicationTable.forEach(System.out::println);
    }

    private void generateAlphbets() {
        System.out.printf("%n Aphabet Letters %n");
        String capLetters = IntStream.range(65, 65 + 26).mapToObj(i -> String.valueOf((char) i)).collect(Collectors.joining());
        String smallLetters = IntStream.range(97, 97 + 26).mapToObj(i -> String.valueOf((char) i)).collect(Collectors.joining());
        System.out.printf("%n Cap-Letters = %s  and %n Small Alphabets = %s", capLetters, smallLetters);
    }

    private void generatePrimeSeries() {
        System.out.printf("%n Prime Numbers %n");
        IntStream.rangeClosed(2, 100).filter(this::isPrime).forEach(i -> System.out.printf("%d , ", i));
    }

    private boolean isPrime(int i) {
        IntPredicate intPredicate = num -> (i % num) == 0;
        return IntStream.range(2, i / 2).noneMatch(intPredicate);
    }

    private void generateFibnocciSeries() {
        System.out.printf("%n Fibnocci Series %n");
        Stream.iterate(new int[]{0, 1}, arr -> new int[]{arr[1], arr[0] + arr[1]})
                .limit(20).mapToInt(arr -> arr[0]).forEach(i -> System.out.printf("%d ,", i));
    }

    private void testEmployeePopulate() {
        System.out.printf("%n Employee Information %n");
        List<Employee> employeeList = IntStream.rangeClosed(1, 10).mapToObj(this::addEmployee)
                .collect(Collectors.toList());
        System.out.printf("%n Employees : %s%n", employeeList);
    }

    private Employee addEmployee(int id) {
        return Employee.builder().empId(id).empName("name-" + id).comp("comp-" + id)
                .phone(random.longs(123456789, 999999999).findAny().getAsLong()).build();
    }
}
