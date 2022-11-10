package ba.unsa.etf.rpr;

import java.io.IOException;

public class App
{
    public static void main( String[] args )
    {
        LaptopDao l = new LaptopDaoJSONFile();
        Laptop laptop = new Laptop("Asus", "...", 100, 10, 10, 10, "..", "..", 10);
        Laptop laptop2 = new Laptop("Asus", "...", 100, 10, 10, 10, "..", "..", 100);
        try {
            l.dodajLaptopUFile(laptop);
            l.dodajLaptopUFile(laptop2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
