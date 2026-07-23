package service;

public class Employee
{
    private Integer empid;

    private String name;

    private double salary;

    private String city;

    private Department depart;

//
//    public Employee(Integer empid, String name, double salary, String city, Department depart) {
//        this.empid = empid;
//        this.name = name;
//        this.salary = salary;
//        this.city = city;
//        this.depart = depart;
//    }


    @Override
    public String toString() {
        return "Employee{" + "empid=" + empid + ", name='" + name + '\'' + ", salary=" + salary + ", city='" + city + '\'' + ", depart=" + depart + '}';
    }

    public String employeeTask()
    {
        return "Every Employee Acts Productive but in reality they are less productive";
    }

    public Employee()
    {
       super();
       System.out.println("Employee bean created");
    }

    public Integer getEmpid() {
        return empid;
    }

    public void setEmpid(Integer empid) {
        this.empid = empid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Department getDepart() {
        return depart;
    }

    public void setDepart(Department depart) {
        this.depart = depart;
    }
}
