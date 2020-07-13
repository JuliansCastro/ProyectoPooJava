package data;

import java.io.*;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import logicBusiness.CreateFile;
import logicBusiness.EditData;
import logicBusiness.Encrypted;
import logicBusiness.ExportData;

/*
 * @author ANONYMOUS
 * @author JULIAN C
 * @author DANIEL R
 * @author JUAN B
 */
public class User implements Encrypted, EditData,CreateFile {
//
	String id, name, lastName, birthdate, phone, email, user, password;
	private final String nameDoc = "userProfile.txt";
    private final String pathfile = nameDoc;
    //private final String pathfile = new File("").getAbsolutePath() + "\\src\\resources\\base\\" + nameDoc;
    private String sex, userType; //Patient == 1 

    private BufferedReader bufferRead = null;
    private HashMap<String, String[]> listOfPatientData = new HashMap<>();
    private HashMap<String, String[]> listOfNutritionistsData = new HashMap<>();

    /* ----------- BUILDER ----------------------------------------------------*/
    public User() {
    }

    public User(String user, String password, String id) {
        this.user = user;
        this.password = password;
        this.id = id;
    }

    public User(String id, String userType, String name, String lastName, String sex,
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
    

    @Override
    public void readDatabase() throws IOException, Exception {

        try {
            bufferRead = new BufferedReader(new FileReader(pathfile));
            String readTextLine, readId, readUserType, readName, readLastname, readSex,
                    readBirthday, readPhone, readEmail, readAgeOrExperience, readSportOrProfessionalCard;

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
                readAgeOrExperience = dataUserArray[8];
                readAgeOrExperience = decrypt(readAgeOrExperience);
                readSportOrProfessionalCard = dataUserArray[9];
                readSportOrProfessionalCard = decrypt(readSportOrProfessionalCard);

                if ("1".equals(readUserType)) {
                    String[] userProfileValue = {readId, readName, readLastname, readSex,
                        readBirthday, readPhone, readEmail, readAgeOrExperience, readSportOrProfessionalCard};
                    listOfPatientData.put(readId, userProfileValue);
                    setListOfPatientData(listOfPatientData);

                    System.out.printf("IdentificaciÃ³n: %s\t", readId);
                    System.out.printf(" %s\t", "Paciente");
                    System.out.printf("Nombre: %s\t", readName);
                    System.out.printf("Apellido: %s\t", readLastname);

                    if ("0".equals(readSex)) {
                        System.out.printf("Sexo: %s\t", "Femenino");
                    } else {
                        System.out.printf("Sexo: %s\t", "Masculino");
                    }
                    System.out.printf("F. Nacimiento: %s\t", readBirthday);
                    System.out.printf("TelÃ©fono: %s\t", readPhone);
                    System.out.printf("Email: %s\t", readEmail);
                    System.out.printf("Edad: %s\t", readAgeOrExperience);
                    if ("0".equals(readSportOrProfessionalCard)) {
                        System.out.printf("Deportista: %s\n", "Si");
                    } else {
                        System.out.printf("Deportista: %s\n", "No");
                    }
                } else if ("0".equals(readUserType)) {
                    String[] userProfileValue = {readId, readName, readLastname, readSex,
                        readBirthday, readPhone, readEmail, readAgeOrExperience, readSportOrProfessionalCard};
                    listOfNutritionistsData.put(readId, userProfileValue);
                    setListOfNutritionistsData(listOfNutritionistsData);

                    System.out.printf("IdentificaciÃ³n: %s\t", readId);
                    System.out.printf(" %s\t", "Nutricionista");
                    System.out.printf("Nombre: %s\t", readName);
                    System.out.printf("Apellido: %s\t", readLastname);

                    if ("0".equals(readSex)) {
                        System.out.printf("Sexo: %s\t", "Femenino");
                    } else {
                        System.out.printf("Sexo: %s\t", "Masculino");
                    }
                    System.out.printf("F. Nacimiento: %s\t", readBirthday);
                    System.out.printf("TelÃ©fono: %s\t", readPhone);
                    System.out.printf("Email: %s\t", readEmail);
                    System.out.printf("Experiencia: %s\t", readAgeOrExperience);
                    System.out.printf("T. Profesional: %s\n", readSportOrProfessionalCard);

                }
            }//End while

        } catch (FileNotFoundException exp) {
            System.out.println("Base de datos no encontrada. Se ha creado una nueva.");
            createFile(pathfile);
            readDatabase();
            //System.exit(0);// acaba el programa
        }//*/

        setListOfPatientData(listOfPatientData);
        setListOfNutritionistsData(listOfNutritionistsData);
    }
    
    
    @Override
    public void deleteDataUser(String idToRemove) throws Exception {
        idToRemove = idToRemove.toLowerCase();
        
        //readDatabase(); OJO HACE ELIMINE TODA LA BASE DE DATOS DE USUARIO

        if (listOfPatientData.containsKey(idToRemove)){
            listOfPatientData.remove(idToRemove);

            try (FileWriter fw = new FileWriter(pathfile, false);
                    PrintWriter writeTXT = new PrintWriter(fw)) {

                for (Map.Entry<String, String[]> entry : listOfPatientData.entrySet()) {
                    String idToSave = entry.getKey();
                    String[] value = entry.getValue();

                    String userTypeToSave = value[1];
                    String nameToSave = value[2];
                    String lastnameToSave = value[3];
                    String sexToSave = value[4];
                    String birthdayToSave = value[5];
                    String phoneToSave = value[6];
                    String emailToSave = value[7];
                    String ageOrExperienceToSave = value[8];
                    String sportOrProfessionalCardToSave = value[9];

                    writeTXT.print(Arrays.toString(encrypt(idToSave)));
                    writeTXT.print("\t");
                    writeTXT.print(Arrays.toString(encrypt(userTypeToSave)));
                    writeTXT.print("\t");
                    writeTXT.print(Arrays.toString(encrypt(nameToSave)));
                    writeTXT.print("\t");
                    writeTXT.print(Arrays.toString(encrypt(lastnameToSave)));
                    writeTXT.print("\t");
                    writeTXT.print(Arrays.toString(encrypt(sexToSave)));
                    writeTXT.print("\t");
                    writeTXT.print(Arrays.toString(encrypt(birthdayToSave)));
                    writeTXT.print("\t");
                    writeTXT.print(Arrays.toString(encrypt(phoneToSave)));
                    writeTXT.print("\t");
                    writeTXT.print(Arrays.toString(encrypt(emailToSave)));
                    writeTXT.print("\t");
                    writeTXT.print(Arrays.toString(encrypt(ageOrExperienceToSave)));
                    writeTXT.print("\t");
                    writeTXT.println(Arrays.toString(encrypt(sportOrProfessionalCardToSave)));
                }
                //System.out.print("\nDatos actualizados.");
                fw.close();

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            
            try (FileWriter fw = new FileWriter(pathfile, true);
                    PrintWriter writeTXT = new PrintWriter(fw)) {

                for (Map.Entry<String, String[]> entry : listOfNutritionistsData.entrySet()) {
                    String idToSave = entry.getKey();
                    String[] value = entry.getValue();

                    String userTypeToSave = value[1];
                    String nameToSave = value[2];
                    String lastnameToSave = value[3];
                    String sexToSave = value[4];
                    String birthdayToSave = value[5];
                    String phoneToSave = value[6];
                    String emailToSave = value[7];
                    String ageOrExperienceToSave = value[8];
                    String sportOrProfessionalCardToSave = value[9];

                    writeTXT.print(Arrays.toString(encrypt(idToSave)));
                    writeTXT.print("\t");
                    writeTXT.print(Arrays.toString(encrypt(userTypeToSave)));
                    writeTXT.print("\t");
                    writeTXT.print(Arrays.toString(encrypt(nameToSave)));
                    writeTXT.print("\t");
                    writeTXT.print(Arrays.toString(encrypt(lastnameToSave)));
                    writeTXT.print("\t");
                    writeTXT.print(Arrays.toString(encrypt(sexToSave)));
                    writeTXT.print("\t");
                    writeTXT.print(Arrays.toString(encrypt(birthdayToSave)));
                    writeTXT.print("\t");
                    writeTXT.print(Arrays.toString(encrypt(phoneToSave)));
                    writeTXT.print("\t");
                    writeTXT.print(Arrays.toString(encrypt(emailToSave)));
                    writeTXT.print("\t");
                    writeTXT.print(Arrays.toString(encrypt(ageOrExperienceToSave)));
                    writeTXT.print("\t");
                    writeTXT.println(Arrays.toString(encrypt(sportOrProfessionalCardToSave)));
                }
                //System.out.print("\nDatos actualizados.");
                fw.close();

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            
            System.out.println("\nDatos eliminados del nÃºmero identificacion: " + idToRemove);
        } else if(listOfNutritionistsData.containsKey(idToRemove)){
            //System.out.println("\nEl usuario \'" + userToRemove + "\' no existe");
            
            try (FileWriter fw = new FileWriter(pathfile, false);
                    PrintWriter writeTXT = new PrintWriter(fw)) {

                for (Map.Entry<String, String[]> entry : listOfNutritionistsData.entrySet()) {
                    String idToSave = entry.getKey();
                    String[] value = entry.getValue();

                    String userTypeToSave = value[1];
                    String nameToSave = value[2];
                    String lastnameToSave = value[3];
                    String sexToSave = value[4];
                    String birthdayToSave = value[5];
                    String phoneToSave = value[6];
                    String emailToSave = value[7];
                    String ageOrExperienceToSave = value[8];
                    String sportOrProfessionalCardToSave = value[9];

                    writeTXT.print(Arrays.toString(encrypt(idToSave)));
                    writeTXT.print("\t");
                    writeTXT.print(Arrays.toString(encrypt(userTypeToSave)));
                    writeTXT.print("\t");
                    writeTXT.print(Arrays.toString(encrypt(nameToSave)));
                    writeTXT.print("\t");
                    writeTXT.print(Arrays.toString(encrypt(lastnameToSave)));
                    writeTXT.print("\t");
                    writeTXT.print(Arrays.toString(encrypt(sexToSave)));
                    writeTXT.print("\t");
                    writeTXT.print(Arrays.toString(encrypt(birthdayToSave)));
                    writeTXT.print("\t");
                    writeTXT.print(Arrays.toString(encrypt(phoneToSave)));
                    writeTXT.print("\t");
                    writeTXT.print(Arrays.toString(encrypt(emailToSave)));
                    writeTXT.print("\t");
                    writeTXT.print(Arrays.toString(encrypt(ageOrExperienceToSave)));
                    writeTXT.print("\t");
                    writeTXT.println(Arrays.toString(encrypt(sportOrProfessionalCardToSave)));
                }
                //System.out.print("\nDatos actualizados.");
                fw.close();

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            
            try (FileWriter fw = new FileWriter(pathfile, true);
                    PrintWriter writeTXT = new PrintWriter(fw)) {

                for (Map.Entry<String, String[]> entry : listOfPatientData.entrySet()) {
                    String idToSave = entry.getKey();
                    String[] value = entry.getValue();

                    String userTypeToSave = value[1];
                    String nameToSave = value[2];
                    String lastnameToSave = value[3];
                    String sexToSave = value[4];
                    String birthdayToSave = value[5];
                    String phoneToSave = value[6];
                    String emailToSave = value[7];
                    String ageOrExperienceToSave = value[8];
                    String sportOrProfessionalCardToSave = value[9];

                    writeTXT.print(Arrays.toString(encrypt(idToSave)));
                    writeTXT.print("\t");
                    writeTXT.print(Arrays.toString(encrypt(userTypeToSave)));
                    writeTXT.print("\t");
                    writeTXT.print(Arrays.toString(encrypt(nameToSave)));
                    writeTXT.print("\t");
                    writeTXT.print(Arrays.toString(encrypt(lastnameToSave)));
                    writeTXT.print("\t");
                    writeTXT.print(Arrays.toString(encrypt(sexToSave)));
                    writeTXT.print("\t");
                    writeTXT.print(Arrays.toString(encrypt(birthdayToSave)));
                    writeTXT.print("\t");
                    writeTXT.print(Arrays.toString(encrypt(phoneToSave)));
                    writeTXT.print("\t");
                    writeTXT.print(Arrays.toString(encrypt(emailToSave)));
                    writeTXT.print("\t");
                    writeTXT.print(Arrays.toString(encrypt(ageOrExperienceToSave)));
                    writeTXT.print("\t");
                    writeTXT.println(Arrays.toString(encrypt(sportOrProfessionalCardToSave)));
                }
                //System.out.print("\nDatos actualizados.");
                fw.close();

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    @Override
    public void createFile(String nameDoc) {
        FileWriter flwriter = null;
        try {
            flwriter = new FileWriter(nameDoc);
            String pathfile = new File("").getAbsolutePath() + "\\" + nameDoc;
            System.out.println("Archivo \'" + nameDoc + "\' creado satisfactoriamente en la ruta: \n" + pathfile);
            //BufferedWriter bfwriter = new BufferedWriter(flwriter);
            //bfwriter.close();
        } catch (IOException e) {
            System.out.print("Error, El archivo no Exite / No se puede leer el archivo");
            e.printStackTrace();
        } finally {
            if (flwriter != null) {
                try {//cierra el flujo principal
                    flwriter.close();
                } catch (IOException e) {
                    System.out.print("Error, El archivo no Exite / No se puede leer el archivo");
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public byte[] encrypt(String unencrypted) throws Exception {
        final byte[] bytes = unencrypted.getBytes("UTF-8");
        final Cipher aes = getCipher(true);
        final byte[] encrypted = aes.doFinal(bytes);
        return encrypted;
    }

    @Override
    public String decrypt(String encrypted) throws Exception {
        byte[] encrypt = asBytes(encrypted);
        final Cipher aes = getCipher(false);
        final byte[] bytes = aes.doFinal(encrypt);
        final String unencrypted = new String(bytes, "UTF-8");
        return unencrypted;
    }

    @Override
    public Cipher getCipher(boolean toEncrypt) throws Exception {
        final String keyphrase = "EsteProyectoMeHaEnseÃ±adoMuchoPeroCasiNoHeDormido_Ã¡Ã�Ã©Ã‰Ã­Ã�Ã³Ã“ÃºÃšÃ¼ÃœÃ±Ã‘1234567890!#%$&()=%_MI_HUEVO_DE_PASCUA!_";
        final MessageDigest digest = MessageDigest.getInstance("SHA");
        digest.update(keyphrase.getBytes("UTF-8"));
        final SecretKeySpec key = new SecretKeySpec(digest.digest(), 0, 16, "AES");

        final Cipher aes = Cipher.getInstance("AES/ECB/PKCS5Padding");
        if (toEncrypt) {
            aes.init(Cipher.ENCRYPT_MODE, key);
        } else {
            aes.init(Cipher.DECRYPT_MODE, key);
        }

        return aes;
    }

    @Override
    public byte[] asBytes(String convertString) {
        String temporalString;

        convertString = convertString.replace("[", "").replace("]", "").replaceAll(" ", "");
        String[] readUserArray = convertString.split(",");

        byte[] byteReadUser = new byte[readUserArray.length];
        for (int i = 0; i < readUserArray.length; i++) {
            temporalString = readUserArray[i];
            byteReadUser[i] = (byte) (Integer.parseInt(temporalString) & 0xff);
        }
        //System.out.println(Arrays.toString(byteReadUser));
        return byteReadUser;
    }

    public String createIdentifier() {
        String identifier;
        char[] identifierArray = new char[10];
        char[] characters = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
            'O', 'P', 'Q', 'R', 'S', 'T', 'T', 'V', 'W', 'X', 'Y', 'Z'};

        for (int i = 0; i < identifierArray.length; i++) {
            int arrayElement = (int) (Math.random() * characters.length);
            identifierArray[i] = (char) characters[arrayElement];
        }

        return identifier = new String(identifierArray);
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

    public String getUserType() {
        
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public HashMap<String, String[]> getListOfPatientData() throws Exception {
        readDatabase();
        return listOfPatientData;
    }

    public void setListOfPatientData(HashMap<String, String[]> listOfPatientData) {
        this.listOfPatientData = listOfPatientData;
    }

    public HashMap<String, String[]> getListOfNutritionistsData() throws Exception {
        readDatabase();
        return listOfNutritionistsData;
    }

    public void setListOfNutritionistsData(HashMap<String, String[]> listOfNutritionistsData) {
        this.listOfNutritionistsData = listOfNutritionistsData;
    }

    @Override
    public String toString() {
        String toString;
        if ("1".equals(userType)) {
            toString = "PACIENTE{" + "  Usuario: " + user + "   IdentificaciÃ³n: " + id
                    + " Nombre: " + name + " Apellidos: " + lastName + " Sexo: " + sex
                    + " Fecha de nacimiento: " + birthdate + " TelÃ©fono: " + phone
                    + " Email: " + email + '}';
        } else {
            toString = "NUTRICIONISTA{" + "  Usuario: " + user + "   IdentificaciÃ³n: " + id
                    + " Nombre: " + name + " Apellidos: " + lastName + " Sexo: " + sex
                    + " Fecha de nacimiento: " + birthdate + " TelÃ©fono: " + phone
                    + " Email: " + email + '}';
        }
        return toString;
    }
}
