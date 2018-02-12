/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Noah
 */
@ToString
@Entity
@Table(name = "admin")
@EqualsAndHashCode(of = "id")
public class Fragen implements Serializable {

    @SuppressWarnings("empty-statement")
    public Fragen(int fragenId, String fragenBody, String fragenAntwortA, String fragenAntwortB, String fragenAntwortC, String fragenAntwortD,  int fragenRichtigeAntwort, int fragenLevel) {
        this.fragenId = fragenId;
        this.fragenBody = fragenBody;
       // this.fragenAntwortA = fragenAntwortA;
       // this.fragenAntwortB = fragenAntwortB;
       // this.fragenAntwortC = fragenAntwortC;
        //this.fragenAntwortD = fragenAntwortD;
        List<String> antworten=  new ArrayList<>();
        antworten.add(fragenAntwortA);
        antworten.add(fragenAntwortB);
        antworten.add(fragenAntwortC);
        antworten.add(fragenAntwortD);
        this.fragenAntworten = antworten;
        this.fragenRichtigeAntwort = fragenRichtigeAntwort;
        this.fragenLevel = fragenLevel;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private int fragenId;

    @NonNull
    @Column(name = "body")
    @Getter
    @Setter
    private String fragenBody;

    @NonNull
    @Column(name = "a")
    @Getter
    @Setter
    private String fragenAntwortA;

    @NonNull
    @Column(name = "b")
    @Getter
    @Setter
    private String fragenAntwortB;

    @NonNull
    @Column(name = "c")
    @Getter
    @Setter
    private String fragenAntwortC;

    @NonNull
    @Column(name = "d")
    @Getter
    @Setter
    private String fragenAntwortD;

    private List<String> fragenAntworten;

    @NonNull
    @Column(name = "correct")
    @Getter
    @Setter
    private int fragenRichtigeAntwort;
   
    @NonNull
    @Column(name = "level")
    @Getter
    @Setter
    private int fragenLevel;

    public int getFragenId() {
        return fragenId;
    }

    public void setFragenId(int fragenId) {
        this.fragenId = fragenId;
    }

    public String getFragenBody() {
        return fragenBody;
    }

    public void setFragenBody(String fragenBody) {
        this.fragenBody = fragenBody;
    }

    public String getFragenAntwortA() {
        return fragenAntwortA;
    }

    public void setFragenAntwortA(String fragenAntwortA) {
        this.fragenAntwortA = fragenAntwortA;
    }

    public String getFragenAntwortB() {
        return fragenAntwortB;
    }

    public void setFragenAntwortB(String fragenAntwortB) {
        this.fragenAntwortB = fragenAntwortB;
    }

    public String getFragenAntwortC() {
        return fragenAntwortC;
    }

    public void setFragenAntwortC(String fragenAntwortC) {
        this.fragenAntwortC = fragenAntwortC;
    }

    public String getFragenAntwortD() {
        return fragenAntwortD;
    }

    public void setFragenAntwortD(String fragenAntwortD) {
        this.fragenAntwortD = fragenAntwortD;
    }

    public List<String> getFragenAntworten() {
        return fragenAntworten;
    }

    public void setFragenAntworten(List<String> fragenAntworten) {
        this.fragenAntworten = fragenAntworten;
    }

    public int getFragenRichtigeAntwort() {
        return fragenRichtigeAntwort;
    }

    public void setFragenRichtigeAntwort(int fragenRichtigeAntwort) {
        this.fragenRichtigeAntwort = fragenRichtigeAntwort;
    }

    public int getFragenLevel() {
        return fragenLevel;
    }

    public void setFragenLevel(int fragenLevel) {
        this.fragenLevel = fragenLevel;
    }
    
    
    
}
