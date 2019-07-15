
package data;

/*
 * @author ANONYMOUS
 * @author JULIAN C
 * @author DANIEL R
 * @author JUAN B
 */

public class Nutritionist extends User{

    private int yearsOfExperience;
    private String professionalCard;
    
    /* ----------- BUILDER ------------------------------------------------------------------------------------------------------*/    

    public Nutritionist() {
    }

    public Nutritionist(String id, boolean userType, String name, String lastName, int sex, String birthdate, String phone, String email, int yearsOfExperience, String professionalCard) {
        super(id, userType, name, lastName, sex, birthdate, phone, email);
        this.yearsOfExperience = yearsOfExperience;
        this.professionalCard = professionalCard;
    }

    /* ----------- METHODS ------------------------------------------------------------------------------------------------------*/
    /* ----------- SETTERS & GETTERS --------------------------------------------------------------------------------------------*/

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getProfessionalCard() {
        return professionalCard;
    }

    public void setProfessionalCard(String professionalCard) {
        this.professionalCard = professionalCard;
    }

    
    
    
}
