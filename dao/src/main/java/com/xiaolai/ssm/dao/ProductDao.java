package com.xiaolai.ssm.dao;

import com.xiaolai.ssm.domain.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description TODO
 * @Author weixinglin
 * @Date 2019/9/2 17:40
 **/
@Repository
public interface ProductDao {

    @Select("select * from product")
    List<Product> findAll() throws Exception;

    @Insert("insert into product (id,productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) " +
            "values (#{id},#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product) throws Exception;

    @Delete({
            "<script>delete from product where id in "
                    + "<foreach item='item' index='index' collection='ids' open='(' separator=',' close=')'>"
                    + "#{item}"
                    + "</foreach>"
                    + "</script>"
    })
    void deleteByIds(@Param("ids")List<String> ids) throws Exception;

    @Update({
            "<script>update product set productStatus=1  where id in "
                    + "<foreach item='item' index='index' collection='ids' open='(' separator=',' close=')'>"
                    + "#{item}"
                    + "</foreach>"
                    + "</script>"
    })
    void openProduct(@Param("ids") List<String> idList) throws Exception;

    @Update({
            "<script>update product set productStatus=0  where id in "
                    + "<foreach item='item' index='index' collection='ids' open='(' separator=',' close=')'>"
                    + "#{item}"
                    + "</foreach>"
                    + "</script>"
    })
    void closeProduct(@Param("ids") List<String> idList) throws Exception;

    @Select("select * from product where id=#{id}")
    Product findById(String id);
}
