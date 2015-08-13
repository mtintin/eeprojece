package cn.net.domain.entity;

import cn.net.domain.entity.Authority;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-11-15T16:43:49")
@StaticMetamodel(AuthoLevel.class)
public class AuthoLevel_ { 

    public static volatile SingularAttribute<AuthoLevel, String> name;
    public static volatile SingularAttribute<AuthoLevel, Long> id;
    public static volatile SetAttribute<AuthoLevel, Authority> authors;

}