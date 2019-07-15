package logicBusiness;

import data.User;
import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/*
 * @author ANONYMOUS
 * @author JULIAN C
 * @author DANIEL R
 * @author JUAN B
 */
public class Login extends User {

    private final String nameDoc = "LOGIN.txt";
    private String answer;
    private static int failedAttempt = 0;
    private boolean activeSession = false;
    private final HashMap<String, String[]> userList = new HashMap<>();
    private final Scanner keyboard = new Scanner(System.in);
    private BufferedReader bufferRead = null;
    private final ExportData exportData = null;
    //private User user = new User(user, password);

    /* ----------- BUILDER -----------------------------------------------------*/
    public Login() {
    }

    /* ----------- METHODS -----------------------------------------------------*/
    public void readDatabase() throws IOException, Exception {
        try {
            bufferRead = new BufferedReader(new FileReader(nameDoc));
            String readTextLine, readUser, readPassword, readId;

            while ((readTextLine = bufferRead.readLine()) != null) {

                String[] dataUserArray = readTextLine.split("\t");

                readUser = dataUserArray[0];
                readUser = decrypt(readUser);

                readPassword = dataUserArray[1];
                readPassword = decrypt(readPassword);

                readId = dataUserArray[2];
                readId = decrypt(readId);

                String[] userValue = {readPassword, readId};

                userList.put(readUser, userValue);

                System.out.printf("Usuario: %s\t", readUser);
                System.out.printf("Contraseña: %s\t", readPassword);
                System.out.printf("Identificación: %s\n", readId);

            }//End while

        } catch (FileNotFoundException exp) {
            System.out.println("Base de datos no encontrada. Se ha creado una nueva.");
            exportData.createFile(nameDoc);

            System.out.println("\nCree un usuario por favor.");
            signUp();
            readDatabase();
            //System.exit(0);// acaba el programa
        }

    }

    public void logIn() throws IOException, Exception {
        readDatabase();
        String user, password;

        System.out.println("\nINICIAR SESIÓN ");//(Default: (user: jul psw: 1234))");
        System.out.println("------------------");

        System.out.print("Ingrese usuario: ");
        user = keyboard.nextLine();
        user = user.replaceAll(" ", "").trim().toLowerCase();

        System.out.print("Ingrese clave: ");
        password = keyboard.nextLine();
        password = password.replaceAll(" ", "").trim();

        if (userList.containsKey(user)) {
            String[] userData = userList.get(user);
            setUser(user);

            if (userData[0].equals(password) && userData[1] != null) {
                setPassword(password);
                setId(userData[1]);
                answer = "\nBienvenido " + user.toUpperCase();
                failedAttempt = 0; //reinicia los intentos por si se hace un logout no lo saque del programa
                setActiveSession(true);

                System.out.println("Usuario: " + user + "    Contraseña: " + userData[0]
                        + "    Identificador: " + userData[1]);
            } else {
                failedAttempt++;
                if (failedAttempt == 1) {
                    answer = "Usted a tenido " + failedAttempt + " intento fallido";
                    answer = answer.toUpperCase();
                    setActiveSession(false);
                } else {
                    answer = "Usted a tenido " + failedAttempt + " intentos fallidos";
                    setActiveSession(false);
                }
            }
        }

        System.out.println(answer);
        if (failedAttempt > 2) {//saca del programa si hay 3 intentos fallidos
            System.out.println("Muchos intentos fallidos. Ingrese después");
            System.exit(0);
        }
    }

