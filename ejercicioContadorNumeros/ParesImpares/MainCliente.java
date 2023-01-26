package ejercicioContadorNumeros.ParesImpares;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package sockets2;
import ejercicioAreaCirculo.Cliente;

import java.io.IOException;


/**
 *
 * @author achil
 */
public class MainCliente {
    

    public static void main(String[] args) throws IOException
    {
        Cliente cli = new Cliente(); //Se crea el cliente

        System.out.println("Iniciando cliente\n----------------\n");
        cli.startClient(); //Se inicia el cliente
    }
}