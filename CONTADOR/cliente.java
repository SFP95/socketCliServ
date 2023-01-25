package CONTADOR;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class cliente extends conexion{
    public  Scanner scan=new Scanner(System.in);

    public cliente() throws IOException {
        super("cliente");
    }
    public  void iniciarCliente(){
        try {
             //Salida de servidor, recoger lo que le enviemos
            salida_Server = new DataOutputStream(scCliente.getOutputStream());
            salida_cliente = new DataOutputStream(scCliente.getOutputStream());

            for (int i=0; i<3;i++) {
                System.out.println("Dime un número: "); //pide el dato
                //recoge el dato del ciente
                int num = scan.nextInt();
                salida_cliente.writeInt(num);

            }


                //--------------------------------------------------------------
                //lo que va a recibir el cliente

                entrada_cliente= new DataInputStream(scCliente.getInputStream());
                int mensajeRecibido =entrada_cliente.readInt();
                System.out.println("Me has dicho: "+mensajeRecibido);
                scCliente.close(); //cierra


        }catch (IOException e){

        }
    }
}
