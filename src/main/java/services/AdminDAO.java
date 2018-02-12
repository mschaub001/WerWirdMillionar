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
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import objects.Admin;

/**
 *
 * @author Noah
 */
public class AdminDAO {
    
     public Admin check(final String adminName, final String adminPassword) {
         List<Admin> adminList= getAll();
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, adminList.get(0).getAdminName(), null));
         for(int i=0;i<adminList.size();i++){
             if(adminName.equals(adminList.get(i).getAdminName())&adminPassword.equals(adminList.get(i).getAdminPassword())){
                 return adminList.get(i);
             }
         }
         return null;
     }
    
    
     public List<Admin> getAll() {
        final String sql = "SELECT id,adminName,adminPassword FROM admin";
        ArrayList<Admin> allAdmin = new ArrayList<>();

        try (Statement stmt = DbAccess.getConnection().createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                allAdmin.add(new Admin(rs.getInt("id"), rs.getString("adminName"),rs.getString("adminPassword")));
            }
        } catch (SQLException e) {
            //LOGGER.log(Level.SEVERE, "BBB InsecureApp Cannot get all news, giving up.", e);
        }
        return allAdmin;
    }
}
