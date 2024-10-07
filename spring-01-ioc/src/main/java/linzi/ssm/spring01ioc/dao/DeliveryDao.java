package linzi.ssm.spring01ioc.dao;

import linzi.ssm.spring01ioc.datasource.MyDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeliveryDao {

    /**
     *  Q1：数据源有三个，会炸。
     *      1. 使用 @Primary 备胎方案，需要改来改去。
     *      2. 使用类似 @Conditional 的方案。只在某种环境下激活一个组件，即 @Profile。
     */
    @Autowired
    MyDataSource myDataSource;

    public void saveDelivery() {
        System.out.println("DataSource: " + myDataSource.getUrl());
    }
}
