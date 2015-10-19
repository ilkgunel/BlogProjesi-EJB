package com.ilkgunel.controller;

import java.util.List;

import com.ilkgunel.entities.Yazilar;
import com.ilkgunel.facade.YazilariGetirFacade;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class YazilariGetir implements Serializable{
	List<Yazilar> veritabanindakiYazilar;
	@EJB
        private YazilariGetirFacade yazilariGetirFacadeObjesi;
        
	@PostConstruct
	public void yazilariGetir()
	{
            veritabanindakiYazilar=yazilariGetirFacadeObjesi.yazilariGetir();
	}
	
	public List<Yazilar> getVeritabanindakiYazilar() {
		return veritabanindakiYazilar;
	}
	
	public void setVeritabanindakiYazilar(List<Yazilar> veritabanindakiYazilar) {
		this.veritabanindakiYazilar = veritabanindakiYazilar;
	}
}
