package cn.net.domain.vo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-11-15T16:43:49")
@StaticMetamodel(LessonCredit.class)
public class LessonCredit_ { 

    public static volatile SingularAttribute<LessonCredit, Long> schedule;
    public static volatile SingularAttribute<LessonCredit, Long> student;
    public static volatile SingularAttribute<LessonCredit, Float> totalCredit;
    public static volatile SingularAttribute<LessonCredit, Long> scheduleCode;
    public static volatile SingularAttribute<LessonCredit, Long> id;
    public static volatile ListAttribute<LessonCredit, Float> creditList;

}