/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icult.model;

import java.io.Serializable;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author LucasPC
 */
@Entity
@Table(name = "USUARIO_TABLE")
@Access(AccessType.FIELD)
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USUARIO", nullable = false)
    private Long id;
    
    @NotBlank
    @Email
    @Column(name = "TXT_EMAIL", nullable = false)
    private String email;

    @NotBlank
    @Size(max = 60)
    @Column(name = "TXT_NOME", nullable = false)
    private String nome;
    
    @NotBlank
    @Size(max = 15)
    @Column(name = "TXT_CPF", nullable = false)
    private String cpf;
    
    @NotBlank
    @Size(min = 6,max=20)
    @Column(name = "TXT_SENHA", nullable = false)
    private String senha;
    
    @NotBlank
    @Size(min=3,max=15)
    @Column(name="TXT_LOGIN",nullable=false)
    private String nickname;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "TB_USUARIO_PRODUTO", joinColumns = {
        @JoinColumn(name = "ID_USUARIO")},
            inverseJoinColumns = {
                @JoinColumn(name = "ID_PRODUTO")
            })
    private List<Produto> produtos;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "TB_USUARIO_PEDIDO", joinColumns = {
        @JoinColumn(name = "ID_USUARIO")},
            inverseJoinColumns = {
                @JoinColumn(name = "ID_PEDIDO")
            })
    private List<Pedido> pedidos;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartaoDeCredito> cartaos;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public List<CartaoDeCredito> getCartaos() {
        return cartaos;
    }

    public void setCartaos(List<CartaoDeCredito> cartaos) {
        this.cartaos = cartaos;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public String getNickName() {
        return this.nickname;
    }

    public void setLogin(String nickname) {
        this.nickname = nickname;
    }
    
    public void CadastrarUsuario(String email,String nome, String cpf, String senha,String nickname)
    {
        this.email=email;
        this.nome=nome;
        this.cpf=cpf;
        this.senha=senha;
        this.nickname=nickname;
    }
    
    
    

}
