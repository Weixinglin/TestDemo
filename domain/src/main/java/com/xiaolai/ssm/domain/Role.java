package com.xiaolai.ssm.domain;

import lombok.Data;
import org.springframework.security.core.userdetails.User;

import java.util.List;

/**
 * @Description TODO
 * @Author weixinglin
 * @Date 2019/9/3 13:57
 **/
@Data
public class Role {
    private String id;
    private String roleName;
    private String roleDesc;
    private List<Permission> permissions;
    private List<User> users;
}
