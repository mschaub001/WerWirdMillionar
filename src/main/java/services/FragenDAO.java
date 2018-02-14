/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import objects.Fragen;

/**
 *
 * @author Noah
 */
public class FragenDAO {

    public List<Fragen> getFragenNachLevel(int level) {
        final String sql = "SELECT * FROM questions WHERE level='" + level + "'";
        ArrayList<Fragen> fragenList = new ArrayList<>();

        try (Statement stmt = DbAccess.getConnection().createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                fragenList.add(new Fragen(rs.getInt("questionID"), rs.getString("body"), rs.getString("a"), rs.getString("b"), rs.getString("c"), rs.getString("d"), rs.getInt("correct"), rs.getInt("level")));
            }
        } catch (SQLException e) {
            //LOGGER.log(Level.SEVERE, "BBB InsecureApp Cannot get all news, giving up.", e);
        }
        return fragenList;
    }

    public Fragen getFragenNachId(int id) {
        final String sql = "SELECT * FROM questions WHERE questionId='" + id + "'";
        Fragen frage;
        frage = new Fragen();
        try (Statement stmt = DbAccess.getConnection().createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                frage=new Fragen(rs.getInt("questionID"), rs.getString("body"), rs.getString("a"), rs.getString("b"), rs.getString("c"), rs.getString("d"), rs.getInt("correct"), rs.getInt("level"));
            }
        } catch (SQLException e) {
            //LOGGER.log(Level.SEVERE, "BBB InsecureApp Cannot get all news, giving up.", e);
            
        }
      
        return frage;
    }
    
     public int insert(Fragen frage) {
        final String sql = "INSERT INTO questions (questionID, body, a, b, c, d,correct,level) VALUES (?,?,?,?,?,?,?,?)";
        int id = 0;

        try (PreparedStatement stmt = DbAccess.getConnection().prepareStatement(sql)) {
            stmt.setInt(1,2000+frage.getFragenRichtigeAntwort()*frage.getFragenLevel());
            stmt.setString(2, frage.getFragenBody());
            stmt.setString(3, frage.getFragenAntwortA());
            stmt.setString(4, frage.getFragenAntwortB());
            stmt.setString(5, frage.getFragenAntwortC());
            stmt.setString(6, frage.getFragenAntwortD());
             stmt.setInt(7, frage.getFragenRichtigeAntwort());
              stmt.setInt(8, frage.getFragenLevel());
            stmt.executeUpdate();
            id = stmt.getGeneratedKeys().getInt(1);
        } catch (SQLException e) {
          //LOGGER.log(Level.SEVERE, "BBB InsecureApp Cannot insert news, giving up.", e);
        }

        return id;

    }

}
