package cn.net.domain.entity;

import cn.net.domain.entity.Course;
import cn.net.domain.entity.Student;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-11-15T16:43:49")
@StaticMetamodel(StudentCourseTake.class)
public class StudentCourseTake_ { 

    public static volatile SingularAttribute<StudentCourseTake, Student> student;
    public static volatile SetAttribute<StudentCourseTake, Course> courseSet;
    public static volatile SingularAttribute<StudentCourseTake, Long> teachPlan;
    public static volatile SingularAttribute<StudentCourseTake, Long> id;

}