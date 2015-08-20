package com.ilkgunel.controller;

import com.ilkgunel.entities.Uyeler;
import com.ilkgunel.facade.UyeBilgileriFacade;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import java.io.Serializable;
import javax.ejb.EJB;

@ManagedBean
@SessionScoped
public class UyeBilgileri implements Serializable{

    @EJB
    private UyeBilgileriFacade uyeBilgileriFacadeObjesi; 

    private String girilenKullaniciAdi;
    Uyeler uyeBilgileriObjesi;

    public String getGirilenKullaniciAdi() {
            return girilenKullaniciAdi;
    }

    public void setGirilenKullaniciAdi(String girilenKullaniciAdi) {
            this.girilenKullaniciAdi = girilenKullaniciAdi;
    }

    public Uyeler getUyeBilgileriObjesi() {
        return uyeBilgileriObjesi;
    }

    public void setUyeBilgileriObjesi(Uyeler uyeBilgileriObjesi) {
        this.uyeBilgileriObjesi = uyeBilgileriObjesi;
    }
    
    public void bilgileriGetir()
    {
        uyeBilgileriObjesi = uyeBilgileriFacadeObjesi.bilgileriGetir(girilenKullaniciAdi);
    }
}