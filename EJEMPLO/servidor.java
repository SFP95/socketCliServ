package EJEMPLO;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class servidor extends conexion{

    public servidor() throws IOException {
        super("servidor");
    }

    public void iniciaServidor()  {
    try {

        while (true){
             scCliente = scServer.accept(); //aceptamos la conexion con servidor
             System.out.println("Conexion acetada de: "+scCliente.getInetAddress().getHostName());

            entrada_server= new DataInputStream(scCliente.getInputStream());
            int numeroRespuesta=entrada_server.readInt();

            salida_cliente=new DataOutputStream(scCliente.getOutputStream());
            String mensajeServer=" El numero que me has dado es: ";
            System.out.println(mensajeServer+numeroRespuesta);           //funciona

            
            salida_Server.writeUTF(mensajeServer+numeroRespuesta);
            scServer.close();
        }

    }catch (Exception e){
        System.out.println(e);
    }
    }
}
