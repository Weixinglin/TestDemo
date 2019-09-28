package com.xiaolai.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.xiaolai.ssm.dao.OrderDao;
import com.xiaolai.ssm.domain.Orders;
import com.xiaolai.ssm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description TODO
 * @Author weixinglin
 * @Date 2019/9/3 11:24
 **/
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;


    @Override
    public List<Orders> findAll(int pageNum,int pageSize) throws Exception {

        PageHelper.startPage(pageNum,pageSize);

        return orderDao.findAll();
    }

    @Override
    public Orders findById(String id) throws Exception {
        return orderDao.findById(id);
    }
}
