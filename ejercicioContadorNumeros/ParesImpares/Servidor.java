package ejercicioContadorNumeros.ParesImpares;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {

    private Socket scCliente; //cliente
    private ServerSocket scServer; //server
    private DataInputStream entrada = null; //entrada
    private DataOutputStream salida = null; //salida
    Scanner escaner = new Scanner(System.in);
    final String COMANDO_TERMINACION = "salir()"; //comando de salida por terminal para cerrar conexion

    public void levantarConexion(int puerto) {
        try {
            scServer = new ServerSocket(puerto);
            mostrarTexto("Esperando conexión entrante en el puerto " + String.valueOf(puerto) + "...");
            scCliente = scServer.accept();
            mostrarTexto("Conexión establecida con: " + scCliente.getInetAddress().getHostName() + "\n\n\n");
        } catch (Exception e) {
            mostrarTexto("Error en levantarConexion(): " + e.getMessage());
            System.exit(0);
        }
    }
    public void flujos() {
        try {
            entrada = new DataInputStream(scCliente.getInputStream());
            salida = new DataOutputStream(scCliente.getOutputStream());
            salida.flush();
        } catch (IOException e) {
            mostrarTexto("Error en la apertura de flujos");
        }
    }
    public void recibirDatos() {
        String st = "";
        try {
            do {
                st = (String) entrada.readUTF();
                mostrarTexto("\n[Cliente] => " + st);
                System.out.print("\n[Usted] => ");
            } while (!st.equals(COMANDO_TERMINACION));
        } catch (IOException e) {
            cerrarConexion();
        }
    }
    public void enviar(String s) {
        try {
            salida.writeUTF(s);
            salida.flush();
        } catch (IOException e) {
            mostrarTexto("Error en enviar(): " + e.getMessage());
        }
    }
    public static void mostrarTexto(String s) {
        System.out.print(s);
    }
    public void escribirDatos() throws IOException {
        while (true) {
            System.out.print("[Usted] => ");
            //enviar(escaner.nextLine());
            contadorParesImpares(); //ejercico del contador
        }
    }
    public void contadorParesImpares() throws IOException {  //EJERCICIO:
        for (int i=0; i<=5 ; i++){
            salida.writeUTF("Dime un número: "); // se envía a cliente

            int num= Integer.parseInt(entrada.readLine()); //recoge el dato del ciente

            if(num%2==0){
                salida.writeUTF("Este es el mensaje con el numero : " + (num) + "\n"); // envia el resultado al cliente
            }else if (num%2!=0){
                salida.writeUTF("Ese no es un número par :( "); //envia el mensaje de error al cliente al no cumplir la condicion
            }
        }
    }
    public void cerrarConexion() {
        try {
            entrada.close();
            salida.close();
            scCliente.close();
        } catch (IOException e) {
            mostrarTexto("Excepción en cerrarConexion(): " + e.getMessage());
        } finally {
            mostrarTexto("Conversación finalizada....");
            System.exit(0);

        }
    }
    public void ejecutarConexion(int puerto) {
        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        levantarConexion(puerto);
                        flujos();
                        recibirDatos();
                    } finally {
                        cerrarConexion();
                    }
                }
            }
        });
        hilo.start();
    }
    public static void main (String[] args) throws IOException {
        Servidor s = new Servidor();
        Scanner sc = new Scanner(System.in);

        mostrarTexto("Ingresa el puerto [5050 por defecto]: ");
        String puerto = sc.nextLine();
        if (puerto.length() <= 0) puerto = "5050";
        s.ejecutarConexion(Integer.parseInt(puerto));
        s.escribirDatos();
    }

    public void InitServidor() {
    }
}
