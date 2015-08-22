package com.ilkgunel.controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

import com.ilkgunel.entities.Yazilar;
import com.ilkgunel.facade.IcerigiKaydetFacade;
import java.io.Serializable;
import javax.ejb.EJB;

@Named(value = "icerigiKaydet")
@SessionScoped
public class IcerigiKaydet implements Serializable{

    @EJB
    private IcerigiKaydetFacade icerigiKaydetFacadeObjesi;

    Yazilar gelenIcerik=new Yazilar();
    String kaydetmeIslemSonucu;

    public void icerigiVeritabaninaKaydet()
    {

        kaydetmeIslemSonucu=icerigiKaydetFacadeObjesi.icerigiVeritabaninaKaydet();
    }

    public Yazilar getGelenIcerik() {
        return icerigiKaydetFacadeObjesi.getGelenIcerik();
    }

    public void setGelenIcerik(Yazilar gelenIcerik) {
        icerigiKaydetFacadeObjesi.setGelenIcerik(gelenIcerik);
    }

    public String getKaydetmeIslemSonucu() {
            return kaydetmeIslemSonucu;
    }

    public void setKaydetmeIslemSonucu(String kaydetmeIslemSonucu) {
            this.kaydetmeIslemSonucu = kaydetmeIslemSonucu;
    }
}
