package cn.net.domain.entity;

import cn.net.domain.entity.Theme;
import cn.net.domain.vo.Ware;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-11-15T16:43:49")
@StaticMetamodel(Question.class)
public class Question_ { 

    public static volatile SetAttribute<Question, Theme> themeSet;
    public static volatile SingularAttribute<Question, String> checka;
    public static volatile SingularAttribute<Question, String> note;
    public static volatile SingularAttribute<Question, String> checkb;
    public static volatile SingularAttribute<Question, String> checkc;
    public static volatile ListAttribute<Question, Ware> wareSet;
    public static volatile SingularAttribute<Question, String> checkd;
    public static volatile SingularAttribute<Question, String> checke;
    public static volatile SingularAttribute<Question, Integer> type;
    public static volatile SingularAttribute<Question, String> title;
    public static volatile SingularAttribute<Question, String> answer;
    public static volatile SingularAttribute<Question, Long> questionCategory;
    public static volatile SingularAttribute<Question, Long> id;

}