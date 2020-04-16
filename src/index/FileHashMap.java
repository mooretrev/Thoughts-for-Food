package index;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class FileHashMap<T, T2> {

	public void save(HashMap<T, T2> map, String name) {
		name = "index/" + name + ".ser";
		try
		{
			FileOutputStream fos = new FileOutputStream(name);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(map);
			oos.close();
			fos.close();
		}catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
	}

	public HashMap<T, T2> load(String name) {
		HashMap<T, T2> map = null;
		name = "index/" + name + ".ser";
		try
		{
			FileInputStream fis = new FileInputStream(name);
			BufferedInputStream bis = new BufferedInputStream(fis);
			ObjectInputStream ois = new ObjectInputStream(bis);
			map = (HashMap) ois.readObject();
			ois.close();
			fis.close();
		}catch(IOException ioe)
		{
			ioe.printStackTrace();
			return null;
		}catch(ClassNotFoundException c)
		{
			System.out.println("Class not found");
			c.printStackTrace();
			return null;
		}
		return map;
	}
}


