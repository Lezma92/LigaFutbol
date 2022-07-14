package Logica;

import DB.connectionSql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class claseindex {

    connectionSql c = new connectionSql();
    Connection con = c.getConexion();
    PreparedStatement ppt;
    ResultSet rs;

    public DefaultTableModel BuscarJugadores(String reci, DefaultTableModel Modelo) {
        String Sql = "SELECT jugadores.nombre,equipos.nombre,categorias.nombre,jugadores.edad FROM jugadores,equipos,categorias "
                + "WHERE jugadores.nombre LIKE '%" + reci + "%' and equipos.id = jugadores.id_equipo "
                + "and categorias.id = jugadores.id_categoria";
        String filas[] = new String[5];
        try {
            Modelo.getDataVector().clear();
            int id = 1;
            ppt = con.prepareCall(Sql);
            System.out.println(ppt);
            rs = ppt.executeQuery();
            while (rs.next()) {
                filas[0] = String.valueOf(id);
                filas[1] = rs.getString(1);
                filas[2] = rs.getString(2);
                filas[3] = rs.getString(3);
                filas[4] = String.valueOf(rs.getInt(4));
                Modelo.addRow(filas);
                id++;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return Modelo;
    }
}
