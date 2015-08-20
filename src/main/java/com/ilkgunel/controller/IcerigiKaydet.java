package com.ilkgunel.controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

import com.ilkgunel.entities.Yazilar;
import com.ilkgunel.facade.IcerigiKaydetFacade;
import java.io.Serializable;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.inject.Inject;

@Named(value = "icerigiKaydet")
@SessionScoped
public class IcerigiKaydet implements Serializable{
       
        @EJB
        private IcerigiKaydetFacade icerigiKaydetFacadeObjesi;
        
	Yazilar gelenIcerik=new Yazilar();
	String kaydetmeIslemSonucu;
                
	public void icerigiVeritabaninaKaydet()
	{
            kaydetmeIslemSonucu=icerigiKaydetFacadeObjesi.icerigiVeritabaninaKaydet(gelenIcerik);
	}
	
	public Yazilar getGelenIcerik() {
		return gelenIcerik;
	}
	
	public void setGelenIcerik(Yazilar gelenIcerik) {
		this.gelenIcerik = gelenIcerik;
	}
	
	public String getKaydetmeIslemSonucu() {
		return kaydetmeIslemSonucu;
	}
	
	public void setKaydetmeIslemSonucu(String kaydetmeIslemSonucu) {
		this.kaydetmeIslemSonucu = kaydetmeIslemSonucu;
	}
}
