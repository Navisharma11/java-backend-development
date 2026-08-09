package com.navisharma.TouristManagementAPI.exception;

public class TouristNotFoundException extends RuntimeException
{
    public TouristNotFoundException(String msg)
    {
        super(msg);
    }
}
