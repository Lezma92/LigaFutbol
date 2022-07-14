package DB;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class conexionSqlServer {

    private Connection x = null;

    private  void conectar() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            x = DriverManager.getConnection("jdbc:sqlserver://192.168.80.56; user = sa; password = Equipo5_; database = liga_futbol");
            System.out.println("LISTO");
            System.out.println("CONECTADO");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("mal ");
            e.printStackTrace();
        }       
    }
    public Connection getCon(){
        this.conectar();
        return x;
    }
    public void OFf(){
        x = null;
    }
    public static void main(String[]args){
        conexionSqlServer sql = new conexionSqlServer();
        Connection c = sql.getCon();
        if (c != null) {
            JOptionPane.showMessageDialog(null, "Conectado ");
        }else{
            JOptionPane.showMessageDialog(null, "Error de conexxion");
        }
    }
}
