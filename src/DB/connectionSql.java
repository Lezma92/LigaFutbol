package DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class connectionSql {

    private String bd = "liga_futbol";
    private String user = "root";
    private String pass = "22060430";
    private String url = "jdbc:mysql://127.0.0.1/" + bd;
    private Connection con = null;

    private void Conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConexion() {
        this.Conectar();
        return con;
    }

    public void off() {
        con = null;
    }
}
