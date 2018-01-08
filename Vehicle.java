public class Vehicle{
    private String make;
    private String model;
    private String year;
    private int price;
    private int serial;
    
    public Vehicle(){
        
    }
    
    public void setPrice(String price){
        this.price = Integer.parseInt(price);
    }
    
    public int getPrice(){
        return this.price;
    }
    
    public void setMake(String make){
        this.make = make;
    }
    
    public String getMake(){
        return this.make;
    }
    
    public void setModel(String model){
        this.model = model;
    }
    
    public String getModel(){
        return this.model;
    }
    
    public void setYear(String year){
        this.year = year;
    }
    
    public String getYear(){
        return this.year;
    }
    
    public void setSerial(int serial){
        this.serial = serial;
    }
    
    public int getSerial(){
        return this.serial;
    }
    
    public void printVehicle(String quality){
        System.out.println(this.serial + ": " + this.make + ", " + this.model + ", " + this.year + ", $" + this.price + ", " + quality);
    }
    
}
