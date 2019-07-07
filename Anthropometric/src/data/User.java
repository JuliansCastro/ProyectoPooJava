package data;

import java.util.Date;

/*
 * @author JULIAN C
 * @author DANIEL R
 * @author JUAN B
 */
public class User {
    
    private String name, lastName, id;
    private Date birtday;
    private String user, password, phone, email;
    private boolean userType;
    
    /* ----------- BUILDER ------------------------------------------------------------------------------------------------------*/    

    public User(String user, String password, String email, boolean userType) {
        this.user = user;
        this.password = password;
        this.email = email;
        this.userType = userType;
    }

        
    public User(String name, String lastName, String id, Date birtday, String user, String password, String phone, String email, boolean userType) {
        this.name = name;
        this.lastName = lastName;
        this.id = id;
        this.birtday = birtday;
        this.user = user;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.userType = userType;
    }
    
    
    
    /* ----------- METHODS ------------------------------------------------------------------------------------------------------*/
    
    
    /* ----------- SETTERS & GETTERS --------------------------------------------------------------------------------------------*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getBirtday() {
        return birtday;
    }

    public void setBirtday(Date birtday) {
        this.birtday = birtday;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isUserType() {
        return userType;
    }

    public void setUserType(boolean userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        
        if(userType == true){
            return "Nombre del paciente: " + name + " " + lastName + " Id: " + id + " Fecha Nacimiento: "+ birtday 
                + " Usuario: " + user + " Teléfono: " + phone + " Correo: " + email;
        }else{
            return "Nombre del medico: " + name + " " + lastName + " Id: " + id + " Fecha Nacimiento "+ birtday 
                + " Usuario: " + user + " Teléfono: " + phone + "  Correo: " + email;
        }
    }

    
    
    
}

