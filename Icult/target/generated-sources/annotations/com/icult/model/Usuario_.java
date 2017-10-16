package com.icult.model;

import com.icult.model.CartaoDeCredito;
import com.icult.model.Pedido;
import com.icult.model.Produto;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-16T17:03:31")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> senha;
    public static volatile ListAttribute<Usuario, Produto> produtos;
    public static volatile SingularAttribute<Usuario, String> cpf;
    public static volatile SingularAttribute<Usuario, String> nickname;
    public static volatile SingularAttribute<Usuario, String> nome;
    public static volatile SingularAttribute<Usuario, Long> id;
    public static volatile ListAttribute<Usuario, Pedido> pedidos;
    public static volatile SingularAttribute<Usuario, String> email;
    public static volatile ListAttribute<Usuario, CartaoDeCredito> cartaos;

}