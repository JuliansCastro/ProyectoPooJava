
package data;

/*
 * @author ANONYMOUS
 * @author JULIAN C
 * @author DANIEL R
 * @author JUAN B
 */

public class Patient extends User{
    
    private int age;
    private boolean sports;
    
   // private An

        
    /* ----------- BUILDER ------------------------------------------------------------------------------------------------------*/    
    
    public Patient() {
    }

    public Patient(String id, boolean userType, String name, String lastName, int sex, String birthdate, String phone, String email, int age, boolean sports) {
        super(id, userType, name, lastName, sex, birthdate, phone, email);
        this.age = age;
        this.sports = sports;
    }
    
    /* ----------- METHODS ------------------------------------------------------------------------------------------------------*/
    
    
    
    /* ----------- SETTERS & GETTERS --------------------------------------------------------------------------------------------*/

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSports() {
        return sports;
    }

    public void setSports(boolean sports) {
        this.sports = sports;
    }

}
