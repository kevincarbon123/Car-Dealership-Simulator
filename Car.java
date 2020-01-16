//Name: Kevin Tang
//Student Number: 500910586
import java.lang.Comparable;

public class Car extends Vehicle implements Comparable<Car>
{
  private int model;
  private int maxRange;
  private double safetyRating;
  private boolean AWD;
  private double price;
  private final int SEDAN=0;
  private final int SUV=1;
  private final int SPORTS=2;
  private final int MINIVAN=3;


  //Car costructor method
  public Car(){
    super();
    model=0;
    maxRange=0;
    safetyRating=0.0;
    AWD=false;
    price=0.0;
  }

  //Sets car varaibles
  public Car(String mfr, String color, int power, int numWheels, int model, int maxRange, double safetyRating, boolean AWD, double price){
    super(mfr, color, power, numWheels);
    this.model=model;
    this.maxRange=maxRange;
    this.safetyRating=safetyRating;
    this.AWD=AWD;
    this.price=price;
  }

  public int getModel(){
    return model;
  }

  public int getMaxRange(){
    return maxRange;
  }

  public double getSafetyRating(){
    return safetyRating;
  }

  public boolean getAWD(){
    return AWD;
  }

  public double getPrice(){
    return price;
  }

  //Checks which model the car is and displays car attributes
  public String display(){
    String modelName=" ";
    if (model==SEDAN){
      modelName="SEDAN";
    }
    if (model==SUV){
      modelName="SUV";
    }
    if (model==SPORTS){
      modelName="SPORTS";
    }
    if (model==MINIVAN){
      modelName="MINIVAN";
    }
    return super.display()+ " " +modelName+" "+ getPrice()+ "$ "+ "SF: "+ getSafetyRating()+" RNG: "+ getMaxRange(); 
  }

  //Compares 2 car objects by awd mfg and numWheels
  public boolean equals(Car other){
    
    if(this.getMfr()==other.getMfr() && this.getPower()==other.getPower() && this.getNumOfWheels()== other.getNumOfWheels() && this.model ==other.getModel() && this.AWD==other.getAWD() ){
      return true;
    }
    return false;
  }

  //Compares 2 car objects by price
  public int compareTo(Car other){
    
    if(this.price== other.getPrice()){
      return 1;
    }
    else {
      return 0;
    }
  }
}