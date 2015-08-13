package cn.net.domain.entity;

import cn.net.domain.entity.EvalueGroup;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-11-15T16:43:49")
@StaticMetamodel(Evalue.class)
public class Evalue_ { 

    public static volatile SingularAttribute<Evalue, Integer> itemId;
    public static volatile SingularAttribute<Evalue, Float> score;
    public static volatile SingularAttribute<Evalue, EvalueGroup> evalueGroup;
    public static volatile SingularAttribute<Evalue, String> name;
    public static volatile SingularAttribute<Evalue, Long> id;

}