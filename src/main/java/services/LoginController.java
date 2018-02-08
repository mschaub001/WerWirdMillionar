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
    private String adminName = "";
    private String adminPassword = "";

    public String doLogin() {
        AdminDAO adminDAO = new AdminDAO();
        this.admin = adminDAO.check(adminName, adminPassword);

        if (this.admin != null) {
           // LOGGER.log(Level.INFO, "BBB InsecureApp login attempt successful, access granted. IP:{0}, username:{1}, user agent:{2}", new Object[]{LoggerHelper.getRemoteAddr(), username, LoggerHelper.getUserAgent()});
            return "/secured/index?faces-redirect=true";
        }
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Login failed!", null));
        //LOGGER.log(Level.WARNING, "BBB InsecureApp login attempt failed, access denied. IP:{0}, username:{1}, user agent:{2}", new Object[]{LoggerHelper.getRemoteAddr(), username, LoggerHelper.getUserAgent()});
        return "/index?faces-redirect=true";
    }

    public List<Admin> getNews() {
        return new AdminDAO().getAll();
    }
}
