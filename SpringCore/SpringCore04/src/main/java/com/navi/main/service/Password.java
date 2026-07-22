package com.navi.main.service;

public class Password
{
    String algo;
    public Password(String algo)
    {
        this.algo=algo;
        System.out.println("Password bean created");
    }

    public void passwordAlgoUsed()
    {
        System.out.println("The Algo used for password is "+algo);
    }

}
