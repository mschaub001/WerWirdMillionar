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
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import objects.Fragen;
import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;
import java.util.logging.Level;
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
    private int level = 1;

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

    private void naechsteFrage() {
        LOGGER.log(Level.SEVERE, "naechsteFrage");
        Random foo = new Random();
        int randomNumber = foo.nextInt(getFragen(getLevel()).size() - 1) + 1;
        frage = getFragen(getLevel()).get(randomNumber);
        LOGGER.log(Level.SEVERE, "naechsteFrage: "+getLevel()+"/"+frage.getFragenId()+"/"+frage.getFragenBody());
       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "getfrage!" + frage.getFragenBody() + "  " + frage.getFragenAntworten() + frage.getFragenRichtigeAntwort(), null));
    }
    
    public Fragen getFrage() {

        if (frage == null)
            naechsteFrage();
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

    public String testAntwort(int antwort, int fraget) {
        LOGGER.log(Level.SEVERE, "testAntwort: "+antwort+", "+fraget);
        FragenDAO fragenDAO = new FragenDAO(); 
        Fragen frageFromDb = fragenDAO.getFragenNachId(fraget);
        LOGGER.log(Level.SEVERE, "testAntwort: "+antwort+", "+frageFromDb.getFragenLevel()+"/"+fraget+"/"+frageFromDb.getFragenBody());
        if (antwort == frageFromDb.getFragenRichtigeAntwort()) {
            setLevel(getLevel() + 1);
            naechsteFrage();
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "RICHTIG!" + frageFromDb.getFragenBody() + "  " + frageFromDb.getFragenAntworten() + frageFromDb.getFragenRichtigeAntwort(), null));

            return "/index.xhtml";
        } else {
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "FALSCH!" + frageFromDb.getFragenBody() + "  " + frageFromDb.getFragenAntworten() + frageFromDb.getFragenRichtigeAntwort(), null));

            return "/falsch.xhtml";
        }

    }
}
