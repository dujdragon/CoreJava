package Chapter4;

import java.time.LocalDate;

/** Java的方法总是按值调用
 * 形参的本质是实参指针的一个副本
 * 所以：
 * 方法不能修改基本数据类型的参数 （因为基本类型数据无法修改，即指针指向的代码块无法修改）
 * 方法可以改变对象参数的状态  （当指针指向的代码块为一个对象时，可以修改代码块的内容）
 * 方法不能让一个对象参数引用一个新的对象  （因为获得是实参指针的副本，而不是实参本身）
 */

public class ParamTest {
    public static void main(String[] args) {
        // 1. 方法不能修改数值参数
        System.out.println("Testing TripleValue");
        double percent = 10.0;
        System.out.println("Before: percent = " + percent);
        tripleValue(percent);
        System.out.println("After: percent = " + percent);

        // 2. 方法可以改变对象参数的状态
        System.out.println("\nTesting TripleSalary");
        Employee e = new Employee("xiaoli", 5000, LocalDate.of(2002,10,22));
        System.out.println("Before: salary = " + e.getSalary());
        tripleSalary(e);
        System.out.println("After: salary = " + e.getSalary());

        // 3. 方法不能将一个对象参数引用到一个新的对象
        System.out.println("\nTesting Swap");
        var a = new Employee("Alice", 7000);
        var b = new Employee("Bob", 6000);
        System.out.println("Before: a = " + a.getName());
        System.out.println("Before: b = " + b.getName());
        swapEmployee(a, b);
        System.out.println("After: a = " + a.getName());
        System.out.println("After: b = " + b.getName());

    }

    public static void tripleValue(double x) {
        x *= 3;
        System.out.println("End of method x = " + x);
    }

    public static void tripleSalary(Employee e) {
        e.raiseSalary(200);
        System.out.println("End of method salary = " + e.getSalary());
    }

    public static void swapEmployee(Employee e1, Employee e2) {
        Employee tmp = e1;
        e1 = e2;
        e2 = tmp;
        System.out.println("End of method e1 = " + e1.getName());
        System.out.println("End of method e2 = " + e2.getName());
    }
}

