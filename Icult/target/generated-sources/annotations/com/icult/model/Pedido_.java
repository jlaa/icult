package com.icult.model;

import com.icult.model.Endereco;
import com.icult.model.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-08T16:31:01")
@StaticMetamodel(Pedido.class)
public class Pedido_ { 

    public static volatile SingularAttribute<Pedido, String> valor_total;
    public static volatile SingularAttribute<Pedido, String> desconto;
    public static volatile SingularAttribute<Pedido, Endereco> endereco;
    public static volatile SingularAttribute<Pedido, String> valor_frete;
    public static volatile SingularAttribute<Pedido, Long> idPedido;
    public static volatile ListAttribute<Pedido, Usuario> usuarios;
    public static volatile SingularAttribute<Pedido, String> quantidade;

}