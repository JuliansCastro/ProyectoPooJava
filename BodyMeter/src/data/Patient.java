package data;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import logicBusiness.AnthropometricMeasurement;
import logicBusiness.ExportData;

/*
 * @author ANONYMOUS
 * @author JULIAN C
 * @author DANIEL R
 * @author JUAN B
 */
public class Patient extends User implements ExportData {

    private final String nameDoc = "userProfile.txt";
    private final String pathfile = new File("").getAbsolutePath() + "\\src\\resources\\base\\" + nameDoc;
    private String age, sports;
    AnthropometricMeasurement measurements = new AnthropometricMeasurement();
    private final BufferedReader bufferRead = null;


    /* ----------- BUILDER ----------------------------------------------------*/
    public Patient() {
    }

    public Patient(String id, String userType, String name, String lastName, String sex,
            String birthdate, String phone, String email, String age, String sports) {
        super(id, userType, name, lastName, sex, birthdate, phone, email);
        this.age = age;
        this.sports = sports;
    }

    /*----------- METHODS -----------------------------------------------------*/
    public void listPatients() throws Exception {
        System.out.println("\nLISTA DE PACIENTES ");//(Default: (user: jul psw: 1234))");
        System.out.println("------------------\n");

        System.out.println(getListOfPatientData());

    }

    @Override
    public void createReport() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        String tempAge = getAge();
        String tempSport = getSports();

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
            writeTXT.print(Arrays.toString(encrypt(tempAge)));
            writeTXT.print("\t");
            writeTXT.println(Arrays.toString(encrypt(tempSport)));

            fw.close();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        /*
        try (FileWriter fw = new FileWriter("patientDataTestFile.txt", true);
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
            writeTXT.print(tempAge);
            writeTXT.print("\t");
            writeTXT.println(tempSport);

            fw.close();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }*/
    }


    /*----------- SETTERS & GETTERS -------------------------------------------*/
    public AnthropometricMeasurement getMeasurements() {
        return measurements;
    }

    public void setMeasurements(AnthropometricMeasurement measurements) {
        this.measurements = measurements;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSports() {
        return sports;
    }

    public void setSports(String sports) {
        this.sports = sports;
    }

}
