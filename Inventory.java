import java.util.ArrayList;
import java.util.Scanner;

public class Inventory{
    private static int carNum;
    private static int truckNum;
    private String newMake;
    private String newModel;
    private String newYear;
    private String newPrice;
    private int newSerial;
    
    private int profit;
    
    Scanner input = new Scanner(System.in);
    
    ArrayList<Car> cars = new ArrayList<Car>();
    ArrayList<Truck> trucks = new ArrayList<Truck>();
    
    public void main(String[] args){
        do{
            menu();
        }
        while(!input.next().equals("done"));
    }
    
    public void menu(){
        System.out.println();
        System.out.println("Press 1 to create vehicle. Press 2 to print inventory. Press 3 to sell a vehicle. Press 4 to print overall profit.");
        String answer = input.next();
        
        if (answer.equals("1")){
            System.out.println("Car or Truck?");
            String type = input.next().toLowerCase();
            if (type.equals("car")){
              createCar();
            }
            else if (type.equals("truck")){
              createTruck();
            }
            else{ //will keep on asking until user puts in valid input
                System.out.println(type + " is not a valid entry. Please enter either 'car' or 'truck.'");
                while (!(type.equals("car") || type.equals("truck"))){
                    System.out.println("Car or Truck?");
                    type = input.next().toLowerCase();
                }
                if (type.equals("car")){
                  createCar();
                }
                else if (type.equals("truck")){
                  createTruck();
                }
            }
            menu();
        }
        else if (answer.equals("2")){
            printVehicles();
            menu();
        }
        else if (answer.equals("3")){
            sellVehicle();
            menu();
        }
        else if (answer.equals("4")){
            System.out.println("$" + profit);
            menu();
        }
        else{
            if (!answer.equals("done")){
            System.out.println(answer + " is not a valid entry.");
            menu();
          }
        }
    }
    
    
    public void createCar(){
        Car newCar = new Car();
        
        System.out.println("Enter the make.");
        newCar.setMake(input.next());
        System.out.println("Enter the model.");
        newCar.setModel(input.next());
        System.out.println("Enter the year.");
        newCar.setYear(input.next());
        System.out.println("Enter the price.");
        String thisPrice = input.next();
        if (!thisPrice.matches(".*[a-z].*")){ //to check to make sure the price doesn't contain letters
            if (thisPrice.indexOf(",") < 0){ //checking to see if the price was entered with commas
                newCar.setPrice(thisPrice);
            }
            else{ //if the price was entered with commas, the commas are taken out 
                StringBuilder commaPrice = new StringBuilder(thisPrice);
                while (commaPrice.indexOf(",") > -1){
                    commaPrice.deleteCharAt(commaPrice.indexOf(","));
                }
                newCar.setPrice(commaPrice.toString());
            }
        }
        else{
            while (thisPrice.matches(".*[a-z].*")){ //to ask for the price until a valid one is entered
                System.out.println(thisPrice + " is an invalid entry.");
                System.out.println("Enter the price.");
                thisPrice = input.next();
            }
            if (thisPrice.indexOf(",") < 0){ //checking to see if the price was entered with commas
                newCar.setPrice(thisPrice);
            }
            else{ //if the price was entered with commas, the commas are taken out 
                StringBuilder commaPrice = new StringBuilder(thisPrice);
                while (commaPrice.indexOf(",") > -1){
                    commaPrice.deleteCharAt(commaPrice.indexOf(","));
                }
                newCar.setPrice(commaPrice.toString());
            }
        }
        System.out.println("Enter the color.");
        newCar.setColor(input.next());
        newCar.setSerial(carNum + 10000);
        
        cars.add(newCar);
        carNum++;
    }
    
