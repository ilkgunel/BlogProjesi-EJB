package com.ilkgunel.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.ilkgunel.entities.Uyeler;
import com.ilkgunel.facade.UyeKaydiFacade;
import java.io.Serializable;
import javax.ejb.EJB;

@ManagedBean
@RequestScoped
public class UyeKaydi implements Serializable{
	Uyeler uyelerObjesi=new Uyeler();
	String kayitSonucMesaji="";//NullPointerException İle Karşılaşmamak İçin "" Ataması Yapıyoruz
	
        @EJB
        private UyeKaydiFacade uyeKaydiFacadeObjesi;
	
	public Uyeler getUyelerObjesi() {
		return uyelerObjesi;
	}
	
	public void setUyelerObjesi(Uyeler uyelerObjesi) {
		this.uyelerObjesi = uyelerObjesi;
	}
	
	public String getKayitSonucMesaji() {
		return kayitSonucMesaji;
	}
	
	public void setKayitSonucMesaji(String kayitSonucMesaji) {
		this.kayitSonucMesaji = kayitSonucMesaji;
	}
	
	public void uyeKaydiniYap() 
        {
            kayitSonucMesaji=uyeKaydiFacadeObjesi.uyeKaydiniYap(uyelerObjesi);
	}
}
