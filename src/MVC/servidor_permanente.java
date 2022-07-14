package MVC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import DB.*;
import java.sql.Connection;


public class servidor_permanente implements Runnable {

    //servidor_permanente servper;
    //Socket pollo;
    ServerSocket servidor;
    Socket misocket;
    PrintStream salida;
    BufferedReader entrada;
    InputStreamReader p;
    String c = "";
    String mensaje, mensaje1;
    int puerto = 6001;
    //Scanner esc;
    connectionSql co = new connectionSql();
    Connection con = co.getConexion();
    PreparedStatement ppt;
    ResultSet rs;
    ClassJugadores cls = new ClassJugadores();
    EquiposMVC equipos = new EquiposMVC();
    Acceso acc = new Acceso();

    public servidor_permanente(Socket s) {
        misocket = s;
        ///pollo=s;

    }

    @Override
    public void run() {
        try {
           
            System.out.println("Servidor iniciado, esperando cliente.");
            while (true) {
                entrada = new BufferedReader(new InputStreamReader(misocket.getInputStream()));
                salida = new PrintStream(misocket.getOutputStream());
                try {
                    while (true) {

                        mensaje = entrada.readLine();

                        System.out.println("Servidor recibio 1245 " + mensaje);

                        if (mensaje.equals("id")) {
                            System.out.println("Busqueda de IDS");
                            String arr_alta[] = new String[3];

                            for (int i = 1; i < arr_alta.length; i++) {
                                arr_alta[i] = entrada.readLine();
                            }
                            String vector[] = new String[2];
                            String v[] = cls.getID(arr_alta);
                            for (int i = 0; i < vector.length; i++) {
                                vector[i] = v[i];
                                salida.println(vector[i]);
                            }

                        } else if (mensaje.equals("nombreEq")) {

                            System.out.println("Busqueda de nombres");
                            String arr_alta[] = new String[3];
                            for (int i = 1; i < arr_alta.length; i++) {
                                arr_alta[i] = entrada.readLine();
                            }
                            String vector[] = new String[2];
                            String v[] = cls.getEquipo(arr_alta);
                            for (int i = 0; i < vector.length; i++) {
                                vector[i] = v[i];
                                salida.println(vector[i]);
                            }

                        } else if (mensaje.equals("alta")) {
                            System.out.println("procedimiento de alta");
                            String arr_alta1[] = new String[6];

                            for (int i = 1; i < arr_alta1.length; i++) {
                                arr_alta1[i] = entrada.readLine();
                            }
                            System.out.println("Se han ingresaod los datos.");
                            salida.println(cls.RegistrarJug(arr_alta1));
                        } else if (mensaje.equals("buscar")) {
                            System.out.println("procedimiento busqueda ");
                        } else if (mensaje.equals("baja")) {

                        } else if (mensaje.equals("VISTAEQUIPOS")) {
                            System.out.println("Ingrese a llenar tabla");
                            String msg = "";
                            mensaje = entrada.readLine();
                            //int noMsgs = obtenerNoReg(mensaje);
                            //salida.print(noMsgs);
                            String sql = "SELECT equipos.nombre from equipos,categorias where categorias.nombre = '" + mensaje + "' and equipos.id_categoria = categorias.id";
                            try {
                                ppt = con.prepareCall(sql);
                                System.out.println(ppt);
                                rs = ppt.executeQuery();
                                while (rs.next()) {
                                    salida.println(rs.getString("nombre"));
                                    System.out.println(rs.getString("nombre"));
                                }
                                salida.println("Hecho");

                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                        } else if (mensaje.equals("VISTAJUGADORES")) {
                            System.out.println(" Voy a mOstrar Los jugadores");
                            String juga[] = new String[2];
                            for (int i = 0; i < juga.length; i++) {
                                juga[i] = entrada.readLine();
                            }
                            String sentencia = "SELECT jugadores.id, jugadores.nombre, jugadores.edad, jugadores.fecha_nacimiento from "
                                    + "jugadores,equipos,categorias where"
                                    + " equipos.id ='" + juga[0] + "' and categorias.id='" + juga[1] + "' and"
                                    + " equipos.id = jugadores.id_equipo and categorias.id=jugadores.id_categoria";

                            try {
                                ppt = con.prepareCall(sentencia);
                                Object Obj[] = new Object[3];
                                System.out.println(ppt);
                                System.out.println(ppt);
                                rs = ppt.executeQuery();
                                while (rs.next()) {
                                    Obj[0] = (rs.getString("nombre"));
                                    Obj[1] = (String.valueOf(rs.getDate("fecha_nacimiento")));
                                    Obj[2] = (rs.getString("edad"));
                                    System.out.println(rs.getString("nombre") + rs.getString("edad") + String.valueOf(rs.getDate("fecha_nacimiento")));
                                    for (int i = 0; i < Obj.length; i++) {
                                        salida.println(Obj[i]);
                                    }
                                }
                                salida.println("Finalizada");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } else if (mensaje.equals("Ingresar")) {
                            String recLog[] = new String[2];
                            System.out.println("Usted se esta logeando");
                            for (int s = 0; s < recLog.length; s++) {
                                recLog[s] = entrada.readLine();
                                System.out.println(recLog[s]);
                            }
                            String recibir = "";
                            recibir = acc.Acceder(recLog);
                            System.out.println(recibir);
                            salida.println(recibir);
                            System.out.println("Datos correctos");

                        } else if (mensaje.equals("IngresarCliente")) {
                            String recLog[] = new String[2];
                            System.out.println("cliente logeando");
                            for (int s = 0; s < recLog.length; s++) {
                                recLog[s] = entrada.readLine();
                                System.out.println(recLog[s]);
                            }
                            String recibir = "";
                          /*  recibir = acc.AccederCliente(recLog);
                            System.out.println(recibir);
                            salida.println(recibir);
                            System.out.println("Datos correctos");*/

                        } else if (mensaje.equals("fin")) {
                            entrada.close();
                            System.out.println("entrada cerrada.");
                            salida.close();
                            System.out.println("salida cerrada.");
                            misocket.close();
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
            ///////////////////////////////

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int obtenerNoReg(String nombreCat) {
        int no = 0;
        String sql = "SELECT count(equipos.id) from equipos,categorias where categorias.nombre = '" + nombreCat + "' and equipos.id_categoria = categorias.id";
        try {
            ppt = con.prepareCall(sql);
            System.out.println(ppt);
            rs = ppt.executeQuery();
        } catch (Exception e) {
        }
        return 0;
    }
}
