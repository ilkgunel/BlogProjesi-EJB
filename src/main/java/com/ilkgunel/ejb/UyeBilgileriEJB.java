/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ilkgunel.ejb;

import com.ilkgunel.controller.IcerigiKaydet;
import com.ilkgunel.entities.Uyeler;
import javax.annotation.Resource;
import javax.ejb.Stateful;
import com.ilkgunel.facade.UyeBilgileriFacade;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 *
 * @author ilkaygunel
 */
@Stateful
public class UyeBilgileriEJB implements UyeBilgileriFacade{
   
    @Inject
    private IcerigiKaydet icerigiKaydetObjesi;
        
    Uyeler uyeBilgileriObjesi;

    public Uyeler getUyeBilgileriObjesi() {
            return uyeBilgileriObjesi;
    }

    public void setUyeBilgileriObjesi(Uyeler uyeBilgileriObjesi) {
            this.uyeBilgileriObjesi = uyeBilgileriObjesi;
    }

    public IcerigiKaydet getIcerigiKaydetObjesi() {
        return icerigiKaydetObjesi;
    }

    public void setIcerigiKaydetObjesi(IcerigiKaydet icerigiKaydetObjesi) {
        this.icerigiKaydetObjesi = icerigiKaydetObjesi;
    }

    @Override
    public Uyeler bilgileriGetir(String girilenKullaniciAdi)
    {
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("BlogProjesi");
        EntityManager em=emf.createEntityManager();

        em.getTransaction().begin();
        uyeBilgileriObjesi=em.find(Uyeler.class, girilenKullaniciAdi);
        System.out.println("Yazar Adı:UyeBilgileriEJB:"+uyeBilgileriObjesi.getYazarAdi());
        icerigiKaydetObjesi.getGelenIcerik().setYazarAdi(uyeBilgileriObjesi.getYazarAdi());
        return uyeBilgileriObjesi;
    }
}
