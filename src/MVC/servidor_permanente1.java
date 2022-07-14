package MVC;

import DB.connectionSql;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author jacs_
 */
public class servidor_permanente1 implements Runnable {

    //Socket pollo;
    ServerSocket servidor;
    Socket misocket;
    PrintStream salida;
    BufferedReader entrada;
    InputStreamReader p;
    String c = "";
    String mensaje, mensaje1;
    int puerto = 6001;
    Scanner esc;

    connectionSql con = new connectionSql();
    Connection co;
    PreparedStatement ps;
    ResultSet rs;

    public servidor_permanente1(Socket s) {
        misocket = s;
        co = con.getConexion();
        ///pollo=s;
    }

    private void abrirFlujos(){
        try {
            p = new InputStreamReader(misocket.getInputStream());
            entrada = new BufferedReader(p);
            salida = new PrintStream(misocket.getOutputStream());
        } catch (Exception e) {
            System.out.println(e + "En abrirFlujos") ;
        }
    }
    
    private void cerrarFlujos() {
        try {
            entrada.close();
            System.out.println("entrada cerrada.");
            salida.close();
            System.out.println("salida cerrada.");
            misocket.close();
            System.out.println("socket cerrado.");
        } catch (Exception e) {
            System.out.println(e + "en cerrarFlujos");
        }
    }

    void verificarLogin() {
        String user, pass, msg;
        try {
           
            abrirFlujos();
            //Recibe nombre de usuario
            user = entrada.readLine();
            System.out.println("Servidor recibio" + user);
            //recibe pass
            pass = entrada.readLine();
            System.out.println("Servidor recibio" + pass);
            //genera comprobación
            try {
                ps = co.prepareStatement("Select usuario from equipos where usuario = '" + user + "';");
                rs = ps.executeQuery();

                if (rs.next()) {
                    ps = co.prepareStatement("Select pass from equipos where usuario = '" + user + "';");
                    rs = ps.executeQuery();
                    if (rs.next()) {
                        msg = "Correct";
                        ps = co.prepareStatement("Select * from equipos where usuario = '" + user + "' and ;");
                        rs = ps.executeQuery();
                        if (rs.next()) {
                            salida.println(rs.getString(3));
                            salida.println(rs.getString(4));
                        }
                    } else {
                        msg = "Pass incorrect";
                    }
                } else {
                    msg = "User not found";
                }

            } catch (Exception a) {
                System.out.println(a);
                msg = "" + a;
            }

            salida.println(msg);
            System.out.println("Servidor envio respuesta: " + msg);
            cerrarFlujos();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void run() {
        try {
//            while (true) {
//                //////////////////////////////
//                //servidor permanente//
                servidor = new ServerSocket(puerto);
                System.out.println("Servidor iniciado, esperando cliente.");
                verificarLogin();
//                while (true) {
                    /*misocket=servidor.accept();//establece comunicacion con el cliente. Espera a conectarse un cliente.
                System.out.println("Cliente conectado.");*/
//
//                    esc=new Scanner(System.in);
//                    p = new InputStreamReader(misocket.getInputStream());
//                    entrada = new BufferedReader(p);
//                    salida = new PrintStream(misocket.getOutputStream());
//
//                    do {
//                        mensaje = entrada.readLine();
//                        System.out.println("Servidor recibio" + mensaje);
//                        JOptionPane.showMessageDialog(null, mensaje);
//                        salida.println(JOptionPane.showInputDialog("Escribe una respuesta al usuario"));
//                        salida.writeUTF("holis");
//                        System.out.println("Servidor envio respuesta");
//
//                        /*System.out.println("quiere enviar otro mensaje?");
//                    c=esc.nextLine();*/
//                    } while (!mensaje.equals("cerrar"));
//                    if (JOptionPane.showInputDialog(null, "desea salir? \n a)si b)no").equals("a")) {
//                        entrada.close();
//                        System.out.println("entrada cerrada.");
//                        salida.close();
//                        System.out.println("salida cerrada.");
//                        misocket.close();
//                        System.out.println("socket cerrado.");
//                        break;
//                    }
//                }
//                /////////////////////////////
//                break;
//            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
