/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import objects.Fragen;

/**
 *
 * @author Noah
 */
@Named(value = "adminController")
@Dependent
public class AdminController {

    Fragen current;
    private String frageBody;
    private List<String> frageAntworten;
    private int frageLevel;
    private int frageRichtigeAntwort;
    private String frageAntwortA;
    private String frageAntwortB;
    private String frageAntwortC;
    private String frageAntwortD;

    /**
     * Creates a new instance of AdminController
     */
    public String create() {
new FragenDAO().insert(current);
        current = null;
        return "/secured/AdminBackend.xhtml";
    }

    public AdminController() {
        this.current = new Fragen();
    }

    public String getFrageBody() {
        return frageBody;
    }

    public void setFrageBody(String frageBody) {
        this.frageBody = frageBody;
    }

    public List<String> getFrageAntworten() {
        return frageAntworten;
    }

    public void setFrageAntworten(List<String> frageAntworten) {
        this.frageAntworten = frageAntworten;
    }

    public int getFrageLevel() {
        return frageLevel;
    }

    public void setFrageLevel(int frageLevel) {
        this.frageLevel = frageLevel;
    }

    public int getFrageRichtigeAntwort() {
        return frageRichtigeAntwort;
    }

    public void setFrageRichtigeAntwort(int frageRichtigeAntwort) {
        this.frageRichtigeAntwort = frageRichtigeAntwort;
    }

    public String getFrageAntwortA() {
        return frageAntwortA;
    }

    public void setFrageAntwortA(String frageAntwortA) {
        this.frageAntwortA = frageAntwortA;
    }

    public String getFrageAntwortB() {
        return frageAntwortB;
    }

    public void setFrageAntwortB(String frageAntwortB) {
        this.frageAntwortB = frageAntwortB;
    }

    public String getFrageAntwortC() {
        return frageAntwortC;
    }

    public void setFrageAntwortC(String frageAntwortC) {
        this.frageAntwortC = frageAntwortC;
    }

    public String getFrageAntwortD() {
        return frageAntwortD;
    }

    public void setFrageAntwortD(String frageAntwortD) {
        this.frageAntwortD = frageAntwortD;
    }

    public Fragen getCurrent() {
        return current;
    }

    public void setCurrent(Fragen current) {
        this.current = current;
    }

}
