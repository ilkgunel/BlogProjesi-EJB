/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ilkgunel.ejb;

import com.ilkgunel.controller.IcerigiKaydet;
import com.ilkgunel.entities.Yazilar;
import com.ilkgunel.facade.OnizlemeFacade;
import javax.ejb.Stateful;

/**
 *
 * @author ilkaygunel
 */
@Stateful
public class OnizlemeEJB implements OnizlemeFacade{
    @Override
    public Yazilar onizlemeIsleminiYap(Yazilar yazilarObjesi,IcerigiKaydet icerigiKaydetObjesi)
    {
        yazilarObjesi.setYaziBaslik(icerigiKaydetObjesi.getGelenIcerik().getYaziBaslik());
        yazilarObjesi.setYaziIcerik(icerigiKaydetObjesi.getGelenIcerik().getYaziIcerik());

        System.out.println(yazilarObjesi.getYaziBaslik());
        System.out.println(yazilarObjesi.getYaziIcerik());
        return yazilarObjesi;
    }
}
