package data;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

/*
 * @author ANONYMOUS
 * @author JULIAN C
 * @author DANIEL R
 * @author JUAN B
 */
public class Nutritionist extends User {

    private final String nameDoc = "userProfile.txt";
    //private String pathfile = Paths.get("D:\\Archivos\\"+nameDoc);
    private final String pathfile = new File("").getAbsolutePath() + "\\src\\resources\\base\\" + nameDoc;
    private String yearsOfExperience, professionalCard;
    
    Patient patient = new Patient();

    /* ----------- BUILDER ------------------------------------------------------------------------------------------------------*/
    public Nutritionist() {
    }

    public Nutritionist(String id, String userType, String name, String lastName,
            String sex, String birthdate, String phone, String email, String yearsOfExperience, String professionalCard) {
        super(id, userType, name, lastName, sex, birthdate, phone, email);
        this.yearsOfExperience = yearsOfExperience;
        this.professionalCard = professionalCard;
    }

    /* ----------- METHODS ------------------------------------------------------------------------------------------------------*/
    
    public void listNutritionist() throws Exception {
        System.out.println("\nLISTA DE NUTRICIONISTAS ");//(Default: (user: jul psw: 1234))");
        System.out.println("-------------------------\n");
        System.out.println(getListOfNutritionistsData());

    }
    
    @Override
    public void saveData() throws Exception { //Save only User profile

        String tempId = getId();
        String tempUserType = getUserType();
        String tempName = getName();
        String tempLastname = getLastName();
        String tempSex = getSex();
        String tempBirthday = getBirthdate();
        String tempPhone = getPhone();
        String tempEmail = getEmail();
        String tempYearsExperience = getYearsOfExperience();
        String tempProfessionalCard = getProfessionalCard();

        try (FileWriter fw = new FileWriter(pathfile, true);
                PrintWriter writeTXT = new PrintWriter(fw)) {
            deleteDataUser(tempId);
            writeTXT.print(Arrays.toString(encrypt(tempId)));
            writeTXT.print("\t");
            writeTXT.print(Arrays.toString(encrypt(tempUserType)));
            writeTXT.print("\t");
            writeTXT.print(Arrays.toString(encrypt(tempName)));
            writeTXT.print("\t");
            writeTXT.print(Arrays.toString(encrypt(tempLastname)));
            writeTXT.print("\t");
            writeTXT.print(Arrays.toString(encrypt(tempSex)));
            writeTXT.print("\t");
            writeTXT.print(Arrays.toString(encrypt(tempBirthday)));
            writeTXT.print("\t");
            writeTXT.print(Arrays.toString(encrypt(tempPhone)));
            writeTXT.print("\t");
            writeTXT.print(Arrays.toString(encrypt(tempEmail)));
            writeTXT.print("\t");
            writeTXT.print(Arrays.toString(encrypt(tempYearsExperience)));
            writeTXT.print("\t");
            writeTXT.println(Arrays.toString(encrypt(tempProfessionalCard)));

            fw.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        /*
        try (FileWriter fw = new FileWriter("nutritionistDataTestFile.txt", true);
                PrintWriter writeTXT = new PrintWriter(fw)) {
            //Login.deleteUser(user);
            writeTXT.print(tempId);
            writeTXT.print("\t");
            writeTXT.print(tempUserType);
            writeTXT.print("\t");
            writeTXT.print(tempName);
            writeTXT.print("\t");
            writeTXT.print(tempLastname);
            writeTXT.print("\t");
            writeTXT.print(tempSex);
            writeTXT.print("\t");
            writeTXT.print(tempBirthday);
            writeTXT.print("\t");
            writeTXT.print(tempPhone);
            writeTXT.print("\t");
            writeTXT.print(tempEmail);
            writeTXT.print("\t");
            writeTXT.print(tempYearsExperience);
            writeTXT.print("\t");
            writeTXT.println(tempProfessionalCard);

            fw.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }*/
    }
    /* ----------- SETTERS & GETTERS --------------------------------------------------------------------------------------------*/
    public String getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(String yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getProfessionalCard() {
        return professionalCard;
    }

    public void setProfessionalCard(String professionalCard) {
        this.professionalCard = professionalCard;
    }

   

}
