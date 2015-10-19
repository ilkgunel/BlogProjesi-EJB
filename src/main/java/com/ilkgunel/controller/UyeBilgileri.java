package com.ilkgunel.controller;

import com.ilkgunel.entities.Uyeler;
import com.ilkgunel.facade.UyeBilgileriFacade;
import javax.enterprise.context.SessionScoped;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Named
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
    
    public void bilgileriGetir()
    {
        uyeBilgileriObjesi=new Uyeler();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.err.println("Giriş Yapan Kullanıcı:"+auth.getName());
        System.err.println("Kullanıcı Adı Detayları"+auth.getDetails());
        System.err.println("GetCredentials"+auth.getCredentials());
        uyeBilgileriObjesi.setKullaniciAdi(auth.getName());
    }
}