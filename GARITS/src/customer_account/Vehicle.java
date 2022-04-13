/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package customer_account;

/**
 *
 * @author hnaro
 */
public class Vehicle {
    
    private String registrationNo;
    private String make;
    private String model;
    private String engSerial;
    private String chassisNo;
    private String colour;
    private String nextMoTDate;
    private String nextServiceDate;
    
    public Vehicle(){
        
    }
    
    public Vehicle(String registrationNo, String make, String model, String engSerial, String chassisNo, String colour, 
            String nextMoTDate, String nextServiceDate) {
        this.registrationNo = registrationNo;
        this.make = make;
        this.model = model;
        this.engSerial = engSerial;
        this.chassisNo = chassisNo;
        this.colour = colour;
        this.nextMoTDate = nextMoTDate;
        this.nextServiceDate = nextServiceDate;
    }
    
    /**
     * Setters
     */
    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }
    
    public void setMake(String make) {
        this.make = make;
    }
    
    public void setModel(String model) {
        this.model = model;
    }
    
    public void setEngSerial(String engSerial) {
        this.engSerial = engSerial;
    }
    
    public void setChassisNo(String chassisNo) {
        this.chassisNo = chassisNo;
    }
    
    public void setColour(String colour) {
        this.colour = colour;
    }
    
    public void setNextMoTDate(String nextMoTDate) {
        this.nextMoTDate = nextMoTDate;
    }
    
    public void setNextServiceDate(String nextServiceDate) {
        this.nextServiceDate = nextServiceDate;
    }
    
    /**
     * Getters
     */
    public String getRegistrationNo() {
        return registrationNo;
    }
    
    public String getMake() {
        return make;
    }
    
    public String getModel() {
        return model;
    }
    
    public String getEngSerial() {
        return engSerial;
    }
    
    public String getChassisNo() {
        return chassisNo;
    }
    
    public String getColour() {
        return colour;
    }
    
    public String getNextMoTDate() {
        return nextMoTDate;
    }
    
    public String getNextServiceDate() {
        return nextServiceDate;
    }
    
}
