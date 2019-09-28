package com.xiaolai.ssm.dao;

import com.xiaolai.ssm.domain.Member;
import com.xiaolai.ssm.domain.Orders;
import com.xiaolai.ssm.domain.Product;
import com.xiaolai.ssm.domain.Traveller;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description TODO
 * @Author weixinglin
 * @Date 2019/9/3 11:24
 **/
@Repository
public interface OrderDao {


    @Select("select * from orders")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "product",column = "productId",javaType = Product.class,
                one=@One(select = "com.xiaolai.ssm.dao.ProductDao.findById",fetchType = FetchType.DEFAULT)
            )
    })
    List<Orders> findAll() throws Exception;


    @Select("select * from orders where id=#{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "product",column = "productId",javaType = Product.class,
                    one=@One(select = "com.xiaolai.ssm.dao.ProductDao.findById",fetchType = FetchType.DEFAULT)
            ),
            @Result(property = "member",column = "memberId",javaType = Member.class,
                    one=@One(select = "com.xiaolai.ssm.dao.MemberDao.findById",fetchType = FetchType.DEFAULT)
            ),
            @Result(property = "travellers",column = "id",javaType = List.class,
                    many = @Many(select = "com.xiaolai.ssm.dao.TravellerDao.findByOrderId",fetchType = FetchType.DEFAULT)
            )
    })
    Orders findById(String id);
}
