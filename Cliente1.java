import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente1 {
    public static void main(String[] args) {
        final String HOST= "127.0.0.1";
        final int PUERTO = 5000;
        DataInputStream in;
        DataOutputStream out;

        try {
            int a=0;
            while(a==0){
                String mensaj=ingresar();
                Socket sc = new Socket(HOST, PUERTO);
                in=new DataInputStream(sc.getInputStream());
                out=new DataOutputStream(sc.getOutputStream());
                //enviamos mensaje
                
                out.writeUTF(mensaj);
                //recibo mensaje
                String mensaje=in.readUTF();
                System.out.println(mensaje);
                sc.close();
            }
        } catch (IOException e) {
            System.out.println("Error de conexión: cliente");
            //TODO: handle exception
        }
    }

    public static String ingresar(){
        System.out.println ("Ingrese el texto");
        Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner
        String entradaTeclado = entradaEscaner.nextLine ();
        entradaTeclado= "usuario2: "+ entradaTeclado;
        return entradaTeclado;
        
    }
    
}