/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package user_accounts;

/**
 * User class, holds all information about user.
 * @author hnaro
 */
public class User {
    
    private String name;
    private String role;
    private String username;
    private String password;
    
    public User() {
    }
    
    public User(User user) {
        setName(user.getName());
        setRole(user.getRole());
        setUsername(user.getUsername());
        setPassword(user.getPassword());
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
