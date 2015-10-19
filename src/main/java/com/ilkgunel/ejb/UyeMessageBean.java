/*Bu sınıf Message Driver Bean'i örneklemek amacı ile vardır. Proje içinde herhangi rol üstlenmemektedir*/

package com.ilkgunel.ejb;

import com.ilkgunel.entities.Uyeler;
import com.ilkgunel.facade.UyeKaydiFacade;
import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

/**
 *
 * @author ilkaygunel
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/BlogProjesi"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
    })
public class UyeMessageBean implements MessageListener{
    public String kayitIslemSonucu;
    @Resource
    private MessageDrivenContext mdctx;  
    
    @Inject
    UyeKaydiFacade uyeKaydiFacadeObjesi;
    
    @Override
    public void onMessage(Message message) {
      ObjectMessage objectMessage = null;
      try {
         objectMessage = (ObjectMessage) message;
          Uyeler uyelerObjesi = (Uyeler) objectMessage.getObject(); 
         kayitIslemSonucu=uyeKaydiFacadeObjesi.uyeKaydiniYap(uyelerObjesi);
 
      } catch (JMSException ex) {
         mdctx.setRollbackOnly();
      }       
   } 
}
