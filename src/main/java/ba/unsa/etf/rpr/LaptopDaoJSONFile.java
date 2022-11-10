package ba.unsa.etf.rpr;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class LaptopDaoJSONFile implements LaptopDao{
    private File file;
    private ArrayList<Laptop> laptopi;
    LaptopDaoJSONFile(){
        file = new File("laptopi.json");
        laptopi = new ArrayList<>();
    };
    @Override
    public void dodajLaptopUListu(Laptop laptop) {
        laptopi.add(laptop);
    }

    @Override
    public void dodajLaptopUFile(Laptop laptop) throws IOException {
        laptopi.add(laptop);
        FileOutputStream fos = new FileOutputStream(this.file);
        ObjectMapper mapper = new JsonMapper();
        String s = mapper.writeValueAsString(laptopi);
        fos.write(s.getBytes());
        fos.close();
    }

    @Override
    public Laptop getLaptop(String procesor) {
        return null;
    }

    @Override
    public void napuniListu(ArrayList<Laptop> l) {

    }

    @Override
    public ArrayList<Laptop> vratiPodatkeIzDatoteke() throws IOException {
        ArrayList<Laptop> l = new ArrayList<>();
        l = (new JsonMapper()).readValue(this.file, new TypeReference<ArrayList<Laptop>>() {
        });
        return l;
    }
}
