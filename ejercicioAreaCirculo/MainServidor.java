package ejercicioAreaCirculo;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package sockets2;
import java.io.IOException;
/**
 *
 * @author achil
 */
public class MainServidor {
    

    public static void main(String[] args) throws IOException
    {
        Servidor serv = new Servidor(); //Se crea el servidor

        System.out.println("Iniciando servidor\n");
        serv.initServidor(); //Se inicia el servidor
    }
}