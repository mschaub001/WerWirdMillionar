/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

/**
 *
 * @author Noah
 */
@ToString
@Entity
@Table(name = "user")
@EqualsAndHashCode(of = "id")
public class Admin implements Serializable {

    public Admin(long id,String adminName, String adminPassword){
        this.id=id;
        this.adminName=adminName;
        this.adminPassword=adminPassword;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private long id;

    @NonNull
    @Column(name = "adminName")
    @Getter
    @Setter
    private String adminName;
    
    @NonNull
    @Column(name = "adminPassword")
    @Getter
    @Setter
    private String adminPassword;

    public String getAdminName(){
        return adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }
}
