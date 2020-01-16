//Name: Kevin Tang
//Student Number: 500910586

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;



public class CarDealershipSimulator 

{
		public static void main(String[] args)
  {		
	  	//Creates carList with all cars in the dealership
		ArrayList<Car>  carList= new ArrayList<Car>();
		// Create a CarDealership object
		CarDealership carDealership=new CarDealership();

		//Calls method that extracts all cars from cars.txt
		getCarsFromText(carList);
		//Calls the commandline method that calls functions based on user input
		program(carDealership,carList);
  }
	
	public static void program(CarDealership carDealership, ArrayList<Car> carList) {
		// Initialize scanner
		Scanner input= new Scanner(System.in);
		//commandLine=input.nextLine to simplify code
		//Initial string list for later use to separate price and user command
		String[] string = new String[3];
		try{
			String commandLine=input.nextLine();
			commandLine=commandLine.toUpperCase();

			// while the scanner is not "Q"
			while(!commandLine.equals("Q")){
				string =new String[3];
				//Splits string into list for BUY and FPR functions
				//Makes the first string user types into the command line
				if(commandLine.contains(" ")){
					string=commandLine.split("\\s+");
					commandLine=string[0];
				}

				if(commandLine.equals("L")){
					carDealership.displayInventory();
				}

				//Takes second string user types to buy desired car's index
				else if(commandLine.equals("BUY") && string[1]!=null){
					//boughtCar=new Car();
					int VIN=Integer.parseInt(string[1]);
					//boughtCar=carList.get(string[1]);
					String s=carDealership.buyCar(VIN);
					if(s!=null){
						System.out.println(s);
					}
				}

				//Returns car to the end of the carList
				else if(commandLine.equals("RET")) {
					if(!carDealership.transEmpty()){
						int boughtCarId=carDealership.transIdOfBoughtCar();
						carDealership.returnCar(boughtCarId);				
					}
				}

				else if(commandLine.equals("ADD")){
					carDealership.addCars(carList);
				}
			
				else if(commandLine.equals("SPR")){
					carDealership.sortByPrice();
				}

				else if(commandLine.equals("SSR")){
					carDealership.sortBySafetyRating();
				}

				else if(commandLine.equals("SMR")){
					carDealership.sortByMaxRange();
				}

				//takes second and third string user inputs and passes them into setPriceFilter 
				else if(commandLine.equals("FPR")){
					carDealership.setPriceFilter(Double.parseDouble(string[1]),Double.parseDouble(string[2]));
				}
				else if(commandLine.equals("FEL")){
					carDealership.setElectric();
				}

				else if(commandLine.equals("FAW")){
					carDealership.setAWD();
				}

				else if (commandLine.equals("FCL")){
					carDealership.filtersClear();
				}

				else if (commandLine.equals("SALES")&& string[1]==null){
					carDealership.getSales();
				}

				else if (commandLine.equals("SALES")&& string[1].equals("TEAM")){
					carDealership.salesTeam();
				}

				else if (commandLine.equals("SALES")&& string[1].equals("TOPSP")){
					carDealership.getTopSp();
				}	

				else if (commandLine.equals("SALES")&& string[1].equals("STATS")){
					carDealership.getSalesStats();
				}	
				else if (commandLine.equals("SALES")){
					carDealership.getTransactionsOfMonth(Integer.parseInt(string[1]));
				}	
				else{
					System.out.println("Invalid command");
				}
			
				commandLine=input.nextLine();
			}	
		}catch(Exception exception){
			System.out.println("Invalid input");
		}
		
		input.close();
	}
	
	//Extracts cars in cars.txt into carList
	public static void getCarsFromText(ArrayList<Car>  carList){
		try{
			File file=new File("cars.txt");
			Scanner scanner=new Scanner(file);
			Car fileCar;

			while(scanner.hasNext()){
				int model=0;
				boolean isElectric=false;
				boolean awd=false;
				String[] string=scanner.nextLine().split("\\s+");

				if(string[2].equals("SEDAN")){
					model=0;
				}
				else if(string[2].equals("SUV")){
					model=1;
				}
				else if(string[2].equals("SPORTS")){
					model=2;
				}
				else if(string[2].equals("MINIVAN")){
					model=3;
				}

				if (string[3].equals("ELECTRIC_MOTOR")){
					isElectric=true;
				}
				if(string[6].equals("4WD")){
					awd=true;
				}
	
				if(isElectric){
					fileCar=new ElectricCar(Integer.parseInt(string[8]), "Lithium", string[0], string[1],1,4, model,Integer.parseInt(string[5]),Double.parseDouble(string[4]),awd,Integer.parseInt(string[7]));
				}	
				else{
					fileCar=new Car(string[0],string[1],0,4,model,Integer.parseInt(string[5]),Double.parseDouble(string[4]),awd,Integer.parseInt(string[7]));
				}
				carList.add(fileCar);		
			}
		scanner.close();
		}
		catch(FileNotFoundException exception){
			System.out.println("File not found");
		}
			

	}
}
