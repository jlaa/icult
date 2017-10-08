/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icult.model;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.Size;

/**
 *
 * @author LucasPC
 */
@Entity
@Table(name = "CARTAO_TABLE")
@Access(AccessType.FIELD)
public class CartaoDeCredito implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CARTAO")
    private Long id;

    @Size(max = 45)
    @Column(name = "TXT_NOME_DO_DONO", nullable = false)
    private String nome_do_dono;

    @Size(max = 3)
    @Column(name = "INT_CODIGO_DE_SEGURANCA", nullable = false)
    private int codigo_de_seguranca;

    @Temporal(TemporalType.DATE)
    @Future
    @Column(name = "DT_DE_VALIDADE", nullable = false)
    private Calendar data_de_validade;

    @Size(max = 25)
    @Column(name = "TXT_BANDEIRA", nullable = false)
    private String bandeira;

    @Size(max = 16)
    @Column(name = "TXT_NUMERO_CARTAO", nullable = false)
    private String numero_cartao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CARTAO_USUARIO", referencedColumnName = "ID_USUARIO")
    private Usuario usuario;

    public String getNome_do_dono() {
        return nome_do_dono;
    }

    public void setNome_do_dono(String nome_do_dono) {
        this.nome_do_dono = nome_do_dono;
    }

    public int getCodigo_de_seguranca() {
        return codigo_de_seguranca;
    }

    public void setCodigo_de_seguranca(int codigo_de_seguranca) {
        this.codigo_de_seguranca = codigo_de_seguranca;
    }

    public Calendar getData_de_validade() {
        return data_de_validade;
    }

    public void setData_de_validade(Calendar data_de_validade) {
        this.data_de_validade = data_de_validade;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public String getNumero_cartao() {
        return numero_cartao;
    }

    public void setNumero_cartao(String numero_cartao) {
        this.numero_cartao = numero_cartao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    

}
