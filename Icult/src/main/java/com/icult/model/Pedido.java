/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icult.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.Valid;

/**
 *
 * @author kalango
 */
@Entity
@Table(name="PEDIDO_TABLE")
public class Pedido implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="INT_ID")
    private Long idCLiente;
    @Column(name="TXT_VALORTOTAL")
    private String valor_total;
    @Column(name="TXT_DESCONTO")
    private String desconto;
    @Column(name="TXT_FRETE")
    private String valor_frete;
    @Column(name="TXT_QUANTIDADE")
    private String quantidade;
    
    @Embedded
    private Endereco endereco;
    
    @Valid
    @ManyToMany(mappedBy="pedidos")
    private List<Usuario> usuarios;
    
    public Long getIdCLiente() {
        return idCLiente;
    }

    public void setIdCLiente(Long idCLiente) {
        this.idCLiente = idCLiente;
    }

    public String getValor_total() {
        return valor_total;
    }

    public void setValor_total(String valor_total) {
        this.valor_total = valor_total;
    }

    public String getDesconto() {
        return desconto;
    }

    public void setDesconto(String desconto) {
        this.desconto = desconto;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getValor_frete() {
        return valor_frete;
    }

    public void setValor_frete(String valor_frete) {
        this.valor_frete = valor_frete;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    
    
            
}
