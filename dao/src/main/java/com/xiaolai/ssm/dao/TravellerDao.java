package com.xiaolai.ssm.dao;

import com.xiaolai.ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Description TODO
 * @Author weixinglin
 * @Date 2019/9/3 12:56
 **/
public interface TravellerDao {
    /**
     * 根据订单id查询游客信息
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId=#{id})")
    List<Traveller> findByOrderId(String id) throws Exception;
}
