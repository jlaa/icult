package com.icult.model;

import com.icult.model.Usuario;
import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-07T23:12:38")
@StaticMetamodel(CartaoDeCredito.class)
public class CartaoDeCredito_ { 

    public static volatile SingularAttribute<CartaoDeCredito, Integer> codigo_de_seguranca;
    public static volatile SingularAttribute<CartaoDeCredito, Calendar> data_de_validade;
    public static volatile SingularAttribute<CartaoDeCredito, Usuario> usuario;
    public static volatile SingularAttribute<CartaoDeCredito, Long> id;
    public static volatile SingularAttribute<CartaoDeCredito, String> nome_do_dono;
    public static volatile SingularAttribute<CartaoDeCredito, String> bandeira;
    public static volatile SingularAttribute<CartaoDeCredito, String> numero_cartao;

}