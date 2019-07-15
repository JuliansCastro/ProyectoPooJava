package data;

import java.util.Date;

/*
 * @author ANONYMOUS
 * @author JULIAN C
 * @author DANIEL R
 * @author JUAN B
 */

public class User {

    private String id, user, password, name, lastName, birthdate, phone, email;
    private boolean userType; //Patient ==  TRUE
    private int sex;

    /* ----------- BUILDER ----------------------------------------------------*/
    public User() {
    }

    public User(String user, String password, String id) {
        this.user = user;
        this.password = password;
        this.id = id;
    }

    public User(String id, boolean userType, String name, String lastName, int sex,
            String birthdate, String phone, String email) {
        this.id = id;
        this.userType = userType;
        this.name = name;
        this.lastName = lastName;
        this.sex = sex;
        this.birthdate = birthdate;
        this.phone = phone;
        this.email = email;
    }

    /* ----------- METHODS ----------------------------------------------------*/
    public Date dateFormat(String date) {
        Date dateFormat = null;

        return dateFormat;
    }

    /* ----------- SETTERS & GETTERS ------------------------------------------*/
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
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

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        String toString;
        if (userType == true) {
            toString = "PACIENTE{" + "  Usuario: " + user + "   Identificación: " + id
                    + " Nombre: " + name + " Apellidos: " + lastName + " Sexo: " + sex
                    + " Fecha de nacimiento: " + birthdate + " Teléfono: " + phone
                    + " Email: " + email + '}';
        } else {
            toString = "NUTRICIONISTA{" + "  Usuario: " + user + "   Identificación: " + id
                    + " Nombre: " + name + " Apellidos: " + lastName + " Sexo: " + sex
                    + " Fecha de nacimiento: " + birthdate + " Teléfono: " + phone
                    + " Email: " + email + '}';
        }
        return toString;
    }

}
