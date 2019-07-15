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
    private int age;
    private int sports;
    AnthropometricMeasurement measurements = new AnthropometricMeasurement();
    private BufferedReader bufferRead = null;
    private HashMap<String, String[]> listUserProfile = new HashMap<>();

    /* ----------- BUILDER ----------------------------------------------------*/
    public Patient() {
    }

    public Patient(String id, int userType, String name, String lastName, int sex,
            String birthdate, String phone, String email, int age, int sports) {
        super(id, userType, name, lastName, sex, birthdate, phone, email);
        this.age = age;
        this.sports = sports;
    }

    /*----------- METHODS -----------------------------------------------------*/
    public void listPatients() throws Exception {
        System.out.println("\nLISTA DE PACIENTES ");//(Default: (user: jul psw: 1234))");
        System.out.println("------------------\n");
        
        readDatabase();

    }
    
    @Override
    public void createReport() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void readDatabase() throws IOException, Exception {//Read only User profile data

        try {
            bufferRead = new BufferedReader(new FileReader(nameDoc));
            String readTextLine, readId, readUserType, readName, readLastname, readSex,
                    readBirthday, readPhone, readEmail, readAge, readSport;

            while ((readTextLine = bufferRead.readLine()) != null) {

                String[] dataUserArray = readTextLine.split("\t");

                readId = dataUserArray[0];
                readId = decrypt(readId);
                readUserType = dataUserArray[1];
                readUserType = decrypt(readUserType);
                readName = dataUserArray[2];
                readName = decrypt(readName);
                readLastname = dataUserArray[3];
                readLastname = decrypt(readLastname);
                readSex = dataUserArray[4];
                readSex = decrypt(readSex);
                readBirthday = dataUserArray[5];
                readBirthday = decrypt(readBirthday);
                readPhone = dataUserArray[6];
                readPhone = decrypt(readPhone);
                readEmail = dataUserArray[7];
                readEmail = decrypt(readEmail);
                readAge = dataUserArray[8];
                readAge = decrypt(readAge);
                readSport = dataUserArray[9];
                readSport = decrypt(readSport);

                String[] userProfileValue = {readId, readName, readLastname, readSex,
                    readBirthday, readPhone, readEmail, readAge, readSport};
                listUserProfile.put(readId, userProfileValue);

                System.out.printf("Identificación: %s\t", readId);
                if("1".equals(readUserType)){
                System.out.printf(" %s\t", "Paciente");
                }else{
                    System.out.printf(" %s\t", "Nutricionista");
                }
                System.out.printf("Nombre: %s\t", readName);
                System.out.printf("Apellido: %s\t", readLastname);
                
                if("0".equals(readSex)){
                System.out.printf("Sexo: %s\t", "Femenino");
                }else{
                    System.out.printf("Sexo: %s\t", "Masculino");
                }
                System.out.printf("F. Nacimiento: %s\t", readBirthday);
                System.out.printf("Teléfono: %s\t", readPhone);
                System.out.printf("Email: %s\t", readEmail);
                System.out.printf("Edad: %s\t", readAge);
                if("0".equals(readSport)){
                System.out.printf("Deportista: %s\n", "Si");
                }else{
                    System.out.printf("Deportista: %s\n", "No");
                }
                
                
            }//End while

        } catch (FileNotFoundException exp) {
            System.out.println("Base de datos no encontrada. Se ha creado una nueva.");
            createFile(nameDoc);
            readDatabase();
            //System.exit(0);// acaba el programa
        }//*/
        
        setListUserProfile(listUserProfile);
    }

    @Override
    public void saveData() throws Exception { //Save only User profile

        String tempId = getId();
        String tempUserType = Integer.toString(getUserType());
        String tempName = getName();
        String tempLastname = getLastName();
        String tempSex = Integer.toString(getSex());
        String tempBirthday = getBirthdate();
        String tempPhone = getPhone();
        String tempEmail = getEmail();
        String tempAge = Integer.toString(getAge());
        String tempSport = Integer.toString(getSports());

        try (FileWriter fw = new FileWriter(nameDoc, true);
                PrintWriter writeTXT = new PrintWriter(fw)) {
            //Login.deleteUser(user);
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
    }


    /*----------- SETTERS & GETTERS -------------------------------------------*/
    public AnthropometricMeasurement getMeasurements() {
        return measurements;
    }

    public void setMeasurements(AnthropometricMeasurement measurements) {
        this.measurements = measurements;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSports() {
        return sports;
    }

    public void setSports(int sports) {
        this.sports = sports;
    }

    public HashMap<String, String[]> getListUserProfile() throws Exception {
        //if(listUserProfile == null){
            readDatabase();
        return listUserProfile;
        /*}else{
            return listUserProfile;
        }*/
    }

    public void setListUserProfile(HashMap<String, String[]> listUserProfile) {
        this.listUserProfile = listUserProfile;
    }
    
    

    /*-------------------------------------------------------------------------*/
    @Override
    public void saveData(String user, String password, String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
