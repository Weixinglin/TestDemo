package com.xiaolai.ssm.controller;

import com.xiaolai.ssm.domain.UserInfo;
import com.xiaolai.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

/**
 * @Description TODO
 * @Author weixinglin
 * @Date 2019/9/3 15:05
 **/
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询所有用户信息
     * @return
     */
    @RequestMapping("list.do")
    public ModelAndView listUser(){
        ModelAndView mv = new ModelAndView();

        try {
            List<UserInfo> users =  userService.findAll();
            mv.addObject("users",users);
        } catch (Exception e) {
            e.printStackTrace();
        }

        mv.setViewName("list_user");
        return mv;
    }

    @RequestMapping("add.do")
    public String saveUser(UserInfo user){
        user.setId(UUID.randomUUID().toString().replace("-",""));
        try {
            userService.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:list.do";
    }

    @RequestMapping("show.do")
    public ModelAndView showUserDetails(String id){
        ModelAndView mv = new ModelAndView();
        try {
            UserInfo user =  userService.findById(id);
            mv.addObject("user",user);
        } catch (Exception e) {
            e.printStackTrace();
        }

        mv.setViewName("show_user");
        return mv;
    }

    @RequestMapping("addRole.do")
    public ModelAndView  addRole(String id){
        ModelAndView mv = new ModelAndView();
        try {
            UserInfo user =  userService.findById(id);
            mv.addObject("user",user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        mv.setViewName("user-role-add");
        return mv;
    }


    @RequestMapping("add_user_role.do")
    public String addUserRole(@RequestParam("userId") String userId, @RequestParam("ids") String[] ids){

        try {
            userService.addRoel(userId,ids);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:list.do";
    }
}
