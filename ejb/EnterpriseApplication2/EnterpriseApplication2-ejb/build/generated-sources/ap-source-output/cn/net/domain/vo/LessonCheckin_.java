package cn.net.domain.vo;

import cn.net.domain.vo.CheckStateEnum;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-11-15T16:43:49")
@StaticMetamodel(LessonCheckin.class)
public class LessonCheckin_ { 

    public static volatile SingularAttribute<LessonCheckin, Long> schedule;
    public static volatile SingularAttribute<LessonCheckin, Long> student;
    public static volatile SingularAttribute<LessonCheckin, CheckStateEnum> checkState;
    public static volatile SingularAttribute<LessonCheckin, Long> scheduleCode;
    public static volatile SingularAttribute<LessonCheckin, Long> id;

}