import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;



public class servidor {
    public static void main(String[] args) {
        ServerSocket servidor2 = null;
        Socket sc=null;
        DataInputStream in;
        DataOutputStream out;
        //puerto
        final int PUERTO= 5000;
        try {
            servidor2=new ServerSocket(PUERTO);
            System.out.println("Servidor inicializado");
            while(true){
                //esperar a que un cliente se conecte
                sc=servidor2.accept();
                //System.out.println("Cliente Conectado");
                in=new DataInputStream(sc.getInputStream());
                out=new DataOutputStream(sc.getOutputStream());
                //mensaje enviado por el cliente
                String mensaje = in.readUTF();
                System.out.println(mensaje);

                //acknowledge
                out.writeUTF("mensaje recibido");

                //cierro el socket
                sc.close();
                //System.out.println("Cliente desconectado");


            }
        } catch (IOException e) {
            System.out.println("error de conexion");
        }
    }
}