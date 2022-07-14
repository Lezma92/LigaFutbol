package Logica;

import DB.connectionSql;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class claseequipos {

    connectionSql c = new connectionSql();
    Connection con = c.getConexion();
    PreparedStatement ppt;
    ResultSet rs;

    public int obtenerNoCat() {
        int cat = 0;
        String sql = "Select count(id) from categorias";
        try {
            ppt = con.prepareCall(sql);
            rs = ppt.executeQuery();
            if (rs.next()) {
                cat = rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return cat;
    }

    public String[] llenarCombo() {
        String sql = "select nombre from categorias";
        String recibir[] = new String[obtenerNoCat()];
        try {
            ppt = con.prepareCall(sql);
            rs = ppt.executeQuery();
            int i = 0;
            while (rs.next()) {
                recibir[i] = rs.getString(1);
                i++;
            }
        } catch (Exception e) {
        }
        return recibir;
    }

    public DefaultTableModel MostrarEquipos(String cat, DefaultTableModel Modelo) {
        String sql = "SELECT equipos.nombre from equipos,categorias where"
                + " categorias.nombre = '" + cat + "' and equipos.id_categoria = categorias.id";

        String filas[] = new String[1];
        try {
            Modelo.getDataVector().clear();
            ppt = con.prepareCall(sql);
            rs = ppt.executeQuery();
            while (rs.next()) {
                filas[0] = rs.getString("nombre");
                Modelo.addRow(filas);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return Modelo;
    }

    public DefaultTableModel MostrarJugadores(String datos[], DefaultTableModel Modelo) {
        String sql = "call MostrarJugadores('" + datos[0] + "','" + datos[1] + "');";
        String fila[] = new String[1];
        try {
            Modelo.getDataVector().clear();
            ppt = con.prepareCall(sql);
            rs = ppt.executeQuery();
            while (rs.next()) {
                fila[0] = rs.getString(1);
                Modelo.addRow(fila);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return Modelo;
    }

    public String getidCategoria(String dat) {
        String vec = "";
        String sentencia = "select id from categorias where nombre = '" + dat + "'";
        try {
            ppt = con.prepareCall(sentencia);
            rs = ppt.executeQuery();
            while (rs.next()) {
                vec = String.valueOf(rs.getInt(1));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return vec;
    }

    public boolean EliminarEquipo(String datos[]) {
        boolean b = false;
        int id = Integer.parseInt(getidCategoria(datos[0]));
        String sql = "delete from equipos where nombre = '" + datos[1] + "' and id_categoria = " + id + ";", msj = "";
        try {
            ppt = con.prepareCall(sql);
            int as = ppt.executeUpdate();
            if (as > 0) {
                b = true;
            } else {
                b = false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return b;
    }

    public boolean RegistrarEquipos(String datos[]) {
        String sentencia = "insert into equipos values(null,?,?)";
        boolean v = false;
        int id = Integer.parseInt(getidCategoria(datos[0]));
        try {
            ppt = con.prepareCall(sentencia);
            ppt.setInt(1, id);
            ppt.setString(2, datos[1]);
            int correct = ppt.executeUpdate();
            if (correct > 0) {
                v = true;
            } else {
                v = false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return v;
    }

    public boolean ActualizarEquipo(String datos[]) {
        boolean bo = false;
        int idcat = Integer.parseInt(getidCategoria(datos[0]));
        String sentencia = "UPDATE equipos SET nombre = ? where id_categoria = ? and nombre = ?";
        try {
            ppt = con.prepareCall(sentencia);
            System.out.println(ppt);
            ppt.setString(1, datos[1]);
            ppt.setInt(2, idcat);
            ppt.setString(3, datos[2]);
            int p = ppt.executeUpdate();
            if (p > 0) {
                bo = true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return bo;
    }
}
