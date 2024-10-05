package linzi.ssm.spring01ioc.service;

import linzi.ssm.spring01ioc.bean.Person;
import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Data
@ToString
@Service
public class UserService {

    /**
     * 在 PersonConfig 文件中使用 @Primary 指定正主。
     * 在次文件中使用 @Qualifier 指定备胎。
     */
    @Qualifier("linzi") // 如果容器中这样类型的组件有多个，精准指定容器的名字。
    @Autowired
    Person person;

}
