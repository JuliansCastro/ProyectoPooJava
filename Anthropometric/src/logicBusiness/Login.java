package logicBusiness;

import data.User;
import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Map;
import javax.swing.JOptionPane;

/*
 * @author ANONYMOUS
 * @author JULIAN C
 * @author DANIEL R
 * @author JUAN B
 */
public class Login extends User {

    private final String nameDoc = "login.txt";
    private String answer;
    private static int failedAttempt = 0;
    private boolean activeSession = false;
    private boolean thereIsAUser, thereIsADatabase;
    private HashMap<String, String[]> userLoginList = new HashMap<>();
    private final Scanner keyboard = new Scanner(System.in);
    private BufferedReader bufferRead = null;

    //private User user = new User(user, password);

    /* ----------- BUILDER -----------------------------------------------------*/
    public Login() {
    }

    /* ----------- METHODS -----------------------------------------------------*/
    public void logIn(String userLogin, String passwordLogin) throws IOException, Exception {
        readDatabase();

        if (userLoginList.containsKey(userLogin)) {
            String[] userLoginData = userLoginList.get(userLogin);
            setUser(userLogin);

            if (userLoginData[2].equals(passwordLogin) && userLoginData[0] != null) {
                setPassword(passwordLogin);
                setId(userLoginData[0]);
                answer = "\nBienvenido " + userLogin.toUpperCase();
                failedAttempt = 0; //reinicia los intentos por si se hace un logout no lo saque del programa
                setActiveSession(true);
            } else {
                failedAttempt++;
                if (failedAttempt == 1) {
                    answer = "Usted a tenido " + failedAttempt + " intento fallido";
                    answer = answer.toUpperCase();
                    setActiveSession(false);
                } else {
                    answer = "Usted a tenido " + failedAttempt + " intentos fallidos";
                    answer = answer.toUpperCase();
                    setActiveSession(false);
                }
            }
        } else {
            setThereIsAUser(false);
        }

        System.out.println(answer);
        if (failedAttempt > 2) {//saca del programa si hay 3 intentos fallidos
            System.out.println("Muchos intentos fallidos. Pida ayuda al administrador");
            JOptionPane.showMessageDialog(null, "Muchos intentos fallidos. Pida ayuda al administrador");
            //System.exit(0);
        }
    }

