package payroll;

public class PartTimeEmployee extends Employee {

  private double hourlyRate;
  private int hoursWorked;

  public PartTimeEmployee(
    String name,
    int id,
    int hoursWorked,
    double hourlyRate
  ) {
    super(name, id);
    this.hourlyRate = hourlyRate;
    this.hoursWorked = hoursWorked;
  }

  @Override
  public double calculateSalary() {
    return hourlyRate * hoursWorked;
  }
}
