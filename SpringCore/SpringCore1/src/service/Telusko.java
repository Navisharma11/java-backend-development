package service;

public class Telusko
{
    private ICourse course;

    public Telusko(ICourse course)
    {
        this.course=course;
    }

    public Telusko()
    {

    }

    public void setCourse(ICourse course) { //ICourse course = new Java();
        this.course = course;
    }

    public Boolean buyTheCourse(double amount)
    {
        return course.getTheCourse(amount);
    }

}
