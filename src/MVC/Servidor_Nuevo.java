package MVC;

import DB.*;
import java.net.*;
import java.io.*;
import java.sql.*;

public class Servidor_Nuevo implements Runnable {


    Servidor_Nuevo esperar;
    ServerSocket servidor;
    Socket sock;
    PrintStream salida;
    BufferedReader entrada;
    InputStreamReader p;
    String c = "";
    String mensaje, mensaje1;
    int puerto = 6001;
    connectionSql cone = new connectionSql();
    Connection con = cone.getConexion();
    PreparedStatement ppt;
    ResultSet rs;
    ClassJugadores cls = new ClassJugadores();
    EquiposMVC equipos = new EquiposMVC();
    Acceso acc = new Acceso();
    public Servidor_Nuevo(Socket soc){
        sock = soc;
    }
    @Override
    public void run() {
         try {           
            System.out.println("Servidor iniciado, esperando cliente.");
            while (true) {
                entrada = new BufferedReader(new InputStreamReader(sock.getInputStream()));
                salida = new PrintStream(sock.getOutputStream());
                try {
                    while (true) {

                        mensaje = entrada.readLine();

                        System.out.println("Servidor recibio 1245 " + mensaje);
                        if (mensaje.equals("Login")) {
                            String  guardar[] = new String[2];
                            System.out.println("Esta dentro de "+mensaje);
                            for (int i = 0; i < guardar.length; i++) {
                                guardar[i] = entrada.readLine();
                            }
                            
                            
                        }else if (mensaje.equals("fin")) {
                            entrada.close();
                            System.out.println("entrada cerrada.");
                            salida.close();
                            System.out.println("salida cerrada.");
                            sock.close();
                            System.out.println("socket cerrado.");
                            break;
                        }
                    }
                    break;
                } catch (SocketException e) {
                    System.out.println("conexion terminada");
                    break;
                }

            }            

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
