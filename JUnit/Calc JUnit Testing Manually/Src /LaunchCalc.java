public class LaunchCalc
{
    public static void main(String[] args)
    {
        Calc c = new Calc();
        int result = c.divide(10,5);
        if(result==2)
            System.out.println("test case passed");
        else
            System.out.println("test case failed");


        int result2 = c.divide(10,0);
        if(result2==2)
            System.out.println("test case passed");
        else
            System.out.println("test case failed");
    }
}
