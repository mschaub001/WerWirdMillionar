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
import java.util.Random;
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

    private List<Fragen> fragen;
    private List<String> antworten;
    private Fragen frage;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<Fragen> getFragen(int level) {
        fragen = new FragenDAO().getFragenNachLevel(level);
        return fragen;
    }

    public Fragen getFrage(int level) {
        Random foo = new Random();
        int randomNumber = foo.nextInt(getFragen(level).size() - 1) + 1;
        frage = getFragen(level).get(randomNumber);
        return frage;
    }

    public void setFrage(Fragen frage) {
        this.frage = frage;
    }

    public List<String> getAntworten() {
        return antworten;
    }

    public void setAntworten(List<String> antworten) {
        this.antworten = antworten;
    }

    public String testAntwort(int antwort, Fragen frage){
        if(frage.getFragenRichtigeAntwort()==antwort){
            return "/login.xhtml";
        }else{
             return "/falsch";
        }
       
        
    }
}
