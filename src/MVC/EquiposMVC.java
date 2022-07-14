package MVC;

import DB.conexionSqlServer;
import javax.swing.table.DefaultTableModel;
import DB.connectionSql;
import java.sql.*;

public class EquiposMVC {

    public EquiposMVC() {
    }

    connectionSql c = new connectionSql();
    Connection con = c.getConexion();
    PreparedStatement ppt;
    ResultSet rs;

    public String MostrarEquipos(String cat[]) {
       String msg ="";
        String sql = "SELECT equipos.nombre from equipos,categorias where categorias.nombre = '" + cat[0]+ "' and equipos.id_categoria = categorias.id";
        
        String filas[] = new String[1];
        try {
            ppt = con.prepareCall(sql);
            System.out.println(ppt);
            rs = ppt.executeQuery();
            while (rs.next()) {
                 filas[0] = rs.getString("nombre");
                 System.out.println(filas[0]);
                 return filas[0];                 
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }

    private DefaultTableModel SoloNmJug(DefaultTableModel Modelo, Object nombre[]) {
        String sentencia = "SELECT jugadores.nombre from "
                + "jugadores,equipos,categorias where"
                + " equipos.nombre ='" + nombre[0] + "' and categorias.nombre='" + nombre[1] + "' and"
                + " equipos.id = jugadores.id_equipo and categorias.id=jugadores.id_categoria";
        String filas[] = new String[3];
        try {
            ppt = con.prepareCall(sentencia);
            System.out.println(ppt);
            Modelo.getDataVector().clear();
            rs = ppt.executeQuery();
            while (rs.next()) {
                filas[0] = rs.getString("nombre");
                Modelo.addRow(filas);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return Modelo;
    }

    private DefaultTableModel MostrarJugadores(DefaultTableModel Modelo, Object nombre[]) {
        String sentencia = "SELECT jugadores.nombre, jugadores.edad,jugadores.fecha_nacimiento from "
                + "jugadores,equipos,categorias where"
                + " equipos.nombre ='" + nombre[0] + "' and categorias.nombre='" + nombre[1] + "' and"
                + " equipos.id = jugadores.id_equipo and categorias.id=jugadores.id_categoria";
        String filas[] = new String[3];

        try {
            ppt = con.prepareCall(sentencia);
            System.out.println(ppt);
            Modelo.getDataVector().clear();
            rs = ppt.executeQuery();
            while (rs.next()) {
                filas[0] = rs.getString("nombre");
                filas[1] = rs.getString("edad");
                filas[2] = String.valueOf(rs.getDate("fecha_nacimiento"));
                Modelo.addRow(filas);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Modelo;
    }
    private String id1[] = new String[2];

    private DefaultTableModel DatosJugadores(DefaultTableModel Modelo, Object dat[]) {
        String sentencia = "SELECT categorias.id, equipos.id, jugadores.nombre "
                + "from categorias,equipos,jugadores "
                + "where categorias.id=jugadores.id_categoria "
                + "and equipos.id=jugadores.id_equipo "
                + "and jugadores.nombre= '" + dat[0] + "'";
        String fila[] = new String[1];
        try {
            ppt = con.prepareCall(sentencia);
            Modelo.getDataVector().clear();
            rs = ppt.executeQuery();
            while (rs.next()) {
                id1[0] = rs.getString(1);
                id1[1] = rs.getString(2);
                fila[0] = rs.getString(3);
                System.out.println("" + fila[0]);
                Modelo.addRow(fila);
            }
            for (int i = 0; i < id1.length; i++) {
                System.out.println("" + id1[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Modelo;
    }

    public int[] getID(String dat[]) {
        int vec[] = new int[1];
        String sentencia = "SELECT categorias.id, equipos.id from categorias,equipos "
                + "where categorias.nombre='" + dat[0] + "' and"
                + " equipos.nombre='" + dat[1] + "' and categorias.id=equipos.id_categoria";
        try {
            ppt = con.prepareCall(sentencia);
            for (int i = 0; i < vec.length; i++) {
                vec[i] = 0;
            }
            rs = ppt.executeQuery();
            while (rs.next()) {
                vec[0] = Integer.parseInt(rs.getString(1));
                vec[1] = Integer.parseInt(rs.getString(2));
            }
            for (int i = 0; i < vec.length; i++) {
                System.out.println("" + vec[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vec;
    }

    public String[] returnn() {
        String as[] = new String[2];
        return as = this.id1;
    }

    public DefaultTableModel VerJugadores(DefaultTableModel Modelo, Object cat[]) {

        return this.MostrarJugadores(Modelo, cat);

    }

}
