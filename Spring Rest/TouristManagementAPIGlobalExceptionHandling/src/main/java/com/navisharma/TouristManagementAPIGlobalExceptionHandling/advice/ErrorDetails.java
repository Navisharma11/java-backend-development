package com.navisharma.TouristManagementAPIGlobalExceptionHandling.advice;

import java.time.LocalDateTime;


public class ErrorDetails
{
    private String statuscode;

    private String msg;

    private LocalDateTime dateTime;

    public ErrorDetails(String statuscode, String msg, LocalDateTime dateTime)
    {
        super();
        this.statuscode = statuscode;
        this.msg = msg;
        this.dateTime = dateTime;
    }

    public ErrorDetails()
    {
        super();
    }

    public String getStatuscode() {
        return statuscode;
    }

    public void setStatuscode(String statuscode) {
        this.statuscode = statuscode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
