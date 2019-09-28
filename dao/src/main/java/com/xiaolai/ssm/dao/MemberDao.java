package com.xiaolai.ssm.dao;

import com.xiaolai.ssm.domain.Member;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Description TODO
 * @Author weixinglin
 * @Date 2019/9/3 12:52
 **/
public interface MemberDao {
    /**
     * 根据ID查询会员信息
     * @return
     * @throws Exception
     */
    @Select("select * from member where id=#{id}")
    Member findById(String id) throws Exception;

    @Select("select * from member")
    List<Member> findAll();
}
