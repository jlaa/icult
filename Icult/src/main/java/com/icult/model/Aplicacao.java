
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
    public Usuario LoginUuario(String email, String senha) {
        Usuario usuario;
        try {
            TypedQuery<Usuario> query = em.createQuery("SELECT u from Usuario u where u.email like ?1 and u.senha like ?2", Usuario.class);
            query.setParameter(1, email);
            query.setParameter(2, senha);
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
        } catch (Exception ex) {

        }

    }

    public boolean cadastrarProduto(Produto produto) {
        try {
            em.persist(produto);
        } catch (Exception ex) {
            return false;
        }
        return true;

    }

    public boolean atualizarProduto(Produto produto) {

        try {

            em.merge(produto);

        } catch (Exception ex) {

            return false;
        }

        return true;
    }

    public boolean removerProduto(Produto produto) {

        try {

            em.remove(em.merge(produto));

        } catch (Exception ex) {

            return false;
        }

        return true;
    }

    public Produto consultarProdutoPorId(Long id) {

        Produto produto = null;

        try {

            produto = em.find(Produto.class, id);

        } catch (Exception ex) {
        }

        return produto;
    }

    public List<Usuario> listarProdutos() {

        Query query = em.createNamedQuery("Usuario.listarProdutos");
        return query.getResultList();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean CadastrarCartao(CartaoDeCredito cartao) {
        try {
            em.persist(cartao);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean AlterarCartao(CartaoDeCredito cartao) {
        try {
            em.merge(cartao);
        } catch (Exception ex) {
            System.out.println("pqp");
            return false;
        }
        return true;
    }

    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<CartaoDeCredito> ListaCartao() {
        List<CartaoDeCredito> cartoes;
        try {
            TypedQuery<CartaoDeCredito> query = em.createQuery("SELECT ca from CartaoDeCredito ca ", CartaoDeCredito.class);
            cartoes = query.getResultList();
            if (cartoes != null) {
                return cartoes;
            }

        } catch (Exception ex) {
            return null;
        }
        return null;
    }

    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public CartaoDeCredito PesquisaCartao(String numero_cartao) {
        CartaoDeCredito cartao;
        try {
            TypedQuery<CartaoDeCredito> query = em.createQuery("SELECT ca from CartaoDeCredito ca where ca.numero_cartao = ?1", CartaoDeCredito.class);
            query.setParameter(1, numero_cartao);
            cartao = query.getSingleResult();
            if (cartao != null) {
                return cartao;
            }
        } catch (Exception ex) {
            return null;
        }
        return null;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean ExcluirCartao(String numero_cartao) {
        CartaoDeCredito cartao;
        try {
            TypedQuery<CartaoDeCredito> query = em.createQuery("SELECT ca from CartaoDeCredito ca where ca.numero_cartao = ?1", CartaoDeCredito.class);
            query.setParameter(1, numero_cartao);
            cartao = query.getSingleResult();
            em.remove(em.merge(cartao));
            if (cartao != null) {
                return true;
            }
        } catch (Exception ex) {
            return false;
        }
        return false;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void ExcluirCartao(CartaoDeCredito cartao) {
        try {
            em.remove(em.merge(cartao));
        } catch (Exception ex) {

        }

    }

}

