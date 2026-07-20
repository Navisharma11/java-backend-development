package service;

public class Java implements ICourse
{
    @Override
    public Boolean getTheCourse(Double amount) {
        System.out.println("Java Course is Purchased and Fees paid is "+amount);
        return true;
    }
}
