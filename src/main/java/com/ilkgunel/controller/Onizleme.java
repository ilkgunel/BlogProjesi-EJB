package com.ilkgunel.controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

import com.ilkgunel.entities.Yazilar;
import com.ilkgunel.facade.OnizlemeFacade;
import java.io.Serializable;
import javax.ejb.EJB;

@Named(value = "onizleme")
@SessionScoped
public class Onizleme implements Serializable{
    Yazilar yazilarObjesi;
    
    public Onizleme()
    {
        yazilarObjesi=new Yazilar();
    }
    
    @EJB
    private OnizlemeFacade onizlemeFacadeObjesi;

    public Yazilar getYazilarObjesi() {
            return yazilarObjesi;
    }

    public void setYazilarObjesi(Yazilar yazilarObjesi) {
            this.yazilarObjesi = yazilarObjesi;
    }


    public String onizlemeIsleminiYap()
    {
        yazilarObjesi = onizlemeFacadeObjesi.onizlemeIsleminiYap(yazilarObjesi);
        return "onizleme.xhtml?faces-redirect=true";
    }	
}
