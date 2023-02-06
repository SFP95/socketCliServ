package mensajesCifrados;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;

public class MensajeEjercicio {
    public static void main(String[] args) {

        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA");
            String texto = "tengo que meter aqui el fichero."; //buscarlo en los apuntes de la primea evaluación

            byte dataBytes[] = texto.getBytes();//TEXTO A BYTES
            md.update(dataBytes);//SE INTRQDUCE TEXTO EN BYTES A RESUMIR
            byte resumen[] = md.digest();//SE CALCULA EL RESUMEN

//PARA CREAR UN RESUMEN CIFRADO CON CLAVE
//String clave="clave de cifrado";
//byte resumen[] = md.digest(clave.getBytes()); // SE CALCULA EL RESUMEN CIFRADO
            System.out.println("Mensaje original: " + texto);
            System.out.println("Número de bytes: "
                    + md.getDigestLength());
            System.out.println("Algoritmo: "
                    + md.getAlgorithm());
            System.out.println("Mensaje resumen: " + new String(resumen));
            System.out.println("Mensaje en Hexadecimal: "
                    + Hexadecimal(resumen));
            Provider proveedor = md.getProvider();
            System.out.println("Proveedor: "
                    + proveedor.toString());
        } catch (/*NoSuchAlgorithmException |*/ NoSuchAlgorithmException e) {
            System.out.println("ERROR en el MessageDigest"+e);
        }

    }//Fin de main

    // CONVIERTE UN ARRAY DE BYTES A HEXADECIMAL
    static String Hexadecimal(byte[] resumen) {

        String hex = "";
        for (int i = 0; i < resumen.length; i++) {

            String h = Integer.toHexString(resumen[i] & 0xFF);
            if (h.length() == 1) {
                hex += "0";
            }
            hex += h;
        }//Fin de for

        return hex.toUpperCase();
    }// Fin de Hexadecimal
}
