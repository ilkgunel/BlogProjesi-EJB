package com.ilkgunel.controller;

import com.ilkgunel.ejb.UyeMessageBean;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.ilkgunel.entities.Uyeler;
import com.ilkgunel.facade.UyeKaydiFacade;
import java.io.Serializable;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;

@ManagedBean
@RequestScoped
public class UyeKaydi implements Serializable{
    Uyeler uyelerObjesi=new Uyeler();
    String kayitSonucMesaji="";//NullPointerException İle Karşılaşmamak İçin "" Ataması Yapıyoruz

    @EJB
    private UyeKaydiFacade uyeKaydiFacadeObjesi;

    @Resource(mappedName="jms/BlogProjesi")
    private Queue queue;

    @Resource(mappedName="jms/BlogProjesiFactory")
    private QueueConnectionFactory factory;

    
    
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
