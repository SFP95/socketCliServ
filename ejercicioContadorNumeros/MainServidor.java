package ejercicioContadorNumeros;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package sockets2;
import ejercicioAreaCirculo.Servidor;

import java.io.IOException;
/**
 *
 * @author achil
 */
public class MainServidor {
    

    public static void main(String[] args) throws IOException
    {
        ejercicioAreaCirculo.Servidor serv = new Servidor(); //Se crea el servidor

        System.out.println("Iniciando servidor\n");
        serv.startServer(); //Se inicia el servidor
    }
}