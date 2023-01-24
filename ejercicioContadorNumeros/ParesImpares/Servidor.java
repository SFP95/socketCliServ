package ejercicioContadorNumeros.ParesImpares;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main (String[] args) {
        //Se crea el puerto en el que escucha las peticiones
        ServerSocket scServer=null;
        try {
            scServer= new ServerSocket(PORT);
        }catch (IOException e){
            System.out.println("No se escucha anda en el puerto: "+ PORT);
            System.exit(-1);
        }
        Socket scCliente=null;
        BufferedReader entrada=null;
        PrintWriter salida=null;

        System.out.println("Escuchando: "+scServer);

        //Comprobación de conexcion
        try{
            scCliente=scServer.accept(); //se queda esperando
            System.out.println("Conexión aceptada: "+scCliente);

            //canal de ENTRADA:
            entrada=new BufferedReader(new InputStreamReader(scCliente.getInputStream()));

            //Canal de SALIDA:
            salida=new PrintWriter(new BufferedWriter(new OutputStreamWriter(scCliente.getOutputStream())),true);


            //EJERCICIO:

            for (int i=0; i<=5 ; i++){
                salida.println("Dime un número: "); // se envía a cliente

                int num= Integer.parseInt(entrada.readLine()); //recoge el dato del ciente

                if(num%2==0){
                    salida.println("Este es el mensaje con el numero : " + (num) + "\n"); // envia el resultado al cliente
                }else if (num%2!=0){
                    salida.println("Ese no es un número par :( "); //envia el mensaje de error al cliente al no cumplir la condicion
                }
            }

        }catch (IOException e){
            System.out.println("IOException:"+e.getMessage());
        }


    }
}
