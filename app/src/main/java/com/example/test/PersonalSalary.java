package com.example.test;

import android.text.Editable;
import android.util.Log;
import android.widget.EditText;

import java.text.DecimalFormat;

public class PersonalSalary {

    protected String fName;
    protected double gSalary;


    public PersonalSalary(String a, double b) {
        this.fName = a;
        this.gSalary = b;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(){
        this.fName = fName;
    }

    public double getgSalary(){
        return gSalary;
    }

    public void setgSalary(){
        this.gSalary = gSalary;
    }



    public void calculationNetSalary(){
        double a, tax;
        DecimalFormat df = new DecimalFormat("#,###.#");

        a = this.gSalary - this.gSalary*0.105;
        tax = (this.gSalary - 11000000) * 0.05;

        if (a <= 11000000){
            Log.d("PersonalSalary",this.fName + ": " + df.format(a));
        }else {
            Log.d("PersonalSalary",this.fName + ": " + df.format(a - tax));
        }
    }
}
