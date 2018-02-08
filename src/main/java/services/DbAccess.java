package services;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;

/**
 *
 * @author Michael Schneider <michael.schneider@bbbaden.ch>
 */
public class DbAccess {

    private final static String ADMIN_DB;
    private static volatile Connection connection;
   // private final static Logger LOGGER = Logger.getLogger(DbAccess.class.getName());

    static {
        String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");
        path = path + "WEB-INF\\news.sqlite.db";

        ADMIN_DB = path;
    }

    private static void connect() {
        if (connection == null) {
            try {
                Class.forName("org.sqlite.JDBC");
                String url = "jdbc:sqlite:" + ADMIN_DB;
                connection = DriverManager.getConnection(url);
            } catch (SQLException | ClassNotFoundException e) {
               // LOGGER.log(Level.SEVERE, "BBB InsecureApp Cannot connect to database, giving up.", e);
            }
        }
    }

    public static Connection getConnection() {
        connect();
        return connection;
    }

    public static boolean tableExists(String tableName) {
        connect();
        boolean exists = false;
        try {
            final DatabaseMetaData meta = connection.getMetaData();
            final ResultSet tables = meta.getTables(null, null, tableName, null);
            exists = tables.next();

        } catch (SQLException e) {
            //LOGGER.log(Level.SEVERE, "BBB InsecureApp Cannot check if table exists, giving up.", e);
        }
        return exists;
    }
}
