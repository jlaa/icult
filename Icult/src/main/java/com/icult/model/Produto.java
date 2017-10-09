/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icult.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

/**
 *
 * @author LucasPC
 */
@Entity
@Table(name="PRODUTO_TABLE")
@Access(AccessType.FIELD)
@NamedQuery(name = "Produto.listarTodos",
                  query= "SELECT e FROM Produto e")
public class Produto implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PRODUTO")
    private Long id;
    
    @Size(max=45)
    @Column(name="TXT_NOME_PRODUTO",nullable = false)
    private String nome_produto;
    
    @Temporal(TemporalType.DATE)
    @Past
    @Column(name="DT_DE_CADASTRO",nullable=false)
    private Calendar data_de_cadastro;
    
    @Size(max=45)
    @Column(name="TXT_CARACTERISTICAS",nullable=false)
    private String caracteristicas;
    
    @Column(name="DOUBLE_PRECO",nullable=false)
    private double preco;
    
    @Column(name="INT_QUANTIDADE",nullable=false)
    private int quantidade;
   
    @Valid
    @ManyToMany(mappedBy="produtos")
    private List<Usuario> usuarios;

    public Produto(String nome_produto, Calendar data_de_cadastro, String caracteristicas, double preco, int quantidade) {
        this.nome_produto = nome_produto;
        this.data_de_cadastro = data_de_cadastro;
        this.caracteristicas = caracteristicas;
        this.preco = preco;
        this.quantidade = quantidade;
    }
    
    public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public Calendar getData_de_cadastro() {
        return data_de_cadastro;
    }

    public void setData_de_cadastro(Calendar data_de_cadastro) {
        this.data_de_cadastro = data_de_cadastro;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    
    
    
    
}
