
package data;

/**
 *
 * @author JULIAN C
 */
public class Patient extends Person{
    
    private String sex;
    private int sports;
    
    //Builders
    
    public Patient(String user, String password, String email) {
        super(user, password, email);
    }
    
    public Patient(String user, String password, String email, String sex, int sports) {
        super(user, password, email);
        this.sex = sex;
        this.sports = sports;
    }
    //methods

        
    //Setters & Getters

    
    
    
}
