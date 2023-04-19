package objects;

import java.util.Scanner;

public class Person {
    protected String name;
    protected String phoneNumber;

    public Person (){

    }

    public Person (String name, String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String setName(){
        return this.name;
    }

    public String setPhoneNumber(){
        return this.phoneNumber;
    }

}
