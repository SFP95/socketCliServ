package ejercicioContadorNumeros.contador;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class Servidor {

    private Socket socket; //cliente
    private ServerSocket serverSocket; //server
    private DataInputStream bufferDeEntrada = null; //entrada
    private DataOutputStream bufferDeSalida = null; //salida
    Scanner escaner = new Scanner(System.in);
    final String COMANDO_TERMINACION = "salir()"; //comando de salida por terminal para cerrar conexion

    public void levantarConexion(int puerto) {
        try {
            System.out.println("ESTOY DENTRO");
            serverSocket = new ServerSocket(puerto);
            mostrarTexto("Esperando conexión entrante en el puerto " + String.valueOf(puerto) + "...");
            socket = serverSocket.accept();
            mostrarTexto("Conexión establecida con: " + socket.getInetAddress().getHostName() + "\n\n\n");
        } catch (Exception e) {
            mostrarTexto("Error en levantarConexion(): " + e.getMessage());
            System.exit(0);
        }
    }
    public void flujos() {
        try {
            bufferDeEntrada = new DataInputStream(socket.getInputStream());
            bufferDeSalida = new DataOutputStream(socket.getOutputStream());
            bufferDeSalida.flush();
        } catch (IOException e) {
            mostrarTexto("Error en la apertura de flujos");
        }
    }

    public void recibirDatos() {
        String st = "";
        try {
            do {
                st = (String) bufferDeEntrada.readUTF();
                mostrarTexto("\n[Cliente] => " + st);
                System.out.print("\n[Usted] => ");
            } while (!st.equals(COMANDO_TERMINACION));
        } catch (IOException e) {
            cerrarConexion();
        }
    }


    public void enviar(String s) {
        try {
            bufferDeSalida.writeUTF(s);
            bufferDeSalida.flush();
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
            contador(); //ejercico del contador
        }
    }

    public void cerrarConexion() {
        try {
            bufferDeEntrada.close();
            bufferDeSalida.close();
            socket.close();
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

    public void contador() throws IOException { //EJECICIO
        bufferDeSalida.writeUTF("Dime un número: "); // se envía a cliente
        int num= Integer.parseInt(bufferDeEntrada.readLine()); //recoge el dato del ciente
        bufferDeSalida.writeUTF("Este es el mensaje con el numero : " + (num) + "\n"); // envia el resultado al cliente

    }

//    public static void main(String[] args) throws IOException {
//
//        Servidor s = new Servidor();
//        Scanner sc = new Scanner(System.in);
//
//
//        s.ejecutarConexion(Integer.parseInt(puerto));
//        s.escribirDatos();
//
//    }


}