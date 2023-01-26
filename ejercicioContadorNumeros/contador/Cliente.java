package ejercicioContadorNumeros.contador;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;
public class Cliente extends Conexion {

    //para poder recoger la respuesta por terminal
    public Scanner scan = new Scanner(System.in);

    public Cliente() throws IOException {
        super("CLIENTE");
    }
    public void initCLiente(){
        try {
            // salida de servidor y recogida de datos
            output_Server = new DataOutputStream(skCliente.getOutputStream());
            output_cliente = new DataOutputStream(skCliente.getOutputStream());

            //EJERCICIO:

            for ( int i=0;i<4;i++){
                System.out.println("Dime un número: ");
                //recogida de respuesta por pantalla y mandado de la respuesta a servidor
                int num = scan.nextInt();
                output_cliente.writeInt(num);
            }

            /*---------------------- LO QUE RECIBIRA EL CLIENTE ---------------*/

            input_server = new DataInputStream(skCliente.getInputStream());
            int mensajeRespuestaServer= input_server.readInt();
            System.out.println("[SERVER] Me has dicho: " + mensajeRespuestaServer); //recime el número


            //Cerramos conexión
            skCliente.close();

        }catch (Exception e){
            //mensaje de error en caso de fallos en la conexión
            System.out.println("Errores encontrado en" + e.getMessage());
        }
    }
}
