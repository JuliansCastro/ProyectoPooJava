package logicBusiness;

import java.io.*;

/*
 * @author JULIAN C
 * @author DANIEL R
 * @author JUAN B
 */
public class ExportData {

    private BufferedReader bufferRead = null;

    /* ----------- BUILDER ------------------------------------------------------------------------------------------------------*/
    public ExportData() {
    }

    /* ----------- METHODS ------------------------------------------------------------------------------------------------------*/
    public static void createFile(String nameDoc) {
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

    public String readTextLineDoc(String nameDoc) throws IOException {
        String readTextLine = "";
        try {
            bufferRead = new BufferedReader(new FileReader(nameDoc));
            readTextLine = bufferRead.readLine();
            //System.out.println(readTextLine);
        } catch (FileNotFoundException exp) {
            System.out.println("Archivo no encontrado. Se ha creado uno nuevo.");
            FileWriter fw = new FileWriter(nameDoc, true);
        }
        return readTextLine;
    }

    public void createReport() {
    }

    /* ----------- SETTERS & GETTERS --------------------------------------------------------------------------------------------*/
}
