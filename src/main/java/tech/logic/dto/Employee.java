package tech.logic.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class Employee {

    private int empId;
    private String empName;
    private String comp;
    private long phone;
}
