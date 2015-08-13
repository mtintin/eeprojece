package cn.net.domain.entity;

import cn.net.domain.entity.StudentCourseTake;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-11-15T16:43:49")
@StaticMetamodel(Course.class)
public class Course_ { 

    public static volatile SingularAttribute<Course, String> courseName;
    public static volatile SingularAttribute<Course, String> totCount;
    public static volatile SingularAttribute<Course, String> major;
    public static volatile SingularAttribute<Course, Long> courseNum;
    public static volatile SingularAttribute<Course, String> bigCount;
    public static volatile SingularAttribute<Course, String> preNum;
    public static volatile SingularAttribute<Course, Long> teachPlan;
    public static volatile SingularAttribute<Course, Long> id;
    public static volatile SingularAttribute<Course, Long> teachGroup;
    public static volatile SetAttribute<Course, StudentCourseTake> StudentCourseTakeSet;

}