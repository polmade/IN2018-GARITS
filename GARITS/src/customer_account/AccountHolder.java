/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package customer_account;

/**
 *
 * @author hnaro
 */
public class AccountHolder extends Customer {
    
    private boolean payLater = false;
    private String discountType;
    
    public AccountHolder() {
    }
    
    /**
     * Setters
     */
    public void setPayLater(boolean payLater) {
        this.payLater = payLater;
    }
    
    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }
    
    /**
     * Getters
     */ 
    public boolean getPayLater() {
        return payLater;
    }
    
    public String getDiscountType() {
        return discountType;
    }
    
}
