/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package user_accounts;

/**
 * Mechanic class, extension of User
 * @author hnaro
 */
public class Mechanic extends User {
    
    private double hourlyRate;
    
    public Mechanic(User user) {
        super(user);
    }
    
    // getter method
    public double getHourlyRate() {
        return hourlyRate;
    }
    
    // setter method
    public void setHourlyRate(double hr) {
        hourlyRate = hr;
    }
    
}
