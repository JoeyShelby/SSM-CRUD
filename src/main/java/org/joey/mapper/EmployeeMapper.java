package org.joey.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.joey.pojo.Employee;
import org.joey.pojo.EmployeeExample;

public interface EmployeeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_emp
     *
     * @mbg.generated Mon May 02 16:59:39 CST 2022
     */
    long countByExample(EmployeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_emp
     *
     * @mbg.generated Mon May 02 16:59:39 CST 2022
     */
    int deleteByExample(EmployeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_emp
     *
     * @mbg.generated Mon May 02 16:59:39 CST 2022
     */
    int deleteByPrimaryKey(Integer empId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_emp
     *
     * @mbg.generated Mon May 02 16:59:39 CST 2022
     */
    int insert(Employee row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_emp
     *
     * @mbg.generated Mon May 02 16:59:39 CST 2022
     */
    int insertSelective(Employee row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_emp
     *
     * @mbg.generated Mon May 02 16:59:39 CST 2022
     */
    List<Employee> selectByExample(EmployeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_emp
     *
     * @mbg.generated Mon May 02 16:59:39 CST 2022
     */
    Employee selectByPrimaryKey(Integer empId);

    /**
     * 查询出员工的部门名
     * @param example
     * @return
     */
    List<Employee> selectByExampleWithDeptName(EmployeeExample example);

    /**
     * 查询出员工的部门名
     * @param empId
     * @return
     */
    Employee selectByPrimaryKeyWithDeptName(Integer empId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_emp
     *
     * @mbg.generated Mon May 02 16:59:39 CST 2022
     */
    int updateByExampleSelective(@Param("row") Employee row, @Param("example") EmployeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_emp
     *
     * @mbg.generated Mon May 02 16:59:39 CST 2022
     */
    int updateByExample(@Param("row") Employee row, @Param("example") EmployeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_emp
     *
     * @mbg.generated Mon May 02 16:59:39 CST 2022
     */
    int updateByPrimaryKeySelective(Employee row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_emp
     *
     * @mbg.generated Mon May 02 16:59:39 CST 2022
     */
    int updateByPrimaryKey(Employee row);
}