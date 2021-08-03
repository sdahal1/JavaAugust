public class Car {
    //member variables
    private String make;
    private String model;
    private int mileage;




    //constructor (similar to the def __init__() method in python)
    public Car(String makeInput, String modelInput){
        this.make = makeInput;
        this.model = modelInput;
        this.mileage = 0;
    }

    //constructor overloading. when using this constructors, it will require more pieces of information
    public Car(String makeInput, String modelInput, int mileageInput){
        this.make = makeInput;
        this.model = modelInput;
        this.mileage = mileageInput;
    }

    //another constructor to create a car
    public Car(){
        this.make = "Toyota";
        this.model = "Camry";
        this.mileage = 0;
    }


    //methods that a car can perform
    //STATIC-> if an object is needed to perform the method, do NOT use static. 

    //also acts like a setter to set the mileage
    public void drive(){
        this.mileage += 10;
    }

    //overloading the drive method. also acts like a setter to set the mileage
    public void drive(int numMiles){
        this.mileage += numMiles;
    }

    //getter to get mileage
    public int getMileage(){
        return this.mileage;
    }


    //get all stats about this car
    public String getCarDetails(){
        // String info = "Car Details \n Make: " + this.make + "\n Model: " + this.model + "\n Mileage: " + this.mileage;

        String info = String.format("Car Details \n Make: %s \n Model: %s \n Mileage: %s", this.make, this.model, this.mileage);
        return info;
    }



}




