package com.senac.ac.models;

public enum StatusEmail {

    SENT("Email Sent"),
    ERROR("Email Not Sent");

    private String status;

    StatusEmail(String status){
        this.status = status;
    }

    public String getStatus(){
        return status;
    }
}
