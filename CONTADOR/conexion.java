package CONTADOR;

import ejercicioContadorNumeros.contador.Cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class conexion {
    private final int _PUERtO=1234;
    private final String _HOST="localhost";
    protected  String mensajeServidor;
    protected ServerSocket scServer;
    protected Socket scCliente;
    protected DataOutputStream salida_Server, salida_cliente;
    DataInputStream entrada_cliente, entrada_server;

    public conexion(String tipo) throws IOException{
        if (tipo.equalsIgnoreCase("servidor")){
            scCliente = new Socket();
            scServer = new ServerSocket(_PUERtO);
        }else {
            scCliente=new Socket(_HOST,_PUERtO);
        }
    }

}
