package com.xiaolai.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.xiaolai.ssm.domain.Orders;
import com.xiaolai.ssm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Description TODO
 * @Author weixinglin
 * @Date 2019/9/3 11:22
 **/
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 查询所有订单信息
     * @return
     */
    @RequestMapping("list.do")
    public ModelAndView listOrders(@RequestParam(name = "pageNum",required = true,defaultValue = "1") int pageNum,
                                   @RequestParam(name = "pageSize",required = true,defaultValue = "2") int pageSize){
        ModelAndView mv = new ModelAndView();
        try {
            List<Orders> orders =  orderService.findAll(pageNum,pageSize);
            PageInfo pageInfo = new PageInfo(orders);
            mv.addObject("orders",pageInfo);
            mv.setViewName("list_order");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }


    /**
     * 产看订单详情
     * @return
     */
    @RequestMapping("showDetails.do")
    public ModelAndView orderDetails(String id){
        ModelAndView mv = new ModelAndView();

        try {
            Orders order = orderService.findById(id);
            System.out.println(order);
            mv.addObject("order",order);
        } catch (Exception e) {
            e.printStackTrace();
        }

        mv.setViewName("show_order");
        return mv;
    }
}
