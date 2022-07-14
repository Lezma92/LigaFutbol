package MVC;

import DB.connectionSql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClassJugadores {

    private connectionSql c = new connectionSql();
    private Connection con = c.getConexion();
    private PreparedStatement ppt;
    private ResultSet rs;
    private SimpleDateFormat formato;
    private Date fecha;

    public Object[] getIDs(Object dat[]) {
        Object vec[] = new Object[1];
        String sentencia = "SELECT jugadores.id from "
                + "jugadores,categorias,equipos where  jugadores.nombre= '" + dat[1] + "' and "
                + "categorias.nombre= '" + dat[3] + "' and equipos.nombre= '" + dat[2] + "' and categorias.id=equipos.id_categoria";
        try {

            ppt = con.prepareCall(sentencia);
            rs = ppt.executeQuery();
            while (rs.next()) {
                vec[0] = rs.getInt(1);
            }
            for (int i = 0; i < vec.length; i++) {
                System.out.println("" + vec[i]);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vec;
    }

    public String[] getEquipo(String dat[]) {
        String vec[] = new String[2];
        String sentencia
                = "SELECT  equipos.nombre, categorias.nombre "
                + "from categorias, equipos, usuarioss "
                + "where usuarioss.user = '" + dat[1] + "'"
                + "and usuarioss.pass = '" + dat[2] + "'"
                + "and usuarioss.id_categoria = categorias.id and usuarioss.id_equipo = equipos.id;";
        try {
            ppt = con.prepareCall(sentencia);
            System.out.println(ppt);
            rs = ppt.executeQuery();
            while (rs.next()) {
                vec[0] = rs.getString(1);
                vec[1] = rs.getString(2);
            }
            for (int i = 0; i < vec.length; i++) {
                System.out.println("" + vec[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vec;
    }

    public String[] getID(String dat[]) {
        String vec[] = new String[2];
        String sentencia = "SELECT  equipos.id, categorias.id from categorias,equipos "
                + "where categorias.nombre='" + dat[2] + "' and"
                + " equipos.nombre='" + dat[1] + "' and categorias.id=equipos.id_categoria";
        try {

            ppt = con.prepareCall(sentencia);
            rs = ppt.executeQuery();
            while (rs.next()) {
                vec[0] = String.valueOf(rs.getInt(1));
                vec[1] = String.valueOf(rs.getInt(2));
            }
            for (int i = 0; i < vec.length; i++) {
                System.out.println("" + vec[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vec;
    }

    public String RegistrarJug(String datos[]) {
        String msg = "";
        String sentencia = "INSERT into jugadores VALUES (null, ?, ?,?,?,?);";

        try {
            ppt = con.prepareCall(sentencia);
            ppt.setString(1, datos[2]);
            ppt.setString(2, datos[1]);
            ppt.setString(3, datos[3]);
            ppt.setString(4, datos[4]);
            ppt.setString(5, datos[5]);
            ppt.executeUpdate();
            msg = "Hecho";

        } catch (Exception e) {
            e.printStackTrace();
            return msg = e.getMessage();
        }
        return msg;
    }

    private boolean EliminarJug(Object datos[]) {
        boolean b = false;
        String sentSQL = "delete from jugadores where nombre ='" + datos[0] + "' "
                + "and jugadores.id_equipo =" + datos[2] + " and jugadores.id_categoria =" + datos[1];
        try {
            ppt = con.prepareCall(sentSQL);
            int eliminado = ppt.executeUpdate();
            if (eliminado > 0) {
                b = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }

    private boolean Mod_Jugador(Object datos[]) {
        boolean b = false;
        String ve = "UPDATE jugadores set jugadores.nombre = '1',"
                + " jugadores.edad = 1,"
                + " jugadores.fecha_nacimiento = 'Roberto Gomez Bolaños' where jugadores.id =98;";
        String SentenciaSQL = "UPDATE jugadores set jugadores.nombre = '" + datos[0] + "', "
                + "jugadores.edad = " + datos[1] + ", jugadores.fecha_nacimiento = '" + datos[2] + "' where jugadores.id =" + datos[3] + ";";
        try {
            ppt = con.prepareCall(SentenciaSQL);
            System.out.println(ppt);
            int si = ppt.executeUpdate();
            if (si != 0) {
                return b = true;
            } else {
                return b = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }

   

    public boolean RegistrarJuga(Object datos[], int opc) {
        boolean opciones = true;
        switch (opc) {
            case 1:

                break;
            case 2:
                opciones = this.EliminarJug(datos);
                break;
            case 3:
                opciones = this.Mod_Jugador(datos);
                break;

        }
        return opciones;

    }

    

}
