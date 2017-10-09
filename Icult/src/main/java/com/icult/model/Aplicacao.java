/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icult.model;


import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
    
    
    public boolean cadastrarProduto(Produto produto) {
        try {
            em.persist(produto);
        } catch (Exception ex) {
            return false;
        }
        return true;

    }
    
    public boolean atualizarProduto(Produto produto){
        
        try{
            
            em.merge(produto);
            
        } catch(Exception ex){
            
            return false;
        }
        
        return true;
    }
    
    public boolean removerProduto(Produto produto){
        
        try{
            
            em.remove(produto);
            
        } catch(Exception ex){
            
            return false;
        }
        
        return true;
    }
    
    public Produto consultarProdutoPorId(Long id){
        
        Produto produto = null;
        
        try{
            
            produto = em.find(Produto.class, id);
            
        } catch(Exception ex){
        }
        
        return produto;
    }
    
    public List<Usuario> listarProdutos() {

        Query query = em.createNamedQuery("Usuario.listarProdutos");
        return query.getResultList();
    }
    
}
