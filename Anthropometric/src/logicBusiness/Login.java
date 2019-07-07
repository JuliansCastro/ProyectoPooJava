
package logicBusiness;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/*
 * @author JULIAN C
 * @author JUAN B
 */
public class Login {
    private final String nameDoc = "LOGIN.txt";
    private String user, password, answer;
    private static int failedAttempt = 0;
    private boolean activeSession = true;
    private final HashMap<String, String> userList = new HashMap<>();
    private final Scanner keyboard = new Scanner(System.in);
    private BufferedReader bufferRead = null;
    private final ExportData exportData = null;
    //private User user = new User(user, password);

    //Builder
    public Login() {
    }

    //Methods
    public void readDatabase() throws IOException, Exception {
        try {
            bufferRead = new BufferedReader(new FileReader(nameDoc));
            String readTextLine, readUser, readPassword;
            int sizeTextLine, tabPosition;
            while ((readTextLine = bufferRead.readLine()) != null) {
                sizeTextLine = readTextLine.length();
                tabPosition = readTextLine.indexOf("\t");

                readUser = readTextLine.substring(0, tabPosition);
                readUser = decrypt(readUser);
                readPassword = readTextLine.substring(1 + tabPosition);
                readPassword = decrypt(readPassword);

                userList.put(readUser, readPassword);
                //System.out.println("Usuario: " + readUser + "  Contraseña: " + userList.get(readUser));

            }

        } catch (FileNotFoundException exp) {
            System.out.println("Base de datos no encontrada. Se ha creado una nueva.");
            exportData.createFile(nameDoc);
            
            System.out.println("\nCree un usuario por favor.");
            newUser();
            readDatabase();
            //System.exit(0);// acaba el programa
        }

    }

    public void validateLogin() throws IOException, Exception {
        readDatabase();
        System.out.println("\nINICIAR SESIÓN");
        System.out.println("------------------");
        System.out.print("Ingrese usuario: ");
        user = keyboard.nextLine();
        System.out.print("Ingrese clave: ");
        password = keyboard.nextLine();

        if ((userList.containsKey(user)) && (userList.get(user)).equals(password)) {
            answer = "\nBienvenido " + user.toUpperCase();
            failedAttempt = 0;//reinicia los intentos por si se hace un logout no lo saque del programa
        } else {
            failedAttempt++;
            if (failedAttempt == 1) {
                answer = "Usted a tenido " + failedAttempt + " intento fallido";
            } else {
                answer = "Usted a tenido " + failedAttempt + " intentos fallidos";
            }
        }
        System.out.println(answer);
        if (failedAttempt > 2) {//saca del programa si hay 3 intentos fallidos
            System.exit(0);
        }
    }

    public void newUser() throws Exception {

        String newUser = "", newPassword = "", exit = "";

        System.out.println("\nUSUARIO NUEVO");
        System.out.println("------------------");

        try (FileWriter fw = new FileWriter(nameDoc, true);
                PrintWriter writeTXT = new PrintWriter(fw)) {

            readDatabase();
            while ("".equalsIgnoreCase(newUser)) {
                System.out.print("Introduce Usuario nuevo: ");
                newUser = keyboard.nextLine();
                newUser = newUser.toLowerCase();
                if (userList.containsKey(newUser)) {
                    newUser = "";
                    System.out.println("Usuario ya existe. Ingrese uno nuevo por favor");
                }
            }

            while (newPassword.length() < 4) {
                System.out.print("Introduce Contraseña nueva: ");
                newPassword = keyboard.nextLine();
                if (newPassword.length() < 4) {
                    System.out.println("Contraseña con mínimo 4 caracteres. Ingrese una mas larga.");
                }
            }

            System.out.print("¿Guardar? (Y/N): ");
            while ((!exit.equalsIgnoreCase("Y")) || (!exit.equalsIgnoreCase("N")) || (!exit.equalsIgnoreCase("C"))) {
                exit = keyboard.nextLine();
                if (exit.equalsIgnoreCase("Y")) {
                    writeTXT.print(Arrays.toString(encrypt(newUser)));
                    writeTXT.print("\t");
                    writeTXT.println(Arrays.toString(encrypt(newPassword)));

                    System.out.print("\nGuardando.");
                    for (int i = 0; i < 30; i++) {
                        System.out.print(" .");
                    }
                    System.out.print(" Finalizado\n");
                    System.out.println("\nGracias por registrase " + newUser + "\n");
                    break;
                } else {
                    System.out.print("\nNo guardado/Cancelado\n");
                    break;
                }
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void deleteUser() {
    }

    public void exit() {
        System.out.println("Sesión finalizada.");
        System.exit(0);
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
        String emporalString;
        convertString = convertString.replace("[", "");
        convertString = convertString.replace("]", "");
        convertString = convertString.replaceAll(" ", "");
        String[] readUserArray = convertString.split(",");

        byte[] byteReadUser = new byte[readUserArray.length];
        for (int i = 0; i < readUserArray.length; i++) {
            emporalString = readUserArray[i];
            byteReadUser[i] = (byte) (Integer.parseInt(emporalString) & 0xff);
        }
        //System.out.println(Arrays.toString(byteReadUser));

        return byteReadUser;
    }

    //Getters &Setter
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

    public boolean isActiveSession() {
        return activeSession;
    }

    public void setActiveSession(boolean activeSession) {
        this.activeSession = activeSession;
    }
}
