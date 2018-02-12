/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import objects.Fragen;

/**
 *
 * @author Noah
 */
public class FragenDAO {
    
    public List<Fragen> getFragenNachLevel(int level){
        final String sql = "SELECT * FROM questions WHERE level='"+level+"'";
        ArrayList<Fragen> fragenList = new ArrayList<>();

        try (Statement stmt = DbAccess.getConnection().createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                fragenList.add(new Fragen(rs.getInt("id"), rs.getString("body"),rs.getString("a"),rs.getString("b"),rs.getString("c"),rs.getString("d"),rs.getInt("correct"),rs.getInt("level")));
            }
        } catch (SQLException e) {
            //LOGGER.log(Level.SEVERE, "BBB InsecureApp Cannot get all news, giving up.", e);
        }
        return fragenList;
    }
    
}
