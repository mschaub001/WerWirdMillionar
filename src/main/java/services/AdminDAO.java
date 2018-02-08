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
import java.util.logging.Level;
import objects.Admin;

/**
 *
 * @author Noah
 */
public class AdminDAO {
    
     public Admin check(final String adminName, final String adminPassword) {
         List<Admin> adminList= getAll();
         
         for(int i=0;i<adminList.size();i++){
             if(adminName==adminList.get(i).getAdminName()&adminPassword==adminList.get(i).getAdminPassword()){
                 return adminList.get(i);
             }
         }
         return null;
     }
    
    
     public List<Admin> getAll() {
        final String sql = "SELECT id, posted, header, detail, author, is_admin_news, changed_by FROM news ORDER BY posted DESC";
        ArrayList<Admin> allAdmin = new ArrayList<>();

        try (Statement stmt = DbAccess.getConnection().createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                allAdmin.add(new Admin(rs.getInt("id"), rs.getString("userName"),rs.getString("userPassword")));
            }
        } catch (SQLException e) {
            //LOGGER.log(Level.SEVERE, "BBB InsecureApp Cannot get all news, giving up.", e);
        }
        return allAdmin;
    }
}
