package cn.net.domain.vo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-11-15T16:43:49")
@StaticMetamodel(LessonReview.class)
public class LessonReview_ { 

    public static volatile SingularAttribute<LessonReview, Long> schedule;
    public static volatile ListAttribute<LessonReview, Float> reviewList;
    public static volatile SingularAttribute<LessonReview, Long> teacher;
    public static volatile SingularAttribute<LessonReview, Date> reviewdate;
    public static volatile SingularAttribute<LessonReview, Date> replydate;
    public static volatile SingularAttribute<LessonReview, Long> student;
    public static volatile SingularAttribute<LessonReview, Long> toTeacher;
    public static volatile SingularAttribute<LessonReview, Long> scheduleCode;
    public static volatile SingularAttribute<LessonReview, String> remark;
    public static volatile SingularAttribute<LessonReview, Long> id;
    public static volatile SingularAttribute<LessonReview, String> reply;

}