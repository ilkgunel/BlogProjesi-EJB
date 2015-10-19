/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ilkgunel.facade;
import com.ilkgunel.controller.IcerigiKaydet;
import com.ilkgunel.entities.Yazilar;
import javax.ejb.Local;
/**
 *
 * @author ilkaygunel
 */
@Local
public interface OnizlemeFacade {
    public Yazilar onizlemeIsleminiYap(Yazilar yazilarObjesi);
}
