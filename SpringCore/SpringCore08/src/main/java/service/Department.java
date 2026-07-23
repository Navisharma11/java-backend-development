package service;

public class Department
{

    private Integer dpNo;

    private String dpName;

    public Department(Integer dpNo, String dpName)
    {
        super();
        System.out.println("Department bean created");
        this.dpNo = dpNo;
        this.dpName = dpName;
    }

    @Override
    public String toString() {
        return "Department{" + "dpNo=" + dpNo + ", dpName=" + dpName + '}';
    }
}
