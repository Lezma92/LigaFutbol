package MVC;

import java.sql.*;
import javax.swing.table.DefaultTableModel;
import DB.connectionSql;
import java.util.logging.Level;
import java.util.logging.Logger;

public class metodos {

    PreparedStatement ppt;
    ResultSet rs;
    connectionSql c = new connectionSql();
    Connection con = c.getConexion();

    private DefaultTableModel LlenarTabla(DefaultTableModel modelo1) {
        String sql = "SELECT equipos.nombre from equipos,categorias "
                + "where categorias.id = equipos.id_categoria and"
                + " categorias.nombre = \"Veteranos\";";
        return modelo1;
    }

    private void TablaProximos() {

        String sql = "select equipos.nombre from equipos,categorias where "
                + "categorias.id = equipos.id_categoria and"
                + " categorias.nombre =";
        try {

        } catch (Exception e) {
        }
    }

    private DefaultTableModel ProximosPartidos(DefaultTableModel Pro, String Cat) {
        System.out.println("Si funciona verga" + Cat);
        String sql = "select equipos.nombre from equipos,categorias where "
                + "categorias.id = equipos.id_categoria and"
                + " categorias.nombre = '" + Cat + "'";
        try {
            ppt = con.prepareCall(sql);
            rs = ppt.executeQuery();
            Pro.getDataVector().clear();
            String as[];
            String f[] = new String[1];
            while (rs.next()) {
                f[0] = rs.getString("nombre");
                Cat = rs.getString("nombre");
                System.out.println("" + Cat);

                //System.out.println("" + una);
                Pro.addRow(f);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return Pro;
    }

    public DefaultTableModel setTableM(DefaultTableModel Pro, String Cat) {
        return this.ProximosPartidos(Pro, Cat);
    }
    
    private void generarPartidos(){
        try {
            ppt = con.prepareCall("SELECT equipos.id from equipos, categorias where equipos.id_categoria = categorías.id");
            ResultSet equipo1 = ppt.executeQuery();
            ResultSet equipo2 = ppt.executeQuery();
            ppt = con.prepareCall("SELECT count(equipos.id) from equipos, categorias where equipos.id_categoria = categorías.id");
            rs = ppt.executeQuery();
            
            
            
        } catch (SQLException ex) {
            System.out.println("Mamó el random :'v");
            ex.printStackTrace();
        }
    }
}
