// HP 6-1-2022 14h06m

package FamilyManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class ManagerFile {

	private static final String File_Path = "ListFamily.txt";
	
	public void writeToFile(List<Family> listFamily) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try {
			fos = new FileOutputStream(new File(File_Path));
			oos = new ObjectOutputStream(fos);
			oos.writeObject(listFamily);
		} catch(Exception e) {
			e.getStackTrace();
		} finally {
			closeOutputStream(fos);
			closeOutputStream(oos);
		}
	}
	
	public void closeOutputStream(OutputStream os) {
		if(os != null) {
			try {
				os.close();
			} catch(Exception e) {
				e.getStackTrace();
			}
		}
	}
	
	public List<Family> readFromFile(){
		List<Family> list = new ArrayList<Family>();
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream(new File(File_Path));
			ois = new ObjectInputStream(fis);
			list = (List<Family>) ois.readObject();
		} catch(Exception e) {
			e.getStackTrace();
		} finally {
			closeInputStream(fis);
			closeInputStream(ois);
		}
		return list;
	}
	
	public void closeInputStream(InputStream is) {
		if(is != null) {
			try {
				is.close();
			} catch(Exception e) {
				e.getStackTrace();
			}
		}
	}
}
