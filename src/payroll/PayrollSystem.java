package payroll;

import java.util.ArrayList;
import java.util.List;

public class PayrollSystem {

  private List<Employee> employeeList;

  public PayrollSystem() {
    employeeList = new ArrayList<>();
  }

  public void addEmployee(Employee employee) {
    employeeList.add(employee);
  }

  public void removeEmployee(Employee employee) {
    employeeList.remove(employee);
  }

  public List<Employee> displaEmployees() {
    return employeeList;
  }
}
