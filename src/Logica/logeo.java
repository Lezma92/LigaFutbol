package Logica;

import DB.connectionSql;
import java.sql.*;
import javax.swing.JOptionPane;

public class logeo {

    connectionSql c = new connectionSql();
    Connection con = c.getConexion();
    PreparedStatement ppt;
    ResultSet rs;

    public boolean logear(String user, String pass) {
        boolean bo = false;
        String catuser = "", catpass = "";
        String sql = "select *from login where usuario = '" + user + "' and pass = '" + pass + "'";
        try {
            if (!user.equals("") && !pass.equals(" ")) {
                ppt = con.prepareCall(sql);
                System.out.println(ppt);
                rs = ppt.executeQuery();
                while (rs.next()) {
                    catuser = rs.getString("usuario");
                    catpass = rs.getString("pass");
                }
                System.out.println(catuser);
                System.out.println(catpass);
                if (user.equals(catuser) && pass.equals(catpass)) {
                    return bo = true;
                } else {
                    bo = false;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingresar su usuario y contraseña");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return bo;
    }
}
