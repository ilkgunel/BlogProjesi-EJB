package com.ilkgunel.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.NavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@ManagedBean
@SessionScoped
public class GirisDenetlemeSinifi implements Serializable{
	
    public void login()  
    {
        try {

            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            RequestDispatcher dispatcher = ((ServletRequest)context.getRequest()).getRequestDispatcher("/j_spring_security_check");

            dispatcher.forward((ServletRequest)context.getRequest(), (ServletResponse)context.getResponse());
            FacesContext.getCurrentInstance().responseComplete();
           
        } catch (ServletException | IOException ex) {
            Logger.getLogger(GirisDenetlemeSinifi.class.getName()).log(Level.SEVERE, null, ex);

        } 
    }
	
    public void authorizedUserControl()
    {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
        //Oturum Açılmamış İse Spring Security AnonymousUser Olarak Görür.
        //Oturum Açılmış İse Oturum Açan Kişinin Kullanıcı Adını Devreye Alır.
        
        if(!authentication.getPrincipal().toString().equals("anonymousUser")){

            NavigationHandler nh =  FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
            nh.handleNavigation(FacesContext.getCurrentInstance(), null, "/index.xhtml?faces-redirect=true");

        }
    }
}
