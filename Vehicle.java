//Name: Kevin Tang
//Student Number: 500910586

import java.lang.Math;


public class Vehicle{
    private String mfr;
    private String color;
    private int power;
    private int numWheels;
    private int VIN;

    public final int ELECTRONIC_MOTOR=1;
    public final int GAS_ENGINE=0;

    //Vehicle constructor
    public Vehicle(){
        mfr=" ";
        color =" ";
        power=GAS_ENGINE;
        numWheels=4;
        VIN=0;
    }

    //Sets Vehicle variables
    public Vehicle(String mfr, String color, int power, int numWheels){
        this.mfr=mfr;
        this.color=color;
        this.power=power;
        this.numWheels=numWheels;
        VIN=(int)(Math.random()*(499-100)+1)+100;

    }
    public String getMfr(){
        return mfr;
    }


    public String getColor(){
        return color;
    }


    public int getPower(){
        return power;
    }


    public int getNumOfWheels(){
        return numWheels;
    }

    public int getVIN(){
        return VIN;
    }


    public String display(){
        return "VIN: "+ VIN+" "+getMfr()+ " " + getColor();
    }
    
    //Compares 2 cars objects by mfr power and numWheels to see if they are the same 
    public boolean equals(Object temp){
        Car other=(Car)temp;
        if(this.mfr==other.getMfr() && this.power==other.getPower() && this.numWheels== other.getNumOfWheels()){
          return true;
        }
        return false;
    }



}