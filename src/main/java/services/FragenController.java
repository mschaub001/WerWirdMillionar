/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import objects.Fragen;

/**
 *
 * @author Noah
 */
@Named(value = "fragenController")
@SessionScoped
public class FragenController implements Serializable {

    /**
     * Creates a new instance of FragenController
     */
    
    private int level;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
            
    public List<Fragen> getFragen() {
        return new FragenDAO().getFragenNachLevel(1);
    }
    
    
    
}
