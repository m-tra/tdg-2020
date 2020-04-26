package tga_algo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DeepCopy {

    public static Graphe copy(Graphe orig){
        Graphe nvo = null;
        try{
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bos);
            out.writeObject(orig);
            out.flush();
            out.close();
            ObjectInputStream in = new ObjectInputStream(
                    new ByteArrayInputStream(bos.toByteArray()));
            nvo = (Graphe) in.readObject();
        }
        catch(IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DeepCopy.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nvo;
    }
}
