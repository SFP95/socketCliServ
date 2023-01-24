/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioAreaCirculo;

/**
 *
 * @author achil
 */



import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Cliente extends ejercicioAreaCirculo.Conexion {

    private Scanner sc= new Scanner(System.in);
    public Cliente() throws IOException{super("cliente");} //Se usa el constructor para cliente de sockets2.Conexion

    public String respuesta;

    public void startClient() //Método para iniciar el cliente
    {
        try
        {
            //Flujo de datos hacia el servidor
            salidaServidor = new DataOutputStream(cs.getOutputStream());

            //recogida de los datos  que se piden por pantalla
            respuesta=sc.nextLine();
            //envio de los datos al servidor
            salidaServidor.writeUTF(respuesta);

            cs.close();//Fin de la conexión

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}