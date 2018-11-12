package com.agan.book.user.persistence;

import org.apache.ibatis.annotations.Param;

import com.agan.book.user.domain.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    public Integer login(@Param("userName") String userName,@Param("passWord") String passWord);
}