package CONTADOR;

import java.io.IOException;

public class MainServidor {
    public static void main(String[] args) throws IOException {
        servidor ser = new servidor();
        System.out.println( "Iniciando Servidor");
        ser.iniciaServidor();
    }
}
