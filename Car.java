public class Car extends Vehicle{
    private String color;
    
    public Car(){
    }
    
    public void setColor(String color){
        this.color = color;
    }
    
    public String getColor(){
        return this.color;
    }
    
    public void printVehicle(){
        super.printVehicle(this.color);
    }
}
