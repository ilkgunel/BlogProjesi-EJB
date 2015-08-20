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
import javax.persistence.Id;
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
@Table(name = "uyeler")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Uyeler.findAll", query = "SELECT u FROM Uyeler u"),
    @NamedQuery(name = "Uyeler.findByUyeId", query = "SELECT u FROM Uyeler u WHERE u.uyeId = :uyeId"),
    @NamedQuery(name = "Uyeler.findByKullaniciAdi", query = "SELECT u FROM Uyeler u WHERE u.kullaniciAdi = :kullaniciAdi"),
    @NamedQuery(name = "Uyeler.findByPassword", query = "SELECT u FROM Uyeler u WHERE u.password = :password"),
    @NamedQuery(name = "Uyeler.findByEnabled", query = "SELECT u FROM Uyeler u WHERE u.enabled = :enabled"),
    @NamedQuery(name = "Uyeler.findByRole", query = "SELECT u FROM Uyeler u WHERE u.role = :role"),
    @NamedQuery(name = "Uyeler.findByYazarAdi", query = "SELECT u FROM Uyeler u WHERE u.yazarAdi = :yazarAdi")})
public class Uyeler implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "uyeId")
    private int uyeId;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "kullaniciAdi")
    private String kullaniciAdi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "enabled")
    private String enabled;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "role")
    private String role;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "yazarAdi")
    private String yazarAdi;

    public Uyeler() {
    }

    public Uyeler(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public Uyeler(String kullaniciAdi, int uyeId, String password, String enabled, String role, String yazarAdi) {
        this.kullaniciAdi = kullaniciAdi;
        this.uyeId = uyeId;
        this.password = password;
        this.enabled = enabled;
        this.role = role;
        this.yazarAdi = yazarAdi;
    }

    public int getUyeId() {
        return uyeId;
    }

    public void setUyeId(int uyeId) {
        this.uyeId = uyeId;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
        hash += (kullaniciAdi != null ? kullaniciAdi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Uyeler)) {
            return false;
        }
        Uyeler other = (Uyeler) object;
        if ((this.kullaniciAdi == null && other.kullaniciAdi != null) || (this.kullaniciAdi != null && !this.kullaniciAdi.equals(other.kullaniciAdi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ilkgunel.entities.Uyeler[ kullaniciAdi=" + kullaniciAdi + " ]";
    }
    
}
