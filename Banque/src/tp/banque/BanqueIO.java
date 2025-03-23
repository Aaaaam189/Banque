package tp.banque;

import java.io.*;
import java.util.List;

public class BanqueIO {

    public static void saveComptes(List<Compte> comptes, String fileName) {
        try {
            OutputStream fos = new BufferedOutputStream(new FileOutputStream(fileName));
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(comptes);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Compte> loadComptes(String fileName) {
        List<Compte> comptes = null;
        try {
            InputStream fis = new BufferedInputStream(new FileInputStream(fileName));
            ObjectInputStream ois = new ObjectInputStream(fis);
            comptes = (List<Compte>) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return comptes;
    }
}

