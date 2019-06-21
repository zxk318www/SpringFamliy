package zxk.com.springmybatis.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import zxk.com.springmybatis.model.Coffee;
import zxk.com.springmybatis.model.CoffeeExample;

public interface CoffeeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_COFFEE
     *
     * @mbg.generated Fri Jun 21 14:24:17 CST 2019
     */
    long countByExample(CoffeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_COFFEE
     *
     * @mbg.generated Fri Jun 21 14:24:17 CST 2019
     */
    int deleteByExample(CoffeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_COFFEE
     *
     * @mbg.generated Fri Jun 21 14:24:17 CST 2019
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_COFFEE
     *
     * @mbg.generated Fri Jun 21 14:24:17 CST 2019
     */
    int insert(Coffee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_COFFEE
     *
     * @mbg.generated Fri Jun 21 14:24:17 CST 2019
     */
    int insertSelective(Coffee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_COFFEE
     *
     * @mbg.generated Fri Jun 21 14:24:17 CST 2019
     */
    List<Coffee> selectByExampleWithRowbounds(CoffeeExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_COFFEE
     *
     * @mbg.generated Fri Jun 21 14:24:17 CST 2019
     */
    List<Coffee> selectByExample(CoffeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_COFFEE
     *
     * @mbg.generated Fri Jun 21 14:24:17 CST 2019
     */
    Coffee selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_COFFEE
     *
     * @mbg.generated Fri Jun 21 14:24:17 CST 2019
     */
    int updateByExampleSelective(@Param("record") Coffee record, @Param("example") CoffeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_COFFEE
     *
     * @mbg.generated Fri Jun 21 14:24:17 CST 2019
     */
    int updateByExample(@Param("record") Coffee record, @Param("example") CoffeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_COFFEE
     *
     * @mbg.generated Fri Jun 21 14:24:17 CST 2019
     */
    int updateByPrimaryKeySelective(Coffee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_COFFEE
     *
     * @mbg.generated Fri Jun 21 14:24:17 CST 2019
     */
    int updateByPrimaryKey(Coffee record);
}