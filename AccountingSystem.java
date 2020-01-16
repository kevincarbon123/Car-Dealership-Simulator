//Name: Kevin Tang
//Student Number: 500910586

import java.util.Comparator;
import java.lang.Math;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.text.DateFormat;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;


class AccountingSystem{
    //Initializes variables
    private ArrayList<Transaction> allTransactions;
    private double totalProfit;
    private int totalMonthlyProfit;
    private int numOfCars;
    private String bestMonth;
    private int highestMonth;
    private int transID;
    private int month;
    private int timesRet;
    private int topSpSales;
    

    //Constructor 
    public AccountingSystem(){
        allTransactions=new ArrayList<Transaction>();
        totalProfit=0.0;
        totalMonthlyProfit=0;
        numOfCars=0;
        bestMonth="";
        highestMonth=0;
        topSpSales=0;
        transID=(int)(Math.random()*(99-1)+1)+1;
    }
    
    //Checks of transactions list is empty
    public boolean transactionEmpty(){
        if(allTransactions.isEmpty()){
            return true;
        }
        return false;
    }

    //Adds transaction to the transactions list
    public String add(Calendar date, Car car, String salesPerson, String type, double salePrice){
        if(type.equals("BUY")){
            transID=(int)(Math.random()*(99-1)+1)+1;
        }
        Transaction transaction=new Transaction( transID,  date,  car,  salesPerson,  type,  salePrice);       
        allTransactions.add(transaction);

        return transaction.display();
    }

    //Get the bought car's trnasaction ID
    public int getBoughtCarTransId(){
        return transID;
    }

    //Gets total number of transactions
    public Transaction getTransaction(int id){
        for(int i=0;i<allTransactions.size();i++){
            if(allTransactions.get(i).getTransactionId()==id){
                timesRet+=1;
                return allTransactions.get(i);
            }
        }
        return null;
    }

    //Prints all trnasactions of 2019
    public void transactions2019(){
        for(int i=0;i<allTransactions.size();i++){
            if(allTransactions.get(i).getDate().get(Calendar.YEAR)==2019){
                if(allTransactions.get(i).getType().equals("RET")){
                    allTransactions.get(i).newId();
                    System.out.println(allTransactions.get(i).display());
                }
                else{
                    System.out.println(allTransactions.get(i).display());
                }
            }
        }
    }

    //Returns number of cars the top sales person sold
    public int getTopSPnum(){
        return topSpSales;
    }

    //Prints all transactions of the a specified month
    public void monthTransactions(int month){
        for (int i=0;i<allTransactions.size();i++){
            if(allTransactions.get(i).getDate().get(Calendar.MONTH)==month){
                System.out.println(allTransactions.get(i).display());
            }
        }
    }

    //Calculates number of cars sold and average profits per month
    public void salesProfit(){
        for (int i=0;i<allTransactions.size();i++){
            totalProfit+=allTransactions.get(i).getPrice();
            if(allTransactions.get(i).getType().equals("BUY")){
                numOfCars+=1;
            }
        }
        totalMonthlyProfit=(int)(totalProfit/12);
    }

    //Returns total number of times user has returned a car
    public int getTimesReturned(){
        return timesRet;
    }

    //Returns total profits of the year
    public double getTotalProfit(){
        return totalProfit;
    }

    //Returns number of cars sold
    public int getNumOfCars(){
        return numOfCars;
    }

    //Returns average profit per month
    public int totalMonthlyProfit(){
        return totalMonthlyProfit;
    }

    //Calculates month with highest sales
    public void highestSalesMonth(){
        int c=0;
        HashMap<Integer, Integer> months= new HashMap<Integer, Integer>();
        for (int i=0;i<12;i++){
            c+=1;
            months.put(c,0);
        }
        
        for (int i=0;i<allTransactions.size();i++){
            if(months.containsKey(allTransactions.get(i).getDate().get(Calendar.MONTH))){
                months.replace(allTransactions.get(i).getDate().get(Calendar.MONTH),months.get(allTransactions.get(i).getDate().get(Calendar.MONTH)),months.get(allTransactions.get(i).getDate().get(Calendar.MONTH))+1);
            }
        }

        for (int i=0;i<allTransactions.size();i++){
            int value=months.get(allTransactions.get(i).getDate().get(Calendar.MONTH));
            if(highestMonth<value){
                month=allTransactions.get(i).getDate().get(Calendar.MONTH);
                highestMonth=value;
            }
        }
        DateFormat sdf= new SimpleDateFormat("MMMM");
        GregorianCalendar calendar=new GregorianCalendar();
        calendar.set(Calendar.MONTH,month);
		bestMonth=sdf.format(calendar.getTime());
   }

   //Gets month with highest sales
   public String getBestMonth(){
       return bestMonth;
   }

   //Gets number of cars sold of the highest month
   public int getHighestMonth(){
       return highestMonth;
   }

    

}