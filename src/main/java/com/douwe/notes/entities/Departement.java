package com.douwe.notes.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Vincent Douwe <douwevincent@yahoo.fr>
 */
@Entity
@XmlRootElement(name="departement")
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQueries(
        @NamedQuery(name = "Departement.getAllOptions", query = "select o from options o where o.departement.id = :idParam")

)
public class Departement implements Serializable {
    
    @XmlAttribute
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Version
    private int version;
    
    @XmlElement
    @Column
    private String code;
    
    @XmlElement
    @Column
    private String description;
    
    public Departement(){
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
