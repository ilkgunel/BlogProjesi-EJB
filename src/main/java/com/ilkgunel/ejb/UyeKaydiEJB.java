/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ilkgunel.ejb;

import com.ilkgunel.entities.Uyeler;
import com.ilkgunel.facade.UyeKaydiFacade;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ilkaygunel
 */
@Stateful
public class UyeKaydiEJB implements UyeKaydiFacade{
     static int sonUyeKayitIdNo=10;
     String kayitSonucMesaji="";
    @Override
    public String uyeKaydiniYap(Uyeler uyelerObjesi)
    {
       
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("BlogProjesi");
        EntityManager em=emf.createEntityManager();

        //Şifreyi MD5 ile şifreleyip veritabanına kaydediyoruz.
        try
        {
            MessageDigest messageDigestNesnesi = MessageDigest.getInstance("MD5");
            messageDigestNesnesi.update(uyelerObjesi.getPassword().getBytes());
            byte messageDigestDizisi[] = messageDigestNesnesi.digest();
            StringBuffer sb16 = new StringBuffer();
            for (int i = 0; i < messageDigestDizisi.length; i++) 
            {
                    sb16.append(Integer.toString((messageDigestDizisi[i] & 0xff) + 0x100, 16).substring(1));
            }
            System.out.println("Parolanın Şifrelenmiş Hali:" + sb16.toString());
            uyelerObjesi.setPassword(sb16.toString());
        }
        catch(NoSuchAlgorithmException ex){
            System.err.println(ex);
        }

        //Veritabanına kayıt olurken bazı özellikleri kendimiz atıyoruz. İlerki zamanda bu durum değişebilir. 
        uyelerObjesi.setEnabled("1");
        uyelerObjesi.setRole("ROLE_GUEST");
        uyelerObjesi.setUyeId(sonUyeKayitIdNo);

        try {
                em.getTransaction().begin();
                em.persist(uyelerObjesi);
                em.getTransaction().commit();
                sonUyeKayitIdNo++;
                em.close();
                emf.close();
                kayitSonucMesaji="Kaydınız Başarı İle Tamamlandı";
        } 
        
        catch (Exception e) 
        {
                System.out.println("Bir Hata Meydana Geldi!");
                System.out.println("Hata"+e);
                kayitSonucMesaji="Kayıt Sırasında Bir Hata Meydana Geldi"+e;
        }
        return kayitSonucMesaji;
    }
}
