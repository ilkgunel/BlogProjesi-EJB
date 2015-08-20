package com.ilkgunel.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.ilkgunel.entities.Yazilar;
import java.io.Serializable;

@ManagedBean
@ViewScoped
public class YaziyiGoruntule implements Serializable{
	boolean gorunurluk;
	Yazilar yazilarObjesi;
	
	public void yaziyiDetaylandir(javax.faces.event.ActionEvent e)
	{
		gorunurluk=true;	
	}
	
	public void yaziyiKapat(javax.faces.event.ActionEvent e)
	{
		gorunurluk=false;
	}
	
	public Yazilar getYazilarObjesi() {
		return yazilarObjesi;
	}
	
	public void setYazilarObjesi(Yazilar yazilarObjesi) {
		this.yazilarObjesi = yazilarObjesi;
	}
	
	public boolean isGorunurluk() {
		return gorunurluk;
	}
	
	public void setGorunurluk(boolean gorunurluk) {
		this.gorunurluk = gorunurluk;
	}
}
