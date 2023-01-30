package ejercicioAreaCirculo;

import java.io.IOException;

public class MainCliente {

    public static void main(String[] args) throws IOException
    {
        Cliente cli = new Cliente(); //Se crea el cliente

        System.out.println("Iniciando cliente\n");
        cli.initCLiente(); //Se inicia el cliente
    }
}