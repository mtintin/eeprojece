package cn.net.domain.entity;

import cn.net.domain.entity.Question;
import cn.net.domain.entity.ThemeReport;
import cn.net.domain.vo.ThemeStateEnum;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-11-15T16:43:49")
@StaticMetamodel(Theme.class)
public class Theme_ { 

    public static volatile ListAttribute<Theme, Float> scoreList;
    public static volatile SingularAttribute<Theme, Long> schedule;
    public static volatile ListAttribute<Theme, Question> questions;
    public static volatile SingularAttribute<Theme, Long> durationSecond;
    public static volatile SetAttribute<Theme, ThemeReport> themeReportSet;
    public static volatile SingularAttribute<Theme, Long> id;
    public static volatile SingularAttribute<Theme, ThemeStateEnum> themeState;
    public static volatile SingularAttribute<Theme, Long> startSecond;
    public static volatile SingularAttribute<Theme, Long> second;

}