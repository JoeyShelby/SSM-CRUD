package org.joey.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.joey.pojo.Department;
import org.joey.pojo.DepartmentExample;

public interface DepartmentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dept
     *
     * @mbg.generated Mon May 02 16:59:39 CST 2022
     */
    long countByExample(DepartmentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dept
     *
     * @mbg.generated Mon May 02 16:59:39 CST 2022
     */
    int deleteByExample(DepartmentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dept
     *
     * @mbg.generated Mon May 02 16:59:39 CST 2022
     */
    int deleteByPrimaryKey(Integer deptId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dept
     *
     * @mbg.generated Mon May 02 16:59:39 CST 2022
     */
    int insert(Department row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dept
     *
     * @mbg.generated Mon May 02 16:59:39 CST 2022
     */
    int insertSelective(Department row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dept
     *
     * @mbg.generated Mon May 02 16:59:39 CST 2022
     */
    List<Department> selectByExample(DepartmentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dept
     *
     * @mbg.generated Mon May 02 16:59:39 CST 2022
     */
    Department selectByPrimaryKey(Integer deptId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dept
     *
     * @mbg.generated Mon May 02 16:59:39 CST 2022
     */
    int updateByExampleSelective(@Param("row") Department row, @Param("example") DepartmentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dept
     *
     * @mbg.generated Mon May 02 16:59:39 CST 2022
     */
    int updateByExample(@Param("row") Department row, @Param("example") DepartmentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dept
     *
     * @mbg.generated Mon May 02 16:59:39 CST 2022
     */
    int updateByPrimaryKeySelective(Department row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dept
     *
     * @mbg.generated Mon May 02 16:59:39 CST 2022
     */
    int updateByPrimaryKey(Department row);
}