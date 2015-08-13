package cn.net.domain.entity;

import cn.net.domain.vo.LessonStateEnum;
import cn.net.domain.vo.ScheduleInfo;
import cn.net.domain.vo.Ware;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-11-15T16:43:49")
@StaticMetamodel(Schedule.class)
public class Schedule_ { 

    public static volatile SingularAttribute<Schedule, LessonStateEnum> classState;
    public static volatile SetAttribute<Schedule, Ware> courseWareSet;
    public static volatile SingularAttribute<Schedule, Long> evaluePlan;
    public static volatile SingularAttribute<Schedule, Long> id;
    public static volatile SingularAttribute<Schedule, ScheduleInfo> info;

}