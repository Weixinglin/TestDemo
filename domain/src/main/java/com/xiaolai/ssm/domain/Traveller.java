package com.xiaolai.ssm.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description TODO
 * @Author weixinglin
 * @Date 2019/9/3 11:16
 **/
@Data
public class Traveller implements Serializable {
    private String id;
    private String name;
    private String sex;
    private String phoneNum;
    private Integer credentialsType;
    private String credentialsTypeStr;
    private String credentialsNum;
    private Integer travellerType;
    private String travellerTypeStr;

    public String getCredentialsTypeStr() {

        if(credentialsType==0){
            credentialsTypeStr="身份证";
        }else if(credentialsType==1){
            credentialsTypeStr="护照";
        }else{
            credentialsTypeStr="其它证件";
        }
        return credentialsTypeStr;
    }
}
