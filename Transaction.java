//Name: Kevin Tang
//Student Number: 500910586

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.lang.Math;

class Transaction{
    //Initializes variables
    private int transactionId;
    private String salesPerson;
    private String type;
    private double salePrice;
    private Car car;
    private Calendar date;

    //Sets transaction varaibles
    public Transaction(int transactionId, Calendar date, Car car, String salesPerson, String type, double salePrice){
        this.transactionId=transactionId;
        this.date= date;
        this.car= car;
        this.salesPerson=salesPerson;
        this.type=type;
        this.salePrice=salePrice;
    }

    //Displays the transaction
    public String display(){
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMM dd yyyy");
        String s="ID: "+getTransactionId()+" "+sdf.format(getDate().getTime())+" "+getType()+" SalesPerson: "+ getSalesPerson()+"  "+ getCar().display();
        return s;
    }

    //Returns transaction ID of transaction
    public int getTransactionId(){
        return transactionId;
    }

    //Returns Date of transaction
    public Calendar getDate(){
        return date;
    }

    //Returns sales person of the transaction
    public String getSalesPerson(){
        return salesPerson;
    }

    //Returns transaction car
    public Car getCar(){
        return car;
    }

    //Returns price of the car in the transaction
    public double getPrice(){
        return salePrice;
    }

    //Returns the type of transaction
    public String getType(){
        return type;
    }

    //Generates a new Transaction ID
    public void newId(){
        transactionId=(int)(Math.random()*(99-1)+1)+1;
    }
}