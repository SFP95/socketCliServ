package ejercicioContadorNumeros.contador;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Servidor extends Conexion {
    public Servidor() throws IOException {
        super("SERVIDOR");
    }
    public void InitServidor(){
        try {
            while (true){
                skCliente =skServidor.accept(); // que queda a la espera de recibir la petición de conexión
                System.out.println("... Conexión aceptada de : "+ skCliente.getInetAddress().getHostName());
                System.out.println("---------------------\n");

                //recoge la respuesta que le manda el cliente y lo almacena en una variable
                input_server = new DataInputStream(skCliente.getInputStream());
                int numRespuestaCliente = input_server.readInt();

                //Crea un mensaje y se lo manda a cliente con el número recogido para confirmar la comunicación con cliente
                output_cliente=new DataOutputStream(skCliente.getOutputStream());
                String mensajeServer="El numero que me has dado es: ";
                output_Server.writeUTF(mensajeServer+numRespuestaCliente);

                //cerramos la conexion
                skServidor.close();
            }
        }catch (Exception e){
            //mensaje de error en caso de fallos en la conexión
            System.out.println("Errores encontrado en" + e.getMessage());
        }
    }
}