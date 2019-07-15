package data;

import java.io.*;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Date;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import logicBusiness.Login;
import logicBusiness.ExportData;

/*
 * @author ANONYMOUS
 * @author JULIAN C
 * @author DANIEL R
 * @author JUAN B
 */
public class User implements ExportData{

    private String id, user, password, name, lastName, birthdate, phone, email;
    private int userType; //Patient == 1 
    private int sex;
    

    /* ----------- BUILDER ----------------------------------------------------*/
    public User() {
    }

    public User(String user, String password, String id) {
        this.user = user;
        this.password = password;
        this.id = id;
    }

    public User(String id, int userType, String name, String lastName, int sex,
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
        final String keyphrase = "EsteProyectoMeHaEnseñadoMuchoPeroCasiNoHeDormido_áÁéÉíÍóÓúÚüÜñÑ1234567890!#%$&()=%_MI_HUEVO_DE_PASCUA!_";
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

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
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
        if (userType == 1) {
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

    @Override
    public void readDatabase() throws IOException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveData() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveData(String user, String password, String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createReport() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
