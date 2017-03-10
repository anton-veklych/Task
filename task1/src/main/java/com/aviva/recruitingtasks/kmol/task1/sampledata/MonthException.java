package com.aviva.recruitingtasks.kmol.task1.sampledata;


public class MonthException extends RuntimeException{

    public  MonthException(String message){
        super(message);
    }

    public  MonthException(Throwable cause){
        super(cause);
    }

    public  MonthException(String message, Throwable cause){
        super(message, cause);
    }
}
