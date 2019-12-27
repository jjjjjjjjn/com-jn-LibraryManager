package com.jn.service;

import com.jn.domain.User;

/**
 * @ClassName: UserUpdateService
 * @Package: com.jn.service
 * @Description:
 * @author：jn
 * @date： 2019/12/4 18:05
 */
public interface UserUpdateService {
//    用户修改用户名密码
    int userUpdate(String oldname,String oldpassword,String newname,String newpassword);
//   增加用户
    int addUser(User user);
//    搜索用户
    User userSearch(long user_id,String user_name);
//    删除用户
    int deleteUser(User user);
//    管理员修改用户信息
    int changeUser(User olduser,User newuser);
}
