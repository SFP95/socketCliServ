package ejercicioContadorNumeros.ParesImpares;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Cliente extends Conexion{
    public Scanner scan=new Scanner(System.in);

    public Cliente() throws IOException {
        super("CLIENTE");
    }
    public void initCliente(){
        try {
            // salida de servidor y recogida de datos
            output_Server = new DataOutputStream(skCliente.getOutputStream());
            output_cliente = new DataOutputStream(skCliente.getOutputStream());

            //EJERCICIO PARES E IMPARES:

            //pide un total de 10 numeros que se mandar al servidor y este te de responde en funcion:
            System.out.println("Dime un número par:");
            int num= scan.nextInt(); //recogid de la respuesta por pantalla
            output_cliente.writeInt(num); // mandado de la respuesta a servidor

            /*----- Lo que recibe el cliente de parte de servidor -----*/

            input_server= new DataInputStream(skCliente.getInputStream());
            int respuesta=input_server.readInt();
            System.out.println("[SERVER] Me has dicho: "+respuesta);

            //cerramos conexion

            skCliente.close();

        } catch (Exception e){
        //mensaje de error en caso de fallos en la conexión
        System.out.println("Errores encontrado en" + e.getMessage());
    }
    }
}
