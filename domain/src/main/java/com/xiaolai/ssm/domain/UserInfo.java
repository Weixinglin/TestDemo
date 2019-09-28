package com.xiaolai.ssm.domain;

import lombok.Data;

import java.util.List;

/**
 * @Description TODO
 * @Author weixinglin
 * @Date 2019/9/3 13:55
 **/
@Data
public class UserInfo {
    private String id;
    private String username;
    private String email;
    private String password;
    private String phoneNum;
    private int status;
    private String statusStr;
    private List<Role> roles;

    public String getStatusStr() {
        if(status==0){
            statusStr="未启用";
        }
        if(status==1){
            statusStr="已启用";
        }
        return statusStr;
    }
}
