package Chapter4;

import java.time.LocalDate;
import java.util.Objects;

public class EmployeeTest {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Li", 1000, LocalDate.of(2002, 10, 22));
        staff[1] = new Employee("Zhao", 2000, LocalDate.of(2001, 10, 22));
        staff[2] = new Employee("Qian", 3000, LocalDate.of(2000, 10, 22));

        System.out.println(staff[0]);
        LocalDate d = staff[0].getHireDay();
        // 不能返回一个可变对象引用的
        // LocalDate 对象是不可变的，其plus和minus方法不会改变原有的对象，
        // 但会创建一个新的已经改变的对象并返回
        d.minusDays(10);
        System.out.println(staff[0]);

        staff[0].setId();
        staff[1].setId();
        staff[2].setId();
        for (Employee e : staff) {
            System.out.println(e);
        }

        int nextId = Employee.getNextId();
    }
}

class Employee {
    // 首先定义字段部分，最好为private来保证封装性

    // 类的static字段是属于类的，而不是属于对象的
    private static int nextId = 1;
    private int id;
    private String name;
    private double salary;
    private LocalDate hireDay = LocalDate.now();

    // 然后定义构造方法
    public Employee(String name, double salary, LocalDate hireDay) {
        // 如果name为null，则会进行报错
        this.name = Objects.requireNonNull(name, "name can not be null");
        this.salary = salary;
        // 如果hireDay为null，则不会报错并使用默认值
        this.hireDay = Objects.requireNonNullElse(hireDay, LocalDate.of(2002, 10, 22));
    }

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public Employee() {
        this("Employ #" + nextId, 1000);
    }

    // 然后定义类中方法

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    // 静态方法没有隐式参数，可以直接使用类名调用
    public static int getNextId() {
        return nextId;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    public void setId() {
        this.id = nextId ++ ;
    }

    @Override
    public String toString() {
        return "name: " + name + " salary is " + salary + " hireDay is " + hireDay + " id : " + id;
    }
}
