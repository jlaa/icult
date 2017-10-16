package com.icult.model;

import com.icult.model.Usuario;
import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-16T17:03:31")
@StaticMetamodel(Produto.class)
public class Produto_ { 

    public static volatile SingularAttribute<Produto, Double> preco;
    public static volatile SingularAttribute<Produto, String> caracteristicas;
    public static volatile SingularAttribute<Produto, String> nome_produto;
    public static volatile SingularAttribute<Produto, Calendar> data_de_cadastro;
    public static volatile SingularAttribute<Produto, Long> id;
    public static volatile ListAttribute<Produto, Usuario> usuarios;
    public static volatile SingularAttribute<Produto, Integer> quantidade;

}