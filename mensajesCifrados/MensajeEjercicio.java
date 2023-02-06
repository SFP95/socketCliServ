package mensajesCifrados;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;

public class MensajeEjercicio {
    public static void main(String[] args) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA");
            String mensaje = "/fichero.txt";
            byte dataBytes[] = mensaje.getBytes();
            md.update(dataBytes);
            byte resumen[] = mensaje.digest();

        } catch (/*NoSuchAlgorithmException |*/ NoSuchAlgorithmException e) {
            System.out.println("ERROR en el MessageDigest" + e);
        }
    }
}
