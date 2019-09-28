package com.xiaolai.ssm.service;

import com.xiaolai.ssm.domain.Orders;

import java.util.List;

/**
 * @Description TODO
 * @Author weixinglin
 * @Date 2019/9/3 11:23
 **/
public interface OrderService {
    /**
     * 查询所有订单信息
     * @return
     * @throws Exception
     */
    List<Orders> findAll(int pageNum,int pageSize) throws Exception;


    /**
     * 根据ID查询订单
     * @param id
     * @throws Exception
     */
    Orders findById(String id) throws Exception;

}
