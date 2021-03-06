/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ilkgunel.ejb;

import com.ilkgunel.entities.Yazilar;
import com.ilkgunel.facade.YazilariGetirFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author ilkaygunel
 */
@Stateless
public class YazilariGetirEJB implements YazilariGetirFacade{
    @PersistenceContext(unitName = "BlogProjesi")
    private EntityManager em; 
    
    List<Yazilar> veritabanindakiYazilar;
	
	//EntityManagerFactory emf=Persistence.createEntityManagerFactory("BlogProjesi");
	//EntityManager em=emf.createEntityManager();
    
        @Override
        public List<Yazilar> yazilariGetir()
        {
            veritabanindakiYazilar=new ArrayList<>();
            TypedQuery<Yazilar> yazilarQuery=em.createQuery("SELECT y FROM Yazilar y order by y.yaziId desc",Yazilar.class);
            veritabanindakiYazilar=yazilarQuery.getResultList();
            return veritabanindakiYazilar;
        }
}
