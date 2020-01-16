//Name: Kevin Tang
//Student Number: 500910586

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Calendar;


public class CarDealership{
    //Initializes variables
    private ArrayList<Car> cars;
    private ArrayList<Car> temp;
    private boolean electricCar, awd, priceFilter; 
    private double minPrice=0;
    private double maxPrice=0;
    private ArrayList<Car> tempCar = new ArrayList<Car>();
    private SalesTeam salesTeam= new SalesTeam();
    private AccountingSystem accountingSystem= new AccountingSystem();
    private Calendar date;
    private int day;
    private int month;
    private boolean transList;

    //Contructor initializes car arraylist and temp arraylist
    public CarDealership(){
        cars=new ArrayList<Car>();
        temp = new ArrayList<Car>();
    }

    //Adds all cars from carList into cars and temp
    public void addCars(ArrayList<Car> newCars){
        cars.addAll(newCars);
        temp.addAll(newCars);
        tempCar.addAll(newCars);
    }

    //Calls transactionEmpty method
    public boolean transEmpty(){
        transList=accountingSystem.transactionEmpty();
        return transList;
    }

    //Removes car from carList and crates transaction in accountingsystem
    public String buyCar(int VIN){
        for(int i=0;i<cars.size();i++){
            if(cars.get(i).getVIN()==VIN){
                Car car=cars.get(i);
                cars.remove(i);
                day=(int)(Math.random()*(15-1)+1)+1;
                month=(int)(Math.random()*(9-1)+1)+1;
                String salesPerson=salesTeam.getPerson();
                date=new GregorianCalendar(2019,month,day);
                String type="BUY";
                Double salePrice=car.getPrice();
                return accountingSystem.add( date,  car,  salesPerson,  type,  salePrice);
            }
        }
        return null;
    }

    //Calls getBoughtCarTransId method
    public int transIdOfBoughtCar(){
        return accountingSystem.getBoughtCarTransId();
    }

   //Takes the transaction id of the last car bought then returns the car to the carList
   //also adds a trnasction to accountingsystem
   public void returnCar(int trans){
        Transaction transaction =accountingSystem.getTransaction(trans);
        transaction.display();
        date=new GregorianCalendar(2019,month,day+(int)(Math.random()*(10-1)+1)+1);
        Car transCar=transaction.getCar();
        String salesPerson=transaction.getSalesPerson();
        String type="RET";
        double salePrice=transaction.getCar().getPrice();
        System.out.println(accountingSystem.add( date,  transCar,  salesPerson,  type,  salePrice));
        cars.add(transCar);
   }

   //Gets then prints all sales of the year
   public void getSales(){
       accountingSystem.transactions2019();
   }

   //Prints all people in the sales team
   public void salesTeam(){
       System.out.println(salesTeam.display());
   }

   //Gets then prints all transactions of the month
   public void getTransactionsOfMonth(int month){
       accountingSystem.monthTransactions(month);
   }

   //Gets then prints sales stats
   public void getSalesStats(){
       accountingSystem.salesProfit();
       accountingSystem.highestSalesMonth();
       System.out.println("Total Sales: " +accountingSystem.getTotalProfit()+" Total Sold: "+ accountingSystem.getNumOfCars()+" Avg Sales: "+ accountingSystem.totalMonthlyProfit()+" Total Returned: "+ accountingSystem.getTimesReturned()+ " Best Month: "+ accountingSystem.getBestMonth()+": Cars sold - "+ accountingSystem.getHighestMonth());
   }
   
   //Gets then prints top sales person(s) and number of cars they sold
   public void getTopSp(){
       String x = salesTeam.getTopSP();
       if (x.contains(" ")){
        System.out.println("Top SP: "+x);
        System.out.println("Cars Sold: " + salesTeam.getSalesRecord());
       }else{
           System.out.println("Top SP: "+x);
       }
   }

    //Clears all filters
    public void filtersClear(){
        electricCar=false;
        awd=false;
        priceFilter=false;
        minPrice=0.0;
        maxPrice=0.0;
        cars.clear();
        cars.addAll(temp);
    }

    //Sets pricefilter to true and assigns the min and max price to maxPrice and minPrice
    public void setPriceFilter(double a, double b){
        maxPrice = b;
        minPrice = a;
        priceFilter=true;
    }
    //Sets awd filter to true
    public void setAWD(){
        awd=true;
    }


    //Sets electricCar to true
    public void setElectric(){
        electricCar=true;
    }

    //Sorts carList by increasing range
    public void sortByMaxRange(){
        Collections.sort(cars,new SortByRange());
    }

    //Sorts carList by increasing safty rating
    public void sortBySafetyRating(){
        Collections.sort(cars,new SortBySafety());
    }

    //Sorts carList by increasing price
    public void sortByPrice(){
        Collections.sort(cars, new SortPrice());
    }

    //Uses comparator to sort range of cars
    class SortByRange implements Comparator<Car>{
        public int compare(Car c1, Car c2){
          
          if (c1.getMaxRange() > c2.getMaxRange()){
              return 1;
          }else if (c1.getMaxRange() < c2.getMaxRange()){
              return -1;
          }
          return 0;
        }
    }

    //Uses comparator to sort safetyrating of cars
    class SortBySafety implements Comparator<Car>{ 
        public int compare(Car c1,Car c2){
            if (c1.getSafetyRating() > c2.getSafetyRating()){
                return 1;
            }else if (c1.getSafetyRating() < c2.getSafetyRating()){
                return -1;
            }
            return 0;
        }
    }

    //Uses comparator to sort price of cars
    class SortPrice implements Comparator<Car>{
        public int compare(Car c1, Car c2){
            if (c1.getPrice() > c2.getPrice()){
                return 1;
            }else if (c1.getPrice() < c2.getPrice()){
                return -1;
            }
            return 0;
        }
    }

    //Displays carList depending on which filters or sorts have been set
    public void displayInventory(){
        ArrayList<Integer> tempIndex = new ArrayList<Integer>();

        if(priceFilter){
            for(int carNumber=0;carNumber<cars.size();carNumber++){
                if(cars.get(carNumber).getPrice()>= maxPrice || cars.get(carNumber).getPrice()<= minPrice){
                    if (!tempIndex.contains(carNumber)){
                        tempIndex.add(carNumber);
                    }
                 }
            }
        }
        if(awd){
            for(int carNumber=0;carNumber<cars.size();carNumber++){
                if (cars.get(carNumber).getAWD() == false){
                    if (!tempIndex.contains(carNumber)){
                        tempIndex.add(carNumber);
                    }
                } 
            }
        }
        if(electricCar){
            for(int carNumber=0;carNumber<cars.size();carNumber++){
                if (cars.get(carNumber).getPower() != cars.get(carNumber).ELECTRONIC_MOTOR){
                    if (!tempIndex.contains(carNumber)){
                        tempIndex.add(carNumber);
                    }
                }
            }
        }
    

        if(!tempIndex.isEmpty()){
            for (int x = tempIndex.size() -1; x > -1; x--){
                int index = tempIndex.get(x);
                cars.remove(index);
            }
        }
        
       for(int x=0;x<cars.size();x++){
            System.out.println(cars.get(x).display());
        }

    }
}