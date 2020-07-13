package logicBusiness;

import java.io.IOException;

public interface EditData {
	public void readDatabase()throws IOException, Exception;// no antopo
    public void deleteDataUser(String userToRemove) throws Exception; // no antro
}
