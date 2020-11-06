package com.company;

public class Contacts {
    private String email;
    private int phoneNumber;

    Contacts(String email, int phoneNumber){
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    public void setEmail (String email) {
        this.email = email;
    }

    public String getEmail () {
        return this.email;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getPhoneNumber() {
        return this.phoneNumber;
    }
}
