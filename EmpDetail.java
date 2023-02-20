
import java.io.Serializable;

public class EmpDetail implements Serializable {
    int id;
    String name;
    int age;
    int salary;
    public EmpDetail(int EmpId, String EmpName, int EmpAge, int EmpSalary){
        this.id = EmpId;
        this.name = EmpName;
        this.age = EmpAge;
        this.salary = EmpSalary;
    }
    @Override
    public String toString() {
        return "Employee Details  [id=" + id + ", Name=" + name + ", Age=" + age + ", Salary=" + salary + "]";
    }   

    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }
    public int getSalary() {
        return salary;
    }
}
