/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ilkgunel.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ilkaygunel
 */
@Entity
@Table(name = "yazilar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Yazilar.findAll", query = "SELECT y FROM Yazilar y"),
    @NamedQuery(name = "Yazilar.findByYaziId", query = "SELECT y FROM Yazilar y WHERE y.yaziId = :yaziId"),
    @NamedQuery(name = "Yazilar.findByYaziBaslik", query = "SELECT y FROM Yazilar y WHERE y.yaziBaslik = :yaziBaslik"),
    @NamedQuery(name = "Yazilar.findByYazarAdi", query = "SELECT y FROM Yazilar y WHERE y.yazarAdi = :yazarAdi")})
public class Yazilar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "yaziId")
    private Integer yaziId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "yaziBaslik")
    private String yaziBaslik;
    @Lob
    @Size(max = 16777215)
    @Column(name = "yaziIcerik")
    private String yaziIcerik;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "yazarAdi")
    private String yazarAdi;

    public Yazilar() {
    }

    public Yazilar(Integer yaziId) {
        this.yaziId = yaziId;
    }

    public Yazilar(Integer yaziId, String yaziBaslik, String yazarAdi) {
        this.yaziId = yaziId;
        this.yaziBaslik = yaziBaslik;
        this.yazarAdi = yazarAdi;
    }

    public Integer getYaziId() {
        return yaziId;
    }

    public void setYaziId(Integer yaziId) {
        this.yaziId = yaziId;
    }

    public String getYaziBaslik() {
        return yaziBaslik;
    }

    public void setYaziBaslik(String yaziBaslik) {
        this.yaziBaslik = yaziBaslik;
    }

    public String getYaziIcerik() {
        return yaziIcerik;
    }

    public void setYaziIcerik(String yaziIcerik) {
        this.yaziIcerik = yaziIcerik;
    }

    public String getYazarAdi() {
        return yazarAdi;
    }

    public void setYazarAdi(String yazarAdi) {
        this.yazarAdi = yazarAdi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (yaziId != null ? yaziId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Yazilar)) {
            return false;
        }
        Yazilar other = (Yazilar) object;
        if ((this.yaziId == null && other.yaziId != null) || (this.yaziId != null && !this.yaziId.equals(other.yaziId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ilkgunel.entities.Yazilar[ yaziId=" + yaziId + " ]";
    }
    
}
