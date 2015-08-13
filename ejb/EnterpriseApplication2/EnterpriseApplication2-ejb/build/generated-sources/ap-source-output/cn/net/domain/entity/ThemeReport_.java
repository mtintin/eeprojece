package cn.net.domain.entity;

import cn.net.domain.entity.Theme;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-11-15T16:43:49")
@StaticMetamodel(ThemeReport.class)
public class ThemeReport_ { 

    public static volatile ListAttribute<ThemeReport, String> questinReport;
    public static volatile SingularAttribute<ThemeReport, Long> schedule;
    public static volatile SingularAttribute<ThemeReport, Long> student;
    public static volatile SingularAttribute<ThemeReport, Theme> theme;
    public static volatile SingularAttribute<ThemeReport, Long> id;
    public static volatile SingularAttribute<ThemeReport, Float> totalScore;

}