/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicBusiness;

import java.io.*;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

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
    public void saveData(String user, String password, String id) throws Exception;
    public byte[] encrypt(String unencrypted) throws Exception;
    public String decrypt(String encrypted) throws Exception;
    public Cipher getCipher(boolean toEncrypt) throws Exception;
    public byte[] asBytes(String convertString);
}