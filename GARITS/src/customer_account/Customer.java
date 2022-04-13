/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package customer_account;

/**
 *
 * @author hnaro
 */
public class Customer {
    
    private String ID;
    private String fname;
    private String lname;
    private String address;
    private String postcode;
    private String email;
    private String telephone;
    
    public Customer() {
    }

    /**
     * Setters
     *
     * @param ID
     */
    public void setID(String ID){
        this.ID = ID;
    }
    
    /**
     *
     * @param fname
     */
    public void setFname(String fname){
        this.fname = fname;
    }
    
    /**
     *
     * @param lname
     */
    public void setLname(String lname){
        this.lname = lname;
    }
    
    /**
     *
     * @param email
     */
    public void setEmail(String email){
        this.email = email;
    }
    
    /**
     *
     * @param phone
     */
    public void setPhone(String telephone){
        this.telephone = telephone;
    }
    
    /**
     *
     * @param name
     */
    public void setAddress(String address){
        this.address = address;
    }
    
    /**
     *
     * @param name
     */
    public void setPostcode(String postcode){
        this.postcode = postcode;
    }
    
    /**
     * Getters
     */
    public String getID(){
        return ID;
    }
    
    public String getFname(){
        return fname;
    }
    
    public String getLname(){
        return lname;
    }
    
    public String getEmail(){
        return email;
    }
    
    public String getTelephone(){
        return telephone;
    }
    
    public String getAddress(){
        return address;
    }
    
    public String getPostcode(){
        return postcode;
    }
    
}
