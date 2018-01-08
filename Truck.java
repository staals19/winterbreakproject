public class Truck extends Vehicle{
    private String loadCapacity;
    
    public Truck(){
    }
    
    public void setLoad(String load){
        this.loadCapacity = load;
    }
    
    public String getLoad(){
        return this.loadCapacity;
    }
    
    public void printVehicle(){
        super.printVehicle(this.loadCapacity);
    }
}
