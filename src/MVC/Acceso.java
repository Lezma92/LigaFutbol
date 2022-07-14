package MVC;
import DB.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class Acceso {
    PreparedStatement ppt;
    ResultSet rs;
    String msj ="";
    connectionSql c = new connectionSql();
    Connection con = c.getConexion();
    public String Acceder(String datos[]){
        for (int i = 0; i < datos.length; i++) {
            System.out.println(datos[i]);
        }
        String catuser ="",catpass="";        
        String sql ="SELECT * from login where usuario = '"+datos[0]+"' and pass = '"+datos[1]+"'";
        try {
            ppt = con.prepareCall(sql);
            System.out.println(ppt);
            rs = ppt.executeQuery();
            while (rs.next()) {
                catuser = rs.getString("usuario");
                catpass = rs.getString("pass");
            }
            System.out.println(catuser);
             System.out.println(catpass);
            if (datos[0].equals(catuser) && datos[1].equals(catpass)) {
               msj = "Acceso Correcto";
            }else{
                msj ="Muy mal";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msj;
    }
    
    public String AccederCliente(String datos[]){
        for (int i = 0; i < datos.length; i++) {
            System.out.println(datos[i]);
        }
        String catuser ="",catpass="";        
        String sql ="SELECT * from usuarioss where user = '"+datos[0]+"' and pass = '"+datos[1]+"'";
        try {
            ppt = con.prepareCall(sql);
            System.out.println(ppt);
            rs = ppt.executeQuery();
            while (rs.next()) {
                catuser = rs.getString("user");
                catpass = rs.getString("pass");
            }
            System.out.println(catuser);
             System.out.println(catpass);
            if (datos[0].equals(catuser) && datos[1].equals(catpass)) {
               msj = "Acceso Correcto";
            }else{
                msj ="Muy mal";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msj;
    }
}
