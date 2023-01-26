package ejercicioAreaCirculo;//package sockets2;


import java.io.*;


public class Servidor extends Conexion{
    public Servidor() throws IOException {
        super("SERVIDOR");
    }
    public void initServidor(){
        try {
            skCliente =skServidor.accept(); // que queda a la espera de recibir la petición de conexión
            System.out.println("- Conexión aceptada de : "+ skCliente.getInetAddress().getHostName());
            System.out.println("------------\n");

            //EJERCICIO:
            input_server=new DataInputStream(skCliente.getInputStream());
            output_Server.writeUTF("Dime el radio del ciruculo (cm):");

            //recogida de datos introducidos por cliente
            int radio = input_server.readInt();

            //Calculo del aurea del circulo
            int res= (int) (Math.PI+radio*radio);

            //mmensaje con el resultado mostrando tanto el radio como el resultado del calculo
            output_Server.writeUTF("El area de  circulo con radio "+ radio + " es de : "+res+" cm.");

        }catch (Exception e){
        //mensaje de error en caso de fallos en la conexión
        System.out.println("Errores encontrado en" + e.getMessage());
    }
    }
}