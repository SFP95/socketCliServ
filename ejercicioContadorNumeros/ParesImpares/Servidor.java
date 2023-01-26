package ejercicioContadorNumeros.ParesImpares;

import java.io.*;

public class Servidor extends Conexion{
    public Servidor() throws IOException {
        super("SERVIDOR");
    }
    public void InitServidor() {
        try {
            skCliente =skServidor.accept(); // que queda a la espera de recibir la petición de conexión
            System.out.println("- Conexión aceptada de : "+ skCliente.getInetAddress().getHostName());
            System.out.println("------------\n");

            //EJERCICIO:

            input_server=new DataInputStream(skCliente.getInputStream());

            for (int i=0; i<10;i++){
                output_Server.writeUTF("Dime un numero par");
                int numCliente= input_server.readInt();

                if (numCliente%1==0){
                    // envia el resultado al cliente
                    output_Server.writeUTF("Este es el mensaje con el numero par : " + (numCliente) + "\n");

                }else {
                    //envia el mensaje de error al cliente al no cumplir la condicion
                    output_Server.writeUTF("Ese no es un número par :( ");

                }
            }
            //cerramos la conexion
            skServidor.close();
        }catch (Exception e){
        //mensaje de error en caso de fallos en la conexión
        System.out.println("Errores encontrado en" + e.getMessage());
    }
    }

}
