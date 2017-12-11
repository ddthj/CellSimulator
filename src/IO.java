import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


//IO.java Class
//
//
// The IO class tucks away the mess of reading/writing objects from/to files
// Specifically this manages simulation states and individual organisms

//TODO - make organism implement serializable so that it can be saved to a file properly (?) (actually might have been fixed)
//TODO - make new files if the existing ones don't

//TODO - figure out how to fix the not-so-random random errors

public class IO {
	public Organism loadorg(String name){
		name += ".org";
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
		name += ".org";
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
	
	
	@SuppressWarnings("unchecked")
	public ArrayList<Organism> read(String name){ //read organisms (Simulation State) From file
		name += ".state";
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
		name += ".state";
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
