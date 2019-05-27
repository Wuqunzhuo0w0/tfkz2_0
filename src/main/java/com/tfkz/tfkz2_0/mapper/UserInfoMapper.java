package com.tfkz.tfkz2_0.mapper;

import com.tfkz.tfkz2_0.pojo.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table neuedu_user
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table neuedu_user
     *
     * @mbggenerated
     */
    int insert(UserInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table neuedu_user
     *
     * @mbggenerated
     */
    UserInfo selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table neuedu_user
     *
     * @mbggenerated
     */
    List<UserInfo> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table neuedu_user
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(UserInfo record);

    /*根据用户名查找用户*/
    int checkUser(String username);

    /*
     * 根据用户名和密码查找用户*/
    UserInfo selectByUserNameAndPassword(@Param("username") String username, @Param("password") String password);

    /*根据邮箱查找用户*/
    int checkEmail(String username);

    /*根据用户名查找用户*/
    UserInfo forgetUserName(String username);

    /*
     * 根据用户名、密码问题、问题答案查找用户*/
    int selectByUserNameAndQuestionAndAnswer(@Param("username") String username, @Param("question") String question,@Param("answer") String answer);

    /*根据用户名修改密码*/
    int updateByUserName(@Param("username")String username,@Param("passwordNew")String passwordNew);

    /*根据用户名和旧密码修改密码*/
    int updateByUserNameAndPasswordOld(@Param("username")String username,@Param("passwordOld")String passwordOld,@Param("passwordNew")String passwordNew);

    /*根据用户名和旧密码修改密码*/
    int updateByID(UserInfo usr);
}