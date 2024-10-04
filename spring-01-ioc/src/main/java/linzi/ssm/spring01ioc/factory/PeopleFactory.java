package linzi.ssm.spring01ioc.factory;

import linzi.ssm.spring01ioc.bean.People;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * 如果制造一个对象很复杂（比如需要连接数据库），才会用到工厂方法帮助创建。
 * FactoryBean 在容器中放的组件的类型是泛型指定的类型，组件的名字是工厂自己的名字。
 */
@Component("people")
public class PeopleFactory implements FactoryBean<People> {
    /**
     * 调用这个方法给容器中制造对象。
     *
     * @return
     * @throws Exception
     */
    @Override
    public People getObject() throws Exception {
        return new People();
    }

    /**
     * 说明造的对象的类型，为多态扩展。
     * @return
     */
    @Override
    public Class<?> getObjectType() {
        return People.class;
    }

    /**
     * 说明造的对象是否是单例的。
     * @return
     */
    @Override
    public boolean isSingleton() {
        return true;
    }
}
