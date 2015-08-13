package cn.net.domain.entity;

import cn.net.domain.vo.UseInfo;
import cn.net.domain.vo.UserStateEnum;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-11-15T16:43:49")
@StaticMetamodel(Student.class)
public class Student_ { 

    public static volatile SingularAttribute<Student, String> schoolNum;
    public static volatile SingularAttribute<Student, UserStateEnum> userStateEnumm;
    public static volatile SingularAttribute<Student, String> schoolClassNum;
    public static volatile SingularAttribute<Student, Long> id;
    public static volatile SingularAttribute<Student, UseInfo> info;

}