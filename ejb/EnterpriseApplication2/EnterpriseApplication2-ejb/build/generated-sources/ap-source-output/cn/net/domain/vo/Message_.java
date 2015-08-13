package cn.net.domain.vo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-11-15T16:43:49")
@StaticMetamodel(Message.class)
public class Message_ { 

    public static volatile SingularAttribute<Message, Long> teacherId;
    public static volatile SingularAttribute<Message, String> sender;
    public static volatile SingularAttribute<Message, Long> id;
    public static volatile SingularAttribute<Message, Integer> type;
    public static volatile SingularAttribute<Message, String> title;
    public static volatile SingularAttribute<Message, String> content;
    public static volatile SingularAttribute<Message, Date> sendTime;

}