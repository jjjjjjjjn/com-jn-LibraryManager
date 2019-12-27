package com.jn.dao;

import com.jn.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: User
 * @Package: com.jn.dao
 * @Description:
 * @author：jn
 * @date： 2019/11/28 16:08
 */
public interface UserDao {
//    登陆
    User selectOne(String name, String password);
//  查询已借书数量
    int  getLnumber(long user_id);
//  查询余额
    int  getMoney(long user_id);
//    为指定用户加锁
    User lockOne(long user_id);
//    修改用户名和密码
    int updateOne(long user_id,String newname,String newpassword);
//    用户借书数量+1或-1
    int setLnumber(long user_id,int number);
//    用户检索
    User selectUser(@Param("user_id") long user_id, @Param("user_name") String user_name);
//    用户注册
    int addUser(User user);
//   用户删除
    int deleteUser(long user_id);
//    管理员修改用户
    int changeUser(User user);
//    获得所有用户
    List<User> selectAll();
//    根据id修改用户余额
    int changeMoney(long user_id,float money);
}
