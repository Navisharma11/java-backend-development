package service;

public class Employee
{
    private Integer empid;

    private String name;

    private double salary;

    private String city;

    public Employee(Integer empid, String name, double salary, String city) {
        super();
        System.out.println("Employee bean created");
        this.empid = empid;
        this.name = name;
        this.salary = salary;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Employee{" + "empid=" + empid + ", name='" + name + '\'' + ", salary=" + salary + ", city='" + city + '\'' + '}';
    }

    public String employeeTask()
    {
        return "Every Employee Acts Productive but in reality they are less productive";
    }
}
