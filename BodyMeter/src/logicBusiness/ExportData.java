package logicBusiness;

import java.io.*;
import javax.crypto.Cipher;

/*
 * @author ANONYMOUS
 * @author JULIAN C
 * @author DANIEL R
 * @author JUAN B
 */

public interface ExportData {
    public void createFile(String nameDoc);
    public void createReport();
    public void readDatabase()throws IOException, Exception;
    public void saveData() throws Exception;
    public void deleteDataUser(String userToRemove) throws Exception;
    public void saveData(String user, String password, String id) throws Exception;
}