package com.xiaolai.ssm.service;

import com.xiaolai.ssm.domain.Product;

import java.util.List;

/**
 * @Description TODO
 * @Author weixinglin
 * @Date 2019/9/2 17:36
 **/
public interface ProductService {

    /**
     * 查询所有产品信息
     * @return
     * @throws Exception
     */
    List<Product> findAll(int pageNum,int pageSize) throws Exception;

    /**
     * 新增商品信息
     * @param product
     */
    void save(Product product) throws Exception;

    void deleteByIds(List<String> ids) throws Exception;

    void openProduct(List<String> idList) throws Exception;

    void closeProduct(List<String> idList) throws Exception;
}
