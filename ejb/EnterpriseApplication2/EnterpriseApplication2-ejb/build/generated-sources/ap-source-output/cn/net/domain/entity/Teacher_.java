package cn.net.domain.entity;

import cn.net.domain.entity.AuthoLevel;
import cn.net.domain.vo.UseInfo;
import cn.net.domain.vo.UserStateEnum;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-11-15T16:43:49")
@StaticMetamodel(Teacher.class)
public class Teacher_ { 

    public static volatile SingularAttribute<Teacher, UserStateEnum> userStateEnumm;
    public static volatile SingularAttribute<Teacher, Long> officeId;
    public static volatile SingularAttribute<Teacher, AuthoLevel> level;
    public static volatile SingularAttribute<Teacher, Long> id;
    public static volatile SingularAttribute<Teacher, Long> teachGroup;
    public static volatile SingularAttribute<Teacher, UseInfo> info;

}