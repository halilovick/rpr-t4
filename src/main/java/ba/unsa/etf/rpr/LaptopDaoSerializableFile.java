package ba.unsa.etf.rpr;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LaptopDaoSerializableFile implements LaptopDao {
    private File file;
    private ArrayList<Laptop> laptopi;
    public LaptopDaoSerializableFile(){
        laptopi = new ArrayList<>();
        file = new File("laptopi.txt");
    }

    @Override
    public void dodajLaptopUListu(Laptop laptop) {
        laptopi.add(laptop);
    }

    @Override
    public void dodajLaptopUFile(Laptop laptop) throws IOException {
        laptopi.add(laptop);
        FileOutputStream fos = new FileOutputStream(this.file);
        ObjectOutputStream os = new ObjectOutputStream(fos);
        os.writeObject(laptopi);
        os.close();
        fos.close();
    }

    @Override
    public Laptop getLaptop(String procesor) {
        return null;
    }

    @Override
    public void napuniListu(ArrayList<Laptop> l) {
        for (Laptop lap : l)
            laptopi.add(lap);
    }

    @Override
    public ArrayList<Laptop> vratiPodatkeIzDatoteke() throws IOException {
        ArrayList<Laptop> l = new ArrayList<>();
        FileInputStream fis = new FileInputStream(this.file);
        ObjectInputStream is = new ObjectInputStream(fis);
        try{
            l = (ArrayList<Laptop>) is.readObject();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return l;
    }
}
