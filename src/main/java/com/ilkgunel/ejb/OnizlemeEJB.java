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
import javax.inject.Inject;

/**
 *
 * @author ilkaygunel
 */
@Stateful
public class OnizlemeEJB implements OnizlemeFacade{
    
    @Inject
    private IcerigiKaydet icerigiKaydetObjesi;

    @Override
    public Yazilar onizlemeIsleminiYap(Yazilar yazilarObjesi)
    {
        yazilarObjesi.setYaziBaslik(icerigiKaydetObjesi.getGelenIcerik().getYaziBaslik());
        yazilarObjesi.setYaziIcerik(icerigiKaydetObjesi.getGelenIcerik().getYaziIcerik());

        System.out.println(yazilarObjesi.getYaziBaslik());
        System.out.println(yazilarObjesi.getYaziIcerik());
        return yazilarObjesi;
    }
}