    public void logIn() throws IOException, Exception {
        readDatabase();
        String userLogin, passwordLogin;

        System.out.println("\nINICIAR SESIÓN ");//(Default: (user: jul psw: 1234))");
        System.out.println("------------------");

        System.out.print("Ingrese usuario: ");
        userLogin = keyboard.nextLine();
        userLogin = userLogin.replaceAll(" ", "").trim().toLowerCase();

        System.out.print("Ingrese clave: ");
        passwordLogin = keyboard.nextLine();
        passwordLogin = passwordLogin.replaceAll(" ", "").trim();
        //*/

        if (userLoginList.containsKey(userLogin)) {
            String[] userLoginData = userLoginList.get(userLogin);
            setUser(userLogin);

            if (userLoginData[2].equals(passwordLogin) && userLoginData[0] != null) {
                setPassword(passwordLogin);
                setId(userLoginData[0]);
                answer = "\nBienvenido " + userLogin.toUpperCase();
                failedAttempt = 0; //reinicia los intentos por si se hace un logout no lo saque del programa
                setActiveSession(true);

                System.out.println("Usuario: " + userLoginData[1] + "    Contraseña: " + userLoginData[2]
                        + "    Identificación: " + userLoginData[0]);
            } else {
                failedAttempt++;
                if (failedAttempt == 1) {
                    answer = "Usted a tenido " + failedAttempt + " intento fallido";
                    answer = answer.toUpperCase();
                    setActiveSession(false);
                } else {
                    answer = "Usted a tenido " + failedAttempt + " intentos fallidos";
                    answer = answer.toUpperCase();
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
        String newUser = "", newPassword = "", newId, exit = "";

        System.out.println("\nUSUARIO NUEVO");
        System.out.println("------------------");

        while ("".equalsIgnoreCase(newUser)) {
            System.out.print("Introduce Usuario nuevo: ");
            newUser = keyboard.nextLine();
            newUser = newUser.toLowerCase().replaceAll(" ", "").trim();

            if (userLoginList.containsKey(newUser)) {
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
                    saveData(newUser, newPassword, createIdentifier());
                } else {
                    saveData(newUser, newPassword, newId);
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

    @Override
    public void readDatabase() throws IOException, Exception { //Read only login data
        try {
            bufferRead = new BufferedReader(new FileReader(nameDoc));
            setThereIsADatabase(true);
            String readTextLine, readUser, readPassword, readId;

            while ((readTextLine = bufferRead.readLine()) != null) {

                String[] dataUserArray = readTextLine.split("\t");

                readUser = dataUserArray[0];
                readUser = decrypt(readUser);

                readPassword = dataUserArray[1];
                readPassword = decrypt(readPassword);

                readId = dataUserArray[2];
                readId = decrypt(readId);

                String[] userValue = {readId, readUser, readPassword};
                userLoginList.put(readUser, userValue);
                
                System.out.printf("Usuario: %s\t", readUser);
                System.out.printf("Contraseña: %s\t", readPassword);
                System.out.printf("Identificación: %s\n", readId);
            }//End while

            setUserLoginList(userLoginList);
        } catch (FileNotFoundException exp) {

            System.out.println("Base de datos no encontrada. Se ha creado una nueva.");

            JOptionPane.showMessageDialog(null, "Base de datos no encontrada.\n"
                    + " Se ha creado una nueva.");
            createFile(nameDoc);

            System.out.println("\nRegistrese por favor.");

            readDatabase();

        }

    }

    @Override
    public void saveData(String user, String password, String id) throws Exception {//Save only User login data
        if (id.equals("")) {
            id = createIdentifier();
        }

        readDatabase();

        if (userLoginList.containsKey(user)) {
            deleteDataUser(user);

            try (FileWriter fw = new FileWriter(nameDoc, true);
                    PrintWriter writeTXT = new PrintWriter(fw)) {
                deleteDataUser(user);
                writeTXT.print(Arrays.toString(encrypt(user)));
                writeTXT.print("\t");
                writeTXT.print(Arrays.toString(encrypt(password)));
                writeTXT.print("\t");
                writeTXT.println(Arrays.toString(encrypt(id)));
                fw.close();

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            try (FileWriter fw = new FileWriter(nameDoc, true);
                    PrintWriter writeTXT = new PrintWriter(fw)) {
                deleteDataUser(user);
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
    }

    @Override
    public void deleteDataUser(String userToRemove) throws Exception {
        userToRemove = userToRemove.toLowerCase();

        if (userLoginList.containsKey(userToRemove)) {
            userLoginList.remove(userToRemove);

            try (FileWriter fw = new FileWriter(nameDoc, false);
                    PrintWriter writeTXT = new PrintWriter(fw)) {

                for (Map.Entry<String, String[]> entry : userLoginList.entrySet()) {
                    String user = entry.getKey();
                    String[] value = entry.getValue();
                    String password = value[2];
                    String id = value[0];

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

    /* ----------- SETTERS & GETTERS ------------------------------------------*/
    public HashMap<String, String[]> getUserLoginList() {
        return userLoginList;
    }

    public void setUserLoginList(HashMap<String, String[]> userLoginList) {
        this.userLoginList = userLoginList;
    }

    public boolean isActiveSession() {
        return activeSession;
    }

    public void setActiveSession(boolean activeSession) {
        this.activeSession = activeSession;
    }

    public boolean isThereIsAUser() {
        return thereIsAUser;
    }

    public void setThereIsAUser(boolean thereIsAUser) {
        this.thereIsAUser = thereIsAUser;
    }

    public boolean isThereIsADatabase() {
        return thereIsADatabase;
    }

    public void setThereIsADatabase(boolean thereIsADatabase) {
        this.thereIsADatabase = thereIsADatabase;
    }

    /* ------------------------------------------------------------------------*/
    @Override
    public void saveData() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
