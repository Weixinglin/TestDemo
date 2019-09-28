package com.xiaolai.ssm.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description TODO
 * @Author weixinglin
 * @Date 2019/9/3 11:13
 **/
@Data
public class Member implements Serializable {
    private String id;
    private String name;
    private String nickname;
    private String phoneNum;
    private String email;
}
