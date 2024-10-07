package linzi.ssm.spring01ioc.dao;

import ch.qos.logback.core.encoder.JsonEscapeUtil;
import linzi.ssm.spring01ioc.bean.Person;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@ToString
public class FamilyDAO {
    // 最基本的做法。
    @Autowired
    Person p;

    // 1. 构造器注入，是 Spring 家推荐的方式。
    //  Spring 自动去Person容器中找到构造器需要的所有参数的组件值。
    //  FamilyDAO(p=Person(name=linzi2, age=0, gender=))
    public FamilyDAO(Person person) {
        System.out.println("有参构造器中的person: " + person);
        this.p = person;
    }

    // 2. 标记在 setter 方法上。
    @Autowired
    public void setPerson(@Qualifier("linzi2") Person person) {
        System.out.println("AutoWired标记Setter方法的person: " + person);
        this.p = person;
    }

}
