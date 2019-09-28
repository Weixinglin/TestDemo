package com.xiaolai.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.xiaolai.ssm.domain.Product;
import com.xiaolai.ssm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Description TODO
 * @Author weixinglin
 * @Date 2019/9/2 17:42
 **/

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * 显示所有商品信息
     * @return
     */
    @RequestMapping("list.do")
    public ModelAndView listProduct(@RequestParam(name = "pageNum",required = true,defaultValue = "1") int pageNum,
                                    @RequestParam(name = "pageSize",required = true,defaultValue = "2") int pageSize){
        ModelAndView mv = new ModelAndView();
        try {
            List<Product> products = productService.findAll(pageNum,pageSize);
            PageInfo pageInfo = new PageInfo(products);

            mv.addObject("products",pageInfo);
            mv.setViewName("list_product");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }

    /**
     * 添加商品信息
     * @param product
     * @return
     */
    @RequestMapping("add.do")
    public String addProduct(Product product){
        product.setId(UUID.randomUUID().toString().replace("-",""));
        try {
            productService.save(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:list.do";
    }


    /**
     * 删除商品信息
     * @param ids
     * @return
     */
    @RequestMapping("/delete.do")
    public String deleteProduct(String[] ids){

        List<String> idList = new ArrayList<String>();
        for (String id : ids){
            idList.add(id);
        }
        try {
            productService.deleteByIds(idList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:list.do";
    }


    /**
     * 开启商品
     * @param ids
     * @return
     */
    @RequestMapping("/open.do")
    public String openProduct(String[] ids){

        List<String> idList = new ArrayList<String>();
        for (String id : ids){
            idList.add(id);
        }
        try {
            productService.openProduct(idList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:list.do";
    }

    /**
     * 关闭商品
     * @param ids
     * @return
     */
    @RequestMapping("/close.do")
    public String closeProduct(String[] ids){

        List<String> idList = new ArrayList<String>();
        for (String id : ids){
            idList.add(id);
        }
        try {
            productService.closeProduct(idList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:list.do";
    }

}
