package com.xiaolai.ssm.domain;

import com.xiaolai.ssm.utils.DateUtils;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Description TODO
 * @Author weixinglin
 * @Date 2019/9/3 11:12
 **/
@Data
public class Orders implements Serializable {
    private String id;
    private String orderNum;
    private Date orderTime;
    private String orderTimeStr;
    private int orderStatus;
    private String orderStatusStr;
    private int peopleCount;
    private Product product;
    private List<Traveller> travellers;
    private Member member;
    private Integer payType;
    private String payTypeStr;
    private String orderDesc;

    public String getOrderStatusStr() {
        if(orderStatus==0){
            orderStatusStr="未支付";
        }
        if(orderStatus==1){
            orderStatusStr="已支付";
        }
        return orderStatusStr;
    }

    public String getOrderTimeStr() {
        if(orderTime!=null){
            orderTimeStr = DateUtils.DateToString(orderTime,"YYYY-MM-DD HH:mm:ss");
        }
        return orderTimeStr;
    }

    public String getPayTypeStr() {
        if(payType==0){
            payTypeStr="微信支付";
        }
        if(payType==1){
            payTypeStr="支付宝支付";
        }
        return payTypeStr;
    }
}
