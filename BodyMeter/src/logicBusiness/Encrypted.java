package logicBusiness;

import javax.crypto.Cipher;

public interface Encrypted {
	public byte[] encrypt(String unencrypted) throws Exception; //no antro, solo user
    public String decrypt(String encrypted) throws Exception; //no antro, solo user
    public Cipher getCipher(boolean toEncrypt) throws Exception; //no antro, solo user
    public byte[] asBytes(String convertString); //no antro, solo user
}
