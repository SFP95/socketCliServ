package ejercicioAreaCirculo;//package sockets2;


import java.io.*;


public class Servidor extends Conexion //Se hereda de conexión para hacer uso de los sockets y demás
{
    public Servidor() throws IOException{super("servidor");} //Se usa el constructor para servidor de sockets2.Conexion

    public String cabecera= "[SERVIDOR]: ";
    public void startServer()//Método para iniciar el servidor
    {
        try
        {
            System.out.println("Esperando..."); //Esperando conexión

            cs = ss.accept(); //Accept comienza el socket y espera una conexión desde un cliente

            System.out.println("Cliente en línea");

            //Se obtiene el flujo de salida del cliente para enviarle mensajes
            salidaCliente = new DataOutputStream(cs.getOutputStream());

            //Se le envía un mensaje al cliente usando su flujo de salida
            salidaCliente.writeUTF("Petición recibida y aceptada");

            //Se obtiene el flujo entrante desde el cliente
            BufferedReader entrada = new BufferedReader(new InputStreamReader(cs.getInputStream()));

            while((mensajeServidor = entrada.readLine()) != null) //Mientras haya mensajes desde el cliente
            {
                //Se muestra por pantalla el mensaje recibido
                salidaCliente.writeUTF("Dime el radio de la circunferencia en cm");

                //recogida de datos introducidos por cliente
                int radio = Integer.parseInt(entrada.readLine());

                //Calculo del aurea del circulo
                int res= (int) (Math.PI+radio*radio);

                //mmensaje con el resultado mostrando tanto el radio como el resultado del calculo
                salidaCliente.writeUTF("El area de  circulo con radio "+ radio + " es de : "+res+" cm.");
            }

            System.out.println("\n---------------------\nFin de la conexión");

            ss.close();//Se finaliza la conexión con el cliente
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}