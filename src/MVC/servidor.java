package MVC;

import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;

public class servidor extends Thread {

    static ServerSocket servidor;
    static Socket trafico;

    @Override
    public void run() {
        System.out.println("Servidor iiniciado");
        try {
            int count = 0;
            servidor = new ServerSocket(6001); //tipo ServerSocket
            while (true) {
                count++;
                trafico = servidor.accept(); //tipo socket
                new Thread(new Servidor_Nuevo(trafico)).start();
                System.out.println("cliente numero: " + count);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

}
