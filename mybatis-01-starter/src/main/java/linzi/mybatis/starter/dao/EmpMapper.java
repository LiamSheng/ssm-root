package linzi.mybatis.starter.dao;

import linzi.mybatis.starter.bean.Emp;
import org.apache.ibatis.annotations.Mapper;

/**
 * 使用 Mybatis 不再需要实例化 DAO 接口了.
 */
@Mapper // 告诉 Spring 这是 Mybatis 操作数据库使用的接口.
public interface EmpMapper {

    Emp getEmpById(int id);

}
