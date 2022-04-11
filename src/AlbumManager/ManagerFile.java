// HP 3-1-2022 9h43m

package AlbumManager;
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

	private static final String File_Path = "SongList.txt";
	
	public void writeToFile(List<Song> listSong) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try {
			fos = new FileOutputStream(new File(File_Path));
			oos = new ObjectOutputStream(fos);
			oos.writeObject(listSong);
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
	
	public List<Song> readFromFile() {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		List<Song> listFromFile = new ArrayList<Song>();
		
		try {
			fis = new FileInputStream(new File(File_Path));
			ois = new ObjectInputStream(fis);
			listFromFile = (List<Song>) ois.readObject();
		} catch(Exception e) {
			e.getStackTrace();
		} finally {
			closeInputStream(fis);
			closeInputStream(ois);
		}
		return listFromFile;
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