    public void signUp() throws Exception {
        readDatabase();
        String newUser = "", newPassword = "", newId = "", exit = "";

        System.out.println("\nUSUARIO NUEVO");
        System.out.println("------------------");

        while ("".equalsIgnoreCase(newUser)) {
            System.out.print("Introduce Usuario nuevo: ");
            newUser = keyboard.nextLine();
            newUser = newUser.toLowerCase().replaceAll(" ", "").trim();

            if (userList.containsKey(newUser)) {
                newUser = "";
                System.out.println("Usuario ya existe. Ingrese uno nuevo por favor");
            }
        }

        while (newPassword.length() < 4) {
            System.out.print("Introduce Contraseña nueva: ");
            newPassword = keyboard.nextLine();
            newPassword = newPassword.replaceAll(" ", "").trim();
            if (newPassword.length() < 4) {
                System.out.println("Contraseña con mínimo 4 caracteres. Ingrese una mas larga.");
            }
        }

        System.out.print("Introduce identificación nueva: ");
        newId = keyboard.nextLine();
        newId = newId.toLowerCase().replaceAll(" ", "").trim();

        System.out.print("¿Guardar? (Y/N): ");
        while ((!exit.equalsIgnoreCase("Y")) || (!exit.equalsIgnoreCase("N")) || (!exit.equalsIgnoreCase("C"))) {
            exit = keyboard.nextLine();
            if (exit.equalsIgnoreCase("Y")) {

                if (newId.equalsIgnoreCase("")) {
                    saveUser(newUser, newPassword, createIdentifier());
                } else {
                    saveUser(newUser, newPassword, newId);
                }

                System.out.println("\nGracias por registrase \'" + newUser + "\'\n");
                break;
            } else {
                System.out.print("\nNo guardado/Cancelado\n");
                break;
            }
        }

        exit();
    }

    public void saveUser(String user, String password, String id) throws Exception {
        if (id.equals("")) {
            id = createIdentifier();
        }

        try (FileWriter fw = new FileWriter(nameDoc, true);
                PrintWriter writeTXT = new PrintWriter(fw)) {
            deleteUser(user);
            writeTXT.print(Arrays.toString(encrypt(user)));
            writeTXT.print("\t");
            writeTXT.print(Arrays.toString(encrypt(password)));
            writeTXT.print("\t");
            writeTXT.println(Arrays.toString(encrypt(id)));
            fw.close();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void deleteUser(String userToRemove) throws Exception {
        userToRemove = userToRemove.toLowerCase();

        if (userList.containsKey(userToRemove)) {
            userList.remove(userToRemove);

            try (FileWriter fw = new FileWriter(nameDoc, false);
                    PrintWriter writeTXT = new PrintWriter(fw)) {

                for (Map.Entry<String, String[]> entry : userList.entrySet()) {
                    String user = entry.getKey();
                    String[] value = entry.getValue();
                    String password = value[0];
                    String id = value[1];

                    writeTXT.print(Arrays.toString(encrypt(user)));
                    writeTXT.print("\t");
                    writeTXT.print(Arrays.toString(encrypt(password)));
                    writeTXT.print("\t");
                    writeTXT.println(Arrays.toString(encrypt(id)));
                }
                //System.out.print("\nDatos actualizados.");
                fw.close();

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            System.out.println("\nUsuario eliminado: " + userToRemove);
        } else {
            //System.out.println("\nEl usuario \'" + userToRemove + "\' no existe");
        }
    }

    public void exit() {
        System.out.println("\nSesión finalizada. Hasta pronto.\n");
        //setActiveSession(false);
        System.exit(0);
    }

    public String createIdentifier() {
        String identifier;
        char[] identifierArray = new char[10];
        char[] characters = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
            'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
            'Ñ', 'O', 'P', 'Q', 'R', 'S', 'T', 'T', 'V', 'W', 'X', 'Y', 'Z'};

        for (int i = 0; i < identifierArray.length; i++) {
            int arrayElement = (int) (Math.random() * characters.length);
            identifierArray[i] = (char) characters[arrayElement];
        }

        return identifier = new String(identifierArray);
    }

    public byte[] encrypt(String unencrypted) throws Exception {
        final byte[] bytes = unencrypted.getBytes("UTF-8");
        final Cipher aes = getCipher(true);
        final byte[] encrypted = aes.doFinal(bytes);
        return encrypted;
    }

    public String decrypt(String encrypted) throws Exception {
        byte[] encrypt = asBytes(encrypted);
        final Cipher aes = getCipher(false);
        final byte[] bytes = aes.doFinal(encrypt);
        final String unencrypted = new String(bytes, "UTF-8");
        return unencrypted;
    }

    private Cipher getCipher(boolean toEncrypt) throws Exception {
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
    public boolean isActiveSession() {
        return activeSession;
    }

    public void setActiveSession(boolean activeSession) {
        this.activeSession = activeSession;
    }

}
