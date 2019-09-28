package com.xiaolai.ssm.controller;

import com.xiaolai.ssm.domain.Role;
import com.xiaolai.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

/**
 * @Description TODO
 * @Author weixinglin
 * @Date 2019/9/3 16:42
 **/
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("list.do")
    public ModelAndView listRole(){
        ModelAndView mv = new ModelAndView();
        try {
            List<Role> roles =  roleService.findAll();
            mv.addObject("roles",roles);
        } catch (Exception e) {
            e.printStackTrace();
        }
        mv.setViewName("role-list");
        return mv;
    }

    @RequestMapping("details.do")
    public ModelAndView roleDetails(String id){
        ModelAndView mv = new ModelAndView();
        try {
            Role role =  roleService.findById(id);
            mv.addObject("role",role);
        } catch (Exception e) {
            e.printStackTrace();
        }
        mv.setViewName("role-show");
        return mv;
    }

    @RequestMapping("delete.do")
    public String deleteRole(String id){

        roleService.deleteRoleById(id);

        return "redirect:list.do";
    }


    @RequestMapping("add.do")
    public String addRole(Role role){
        role.setId(UUID.randomUUID().toString().replace("-",""));
        roleService.addRole(role);

        return "redirect:list.do";
    }

    @RequestMapping("go_add_permission.do")
    public ModelAndView goAddPermission(String id){
        ModelAndView mv = new ModelAndView();
        try {
            Role role =  roleService.findByIdNot(id);
            mv.addObject("role",role);
        } catch (Exception e) {
            e.printStackTrace();
        }
        mv.setViewName("role-permission-add");
        return mv;
    }

    @RequestMapping("add_permission.do")
    public String addPermission(String roleId, String[] ids){

        roleService.addPermission(roleId,ids);

        return "redirect:list.do";
    }
}
