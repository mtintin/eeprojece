package cn.net.domain.entity;

import cn.net.domain.entity.AuthoLevel;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-11-15T16:43:49")
@StaticMetamodel(Authority.class)
public class Authority_ { 

    public static volatile SingularAttribute<Authority, String> author;
    public static volatile SingularAttribute<Authority, Long> id;
    public static volatile SingularAttribute<Authority, Integer> authorid;
    public static volatile SingularAttribute<Authority, String> url;
    public static volatile SetAttribute<Authority, AuthoLevel> authoLevel;

}