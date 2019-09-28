package com.xiaolai.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.xiaolai.ssm.dao.ProductDao;
import com.xiaolai.ssm.domain.Product;
import com.xiaolai.ssm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description TODO
 * @Author weixinglin
 * @Date 2019/9/2 17:38
 **/
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> findAll(int pageNum,int pageSize) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        return productDao.findAll();
    }

    @Override
    public void save(Product product) throws Exception {
        productDao.save(product);
    }

    @Override
    public void deleteByIds(List<String> ids) throws Exception {
        productDao.deleteByIds(ids);
    }

    @Override
    public void openProduct(List<String> idList) throws Exception {
        productDao.openProduct(idList);
    }

    @Override
    public void closeProduct(List<String> idList) throws Exception {
        productDao.closeProduct(idList);
    }
}
