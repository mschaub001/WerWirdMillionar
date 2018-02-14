/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import objects.Admin;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Noah
 */
@Named(value = "loginController")
@SessionScoped
public class LoginController implements Serializable {

    Admin admin;
    
    @Getter
    @Setter
    private String adminName = "";
    
    @Getter
    @Setter
    private String adminPassword = "";

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String doLogin() {
        AdminDAO adminDAO = new AdminDAO();
        this.admin = adminDAO.check(adminName, adminPassword);

        if (this.admin != null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "judihui "+adminName+"   "+adminPassword, null));
           // LOGGER.log(Level.INFO, "BBB InsecureApp login attempt successful, access granted. IP:{0}, username:{1}, user agent:{2}", new Object[]{LoggerHelper.getRemoteAddr(), username, LoggerHelper.getUserAgent()});
            return "/secured/AdminBackend.xhtml";
        }
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Login failed! "+adminName+"   "+adminPassword, null));
        //LOGGER.log(Level.WARNING, "BBB InsecureApp login attempt failed, access denied. IP:{0}, username:{1}, user agent:{2}", new Object[]{LoggerHelper.getRemoteAddr(), username, LoggerHelper.getUserAgent()});
        return "";
    }

    public List<Admin> getNews() {
        return new AdminDAO().getAll();
    }
}
