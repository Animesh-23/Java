package payroll;

public class Main {

  public static void main(String[] args) {
    PayrollSystem payrollSystem = new PayrollSystem();
    Employee Animesh = new FullTimeEmployee("Animesh", 0, 300000);
    Employee Rushi = new FullTimeEmployee("Rushi", 1, 30000);
    Employee Varad = new PartTimeEmployee("Varad", 2, 40, 1000);
    payrollSystem.addEmployee(Varad);
    payrollSystem.addEmployee(Rushi);
    payrollSystem.addEmployee(Animesh);
    System.out.println(payrollSystem.displaEmployees());
    payrollSystem.removeEmployee(Rushi);
    System.out.println(payrollSystem.displaEmployees());
  }
}
