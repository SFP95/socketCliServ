/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioAreaCirculo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Cliente extends Conexion{

    public Scanner scan=new Scanner(System.in);

    public Cliente() throws IOException {
        super("CLIENTE");
    }
    public  void  initCLiente(){
        try {
            // salida de servidor y recogida de datos
            output_Server = new DataOutputStream(skCliente.getOutputStream());
            output_cliente = new DataOutputStream(skCliente.getOutputStream());

            //EJERCICIO AREA CIRCULO:
            output_Server.writeUTF("Dime el radio del ciruculo (cm):");
            //System.out.println("Dime el radio del ciruculo (cm):");
            int num= scan.nextInt();
            output_cliente.writeInt(num);;

            /*----- Lo que recibe el cliente de parte de servidor -----*/

            input_server= new DataInputStream(skCliente.getInputStream());
            int resuesta= input_server.read();
            System.out.println("[SERVER] "+resuesta);

        }catch (Exception e){
            //mensaje de error en caso de fallos en la conexión
            System.out.println("Errores encontrado en" + e.getMessage());
        }
    }
}