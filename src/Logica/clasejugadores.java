package Logica;

import DB.connectionSql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class clasejugadores {

    connectionSql c = new connectionSql();
    Connection con = c.getConexion();
    PreparedStatement ppt;
    ResultSet rs;

    public DefaultTableModel MostrarJugadores(String equipo, String cat, DefaultTableModel Modelo) {
        String sentencia = "call MostrarFechas('" + cat + "','" + equipo + "')";
        String filas[] = new String[4];
        try {
            Modelo.getDataVector().clear();
            ppt = con.prepareCall(sentencia);
            rs = ppt.executeQuery();
            while (rs.next()) {
                filas[0] = rs.getString("id");
                filas[1] = rs.getString("nombre");
                filas[2] = String.valueOf(rs.getInt("edad"));
                filas[3] = rs.getString("fecha_nacimiento");
                Modelo.addRow(filas);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return Modelo;
    }

    public String[] getIDCat(String dat[]) {
        String vec[] = new String[2];
        String sentencia = "SELECT  equipos.id, categorias.id from categorias,equipos "
                + "where categorias.nombre='" + dat[0] + "' and"
                + " equipos.nombre='" + dat[1] + "' and categorias.id=equipos.id_categoria";
        for (int i = 0; i < dat.length; i++) {
            System.out.println("Me estoy llenando: " + dat[i] + "\n");
        }
        try {
            ppt = con.prepareCall(sentencia);
            rs = ppt.executeQuery();
            while (rs.next()) {
                vec[0] = String.valueOf(rs.getInt(1));
                vec[1] = String.valueOf(rs.getInt(2));
            }
            for (int i = 0; i < vec.length; i++) {
                System.out.println(vec[i] + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vec;
    }

    public boolean RegistrarJug(String datos[]) {
        boolean bo = false;
        String vec[] = getIDCat(datos);
        String v[] = new String[2];
        for (int i = 0; i < vec.length; i++) {
            v[i] = vec[i];
        }
        String sentencia = "INSERT into jugadores VALUES (null,?,?,?,?,?);";
        try {
            ppt = con.prepareCall(sentencia);
            ppt.setString(1, v[0]);
            ppt.setString(2, v[1]);
            ppt.setString(3, datos[2]);
            ppt.setString(4, datos[3]);
            ppt.setString(5, datos[4]);
            int as = ppt.executeUpdate();
            if (as > 0) {
                bo = true;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return bo;
    }

    public boolean eliminarJugadorCliente(int id) {
        boolean msg = false;
        String sentSQL = "delete from jugadores where id = " + id + ";";
        try {
            ppt = con.prepareCall(sentSQL);
            int eliminado = ppt.executeUpdate();
            if (eliminado > 0) {
                msg = true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return msg;
    }

    public boolean ActualizarJugador(String datos[]) {
        boolean bo = false;
        String sentencia = "UPDATE jugadores SET nombre = ? ,edad = ? ,fecha_nacimiento= ? WHERE id = ?";
        try {
            ppt = con.prepareCall(sentencia);
            ppt.setString(1, datos[0]);
            ppt.setString(2, datos[1]);
            ppt.setString(3, datos[2]);
            ppt.setString(4, datos[3]);
            int as = ppt.executeUpdate();
            if (as > 0) {
                bo = true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return bo;

    }
}
