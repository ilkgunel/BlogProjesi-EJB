/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ilkgunel.ejb;

import com.ilkgunel.entities.Yazilar;
import com.ilkgunel.facade.IcerigiKaydetFacade;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ilkaygunel
 */
@Stateful
public class IcerigiKaydetEJB implements IcerigiKaydetFacade{
    @Override
    public String icerigiVeritabaninaKaydet(Yazilar gelenIcerik)
    {
        String kaydetmeIslemSonucu="";
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("BlogProjesi");
        EntityManager em=emf.createEntityManager();
        try {
                em.getTransaction().begin();
                em.persist(gelenIcerik);
                em.getTransaction().commit();
                kaydetmeIslemSonucu="İçerik Başarı İle Veritabanına Kaydedildi!";
                em.close();
                emf.close();
        } 

        catch (Exception e) 
        {
                System.out.println("Bir Hata Meydana Geldi!");
                kaydetmeIslemSonucu="İçerik Kaydı Sırasında Bir Hata Meydana Geldi:"+e;
                System.out.println("Hata:"+e);
        }
        return kaydetmeIslemSonucu;
    }
}
