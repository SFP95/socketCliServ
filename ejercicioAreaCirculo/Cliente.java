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



import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;


public class Cliente extends ejercicioAreaCirculo.Conexion {

    private Scanner sc= new Scanner(System.in);
    public Cliente() throws IOException{super("cliente");} //Se usa el constructor para cliente de sockets2.Conexion

    public void startClient() //Método para iniciar el cliente
    {
        try
        {
            //Flujo de datos hacia el servidor
            salidaServidor = new DataOutputStream(cs.getOutputStream());


            //contador mas numeros pares he impares:
            for (int i=0; i<=10 ; i++){
                System.out.println("Dime un numero: ");

                int num =sc.nextInt();
                if(num%2==0){
                    salidaServidor.writeUTF("Este es el mensaje número " + (num) + "\n");
                }else if (num%2!=0){
                    salidaServidor.writeUTF("Ese no es un número par ¬¬ ");
                }
            }

            //Contado con numero introducido por pantalla:
            for (int i=0; i<=10 ; i++){
                System.out.println("Dime un numero: ");

                int num =sc.nextInt();
                if(num%2==0){
                    salidaServidor.writeUTF("Este es el mensaje número " + (num) + "\n");
                }else if (num%2!=0){
                    salidaServidor.writeUTF("Ese no es un número par ¬¬ ");
                }
            }

            cs.close();//Fin de la conexión

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}