package com.ilkgunel.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.ilkgunel.entities.Yazilar;
import com.ilkgunel.facade.OnizlemeFacade;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedProperty;

@ManagedBean
@SessionScoped
@Stateless
public class Onizleme implements Serializable{
	@ManagedProperty(value = "#{icerigiKaydet}")
	private IcerigiKaydet icerigiKaydetObjesi;
        
        @EJB
        private OnizlemeFacade onizlemeFacadeObjesi;
        
        Yazilar yazilarObjesi=new Yazilar();
	
	public Yazilar getYazilarObjesi() {
		return yazilarObjesi;
	}
	
	public void setYazilarObjesi(Yazilar yazilarObjesi) {
		this.yazilarObjesi = yazilarObjesi;
	}
	
	public IcerigiKaydet getIcerigiKaydetObjesi() {
		return icerigiKaydetObjesi;
	}
	
	public void setIcerigiKaydetObjesi(IcerigiKaydet icerigiKaydetObjesi) {
		this.icerigiKaydetObjesi = icerigiKaydetObjesi;
	}
	
	public String onizlemeIsleminiYap()
	{
            yazilarObjesi = onizlemeFacadeObjesi.onizlemeIsleminiYap(yazilarObjesi, icerigiKaydetObjesi);
            return "onizleme.xhtml?faces-redirect=true";
	}	
}
