import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


//IO Class
//Tucks away the mess of reading/writing objects from/to files
//Specifically manages Simulation States and individual organisms

//TODO - read/write individual organisms


public class IO {
	@SuppressWarnings("unchecked")
	
	public Organism loadorg(String name){
		Organism temp = new Organism();
		
		FileInputStream fin = null;
		boolean fileFound = false;
		
		try {
			fin = new FileInputStream(new File(name));
			fileFound = true;
		}
		catch(java.io.FileNotFoundException e) {
			e.printStackTrace();
		}
		
		if(fileFound) {
			try {
				ObjectInputStream ois = new ObjectInputStream(fin);
				temp = (Organism) ois.readObject();
				fin.close();
			}
			catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			return temp;
		}
		else {
			return temp;
		}	
	}
	
	public void saveorg(Organism temp, String name){
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(new File(name));
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(temp);
			oos.close();
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<Organism> read(String name){ //read organisms (Simulation State) From file
		ArrayList<Organism> temp = new ArrayList<Organism>();
		
		FileInputStream fin = null;
		boolean fileFound = false;
		
		try {
			fin = new FileInputStream(new File(name));
			fileFound = true;
		}
		catch(java.io.FileNotFoundException e) {
			e.printStackTrace();
		}
		
		if(fileFound) {
			try {
				ObjectInputStream ois = new ObjectInputStream(fin);
				temp = (ArrayList<Organism>) ois.readObject();
				fin.close();
			}
			catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			return temp;
		}
		else {
			return temp;
		}
	}
	
	
	public void write(ArrayList<Organism> temp, String name) { //write organisms (Simulation State) to file
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(new File(name));
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(temp);
			oos.close();
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
