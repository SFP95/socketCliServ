package ejercicioContadorNumeros.ParesImpares;/*
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
public class MainCliente {
    

    public static void main(String[] args) throws IOException
    {
        Cliente cli =new Cliente(); //Se crea el cliente

        System.out.println("\nIniciando cliente\n----------------\n");
        cli.initCliente(); //Se inicia el cliente
    }
}