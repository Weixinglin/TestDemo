package com.xiaolai.ssm.domain;

import lombok.Data;

import java.util.List;

/**
 * @Description TODO
 * @Author weixinglin
 * @Date 2019/9/3 14:00
 **/
@Data
public class Permission {
    private String id;
    private String permissionName;
    private String url;
    private List<Role> roles;
}
