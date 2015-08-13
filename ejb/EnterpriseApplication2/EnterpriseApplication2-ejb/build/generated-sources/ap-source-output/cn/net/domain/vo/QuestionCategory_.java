package cn.net.domain.vo;

import cn.net.domain.vo.QuestionCategory;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-11-15T16:43:49")
@StaticMetamodel(QuestionCategory.class)
public class QuestionCategory_ { 

    public static volatile SingularAttribute<QuestionCategory, String> name;
    public static volatile SingularAttribute<QuestionCategory, QuestionCategory> qcategory;
    public static volatile SingularAttribute<QuestionCategory, Long> id;
    public static volatile ListAttribute<QuestionCategory, QuestionCategory> qcategorys;
    public static volatile SingularAttribute<QuestionCategory, Integer> type;

}