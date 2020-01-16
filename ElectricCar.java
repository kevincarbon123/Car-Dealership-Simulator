//Name: Kevin Tang
//Student Number: 500910586

public class ElectricCar extends Car{

    private int rechargeTime;
    private String batteryType;

    //ElectricCar constructor
    public ElectricCar(){
        super();
        rechargeTime=0;
        batteryType=" ";
    }

    //Sets ElectricCar variables
    public ElectricCar(int rechargeTime, String batteryType, String mfr, String color, int power, int numWheels, int model, int maxRange, double safetyRating, boolean AWD, double price){
        super(mfr, color, power, numWheels, model, maxRange, safetyRating, AWD, price);
        this.rechargeTime=rechargeTime;
        this.batteryType=batteryType;
    }

    public int getRechargeTime(){
        return rechargeTime;
    }

    public String getBatteryType(){
        return batteryType;
    }

    //Displays the ElectricCar's attributes
    public String display(){
        return super.display()+ " " +getModel()+" EL"+ ", BAT: "+ getBatteryType()+ " RCH: "+ getRechargeTime() ;
    }
}