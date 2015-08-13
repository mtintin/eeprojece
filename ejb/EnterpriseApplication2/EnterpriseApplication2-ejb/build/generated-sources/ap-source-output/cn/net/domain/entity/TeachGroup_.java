package cn.net.domain.entity;

import cn.net.domain.entity.AuthoLevel;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-11-15T16:43:49")
@StaticMetamodel(TeachGroup.class)
public class TeachGroup_ { 

    public static volatile SingularAttribute<TeachGroup, Long> schoolId;
    public static volatile SingularAttribute<TeachGroup, String> name;
    public static volatile SingularAttribute<TeachGroup, Long> id;
    public static volatile SingularAttribute<TeachGroup, AuthoLevel> levelTeachGroup;

}