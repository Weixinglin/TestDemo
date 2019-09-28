package com.xiaolai.ssm.controller;

import com.xiaolai.ssm.domain.Permission;
import com.xiaolai.ssm.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

/**
 * @Description TODO
 * @Author weixinglin
 * @Date 2019/9/3 16:33
 **/
@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @RequestMapping("list.do")
    public ModelAndView listpermission(){
        ModelAndView mv = new ModelAndView();
        try {
            List<Permission> permissions =  permissionService.findAll();
            mv.addObject("permissions",permissions);
        } catch (Exception e) {
            e.printStackTrace();
        }
        mv.setViewName("permission-list");
        return mv;
    }

    @RequestMapping("details.do")
    public ModelAndView permissionDetails(String id){
        ModelAndView mv = new ModelAndView();
        try {
            Permission permission =  permissionService.findById(id);
            mv.addObject("permission",permission);
        } catch (Exception e) {
            e.printStackTrace();
        }
        mv.setViewName("permission-show");
        return mv;
    }

    @RequestMapping("delete.do")
    public String deletePermission(String id){

        permissionService.deletePermissionById(id);

        return "redirect:list.do";
    }

    @RequestMapping("add.do")
    public String addPermission(Permission permission){

        permission.setId(UUID.randomUUID().toString().replace("-",""));

        permissionService.addPermission(permission);

        return "redirect:list.do";
    }

}
