/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icult.model;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author LucasPC
 */
@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
public class Aplicacao {

    @PersistenceContext(name = "Icult")
    private EntityManager em;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean CadastrarUsuario(Usuario usuario) {
        try {
            em.persist(usuario);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public Usuario LoginUuario(String email,String senha) {
        Usuario usuario;
        try {
            TypedQuery<Usuario> query = em.createQuery("SELECT u from Usuario u where u.email like ?1 and u.senha like ?2", Usuario.class);
            query.setParameter(1, email);
            query.setParameter(2,senha);
            usuario = query.getSingleResult();
            if (usuario != null) {
                return usuario;
            }
        } catch (Exception ex) {
            return null;
        }
        return null;
    }
     @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void AlterarUsuario(Usuario usuario) {  
         try {
            em.merge(usuario);
         }catch(Exception ex)
         {
             
         }
         
    }

}
