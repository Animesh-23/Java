package school;

import java.util.List;

public class ComputerScienceDepartment implements Department {

  List<Student> students;
  List<StaffMember> staff;

  ComputerScienceDepartment() {}

  @Override
  public int getTotalStudents() {
    return students.size();
  }

  @Override
  public int getTotalStaff() {
    return staff.size();
  }
}
