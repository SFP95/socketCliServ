package EJEMPLO;

import java.io.IOException;

public class MainCliente {
    public static void main(String[] args) throws IOException {
        cliente cli= new cliente();
        System.out.println( "Iniciando Cliente");
        cli.iniciarCliente();
    }
}