    public void createTruck(){
        Truck newTruck = new Truck();
        
        System.out.println("Enter the make.");
        newTruck.setMake(input.next());
        System.out.println("Enter the model.");
        newTruck.setModel(input.next());
        System.out.println("Enter the year.");
        newTruck.setYear(input.next());
        System.out.println("Enter the price.");
        String thisPrice = input.next();
        if (!thisPrice.matches(".*[a-z].*")){ // to check to make sure the price doesn't contain letters
            if (thisPrice.indexOf(",") < 0){ //checking to see if the price was entered with commas
                newTruck.setPrice(thisPrice);
            }
            else{ //if the price was entered with commas, the commas are taken out 
                StringBuilder commaPrice = new StringBuilder(thisPrice);
                while (commaPrice.indexOf(",") > -1){
                    commaPrice.deleteCharAt(commaPrice.indexOf(","));
                }
                newTruck.setPrice(commaPrice.toString());
            }
        }
        else{
            while (thisPrice.matches(".*[a-z].*")){ //to ask for the price until a valid one is entered
                System.out.println(thisPrice + " is an invalid entry.");
                System.out.println("Enter the price.");
                thisPrice = input.next();
            }
            if (thisPrice.indexOf(",") < 0){ //checking to see if the price was entered with commas
                newTruck.setPrice(thisPrice);
            }
            else{ //if the price was entered with commas, the commas are taken out 
                StringBuilder commaPrice = new StringBuilder(thisPrice);
                while (commaPrice.indexOf(",") > -1){
                    commaPrice.deleteCharAt(commaPrice.indexOf(","));
                }
                newTruck.setPrice(commaPrice.toString());
            }
        }
        System.out.println("Enter the load capacity.");
        newTruck.setLoad(input.next());
        newTruck.setSerial(truckNum + 20000);
        
        trucks.add(newTruck);
        truckNum++;
    }
    
    public void printVehicles(){
        System.out.println("Cars: ");
        for (Car car : cars){
            car.printVehicle();
        }
        
        System.out.println("Trucks: ");
        for (Truck truck : trucks){
            truck.printVehicle();
        }
    }
    
    public void sellVehicle(){
        System.out.println("What is the serial number of the vehicle you want to sell?");
        String serial = input.next();
        boolean serialExist = false;
        
        //checking to see if the serial number entered belongs to a vehicle in the inventory
        if(!serial.matches(".*[a-z].*")){ //will only do this if serial number doesn't have letters
            for (Car car : cars){
                if (car.getSerial() == Integer.parseInt(serial)){
                    serialExist = true;
                    break;
                }
            }
            for (Truck truck : trucks){
                if (truck.getSerial() == Integer.parseInt(serial)){
                    serialExist = true;
                    break;
                }
            }
        }
        if (serialExist == false || serial.matches(".*[a-z].*")){ //checking if serialExist never became true and/or if there's letters
            System.out.println(serial + " is an invalid serial number.");
            sellVehicle();
        }
        
        if (serial.substring(0,1).equals("1")){
            int index = 0;
            int price = 0;
            int thisSerial = Integer.parseInt(serial);
            for (Car car : cars){
                if (car.getSerial() == thisSerial){
                    index = cars.indexOf(car);
                    price = car.getPrice();
                }
            }
            
            double sellPrice = price + price/3;
            System.out.println("This vehicle is being sold for $" + sellPrice + ". Enter 'buy' to purchase or 'cancel' to not.");
            String buy = input.next().toLowerCase();
            if (buy.equals("buy")){
                cars.remove(index);
                profit += sellPrice - price;
                System.out.println("You successfully bought this vehicle.");
                menu();
            }
            else{
                menu();
            }
        }
        if (serial.substring(0,1).equals("2")){
            int index = 0;
            int price = 0;
            int thisSerial = Integer.parseInt(serial);
            for (Truck truck : trucks){
                if (truck.getSerial() == thisSerial){
                    index = trucks.indexOf(truck);
                    price = truck.getPrice();
                }
            }
            
            double sellPrice = price + price/3;
            System.out.println("This vehicle is being sold for $" + sellPrice + ". Enter 'buy' to purchase or 'cancel' to not.");
            String buy = input.next().toLowerCase();
            if (buy.equals("buy")){
                trucks.remove(index);
                profit += sellPrice - price;
                System.out.println("You successfully bought this vehicle.");
                menu();
            }
            else{
                menu();
            }
        }
    }
    
}
