package com.jn.controller;

import com.jn.domain.User;
import com.jn.service.UserUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: ManagerController
 * @Package: com.jn.controller
 * @Description:
 * @author：jn
 * @date： 2019/12/5 10:52
 */
@Controller
public class ManagerController {
    @Autowired
    UserUpdateService userUpdateService;

    @RequestMapping(value = "addUser")
    @ResponseBody
    public Map<String, Object> addUser(@RequestBody User user) {
        int flag = 0;
        Map<String, Object> map = new HashMap<>();
        flag = userUpdateService.addUser(user);
        if (flag == 401) {
            map.put("code", 401);
            map.put("data", "此用户名不可用");
            return map;
        }
        if (flag == 1) {
            map.put("code", 200);
            map.put("data", "增加用户成功");
        }
        return map;

    }

    @RequestMapping(value = "deleteUser")
    @ResponseBody
    public Map<String, Object> deleteUser(@RequestBody User user) {
        int flag = 0;
        Map<String, Object> map = new HashMap<>();
        flag = userUpdateService.deleteUser(user);
        if (flag == 1) {
            map.put("code", 200);
            map.put("data", "删除用户成功");
        }
        return map;

    }

    @RequestMapping(value = "searchUser")
    @ResponseBody
    public Map<String, Object> searchUser(@RequestBody User user) {


        Map<String, Object> map = new HashMap<>();
        if (user == null) {
            return map;
        }

        User user1 = userUpdateService.userSearch(user.getUser_id(), user.getUser_name());
        if (user1 != null) {
            map.put("code", 200);
            map.put("data", user1);
        }
        return map;

    }

    @RequestMapping(value = "changeUser")
    @ResponseBody
    public Map<String, Object> changeUser(@RequestBody Map<String, String> mymap) {
        long olduser_id = Long.parseLong(mymap.get("olduser_id"));
        String olduser_name = mymap.get("olduser_name");
        String olduser_password = mymap.get("olduser_password");
        User newuser = new User(mymap.get("user_name"), mymap.get("user_password"), Float.parseFloat(mymap.get("money")), Integer.parseInt(mymap.get("lnumber")));
        Map<String, Object> map = new HashMap<>();
        User olduser = new User(olduser_id, olduser_name, olduser_password);
        int flag = userUpdateService.changeUser(olduser, newuser);
        if (flag == 401) {
            map.put("code", 401);
            map.put("data", "此用户名不可用");
            return map;
        }
        if (flag == 1) {
            map.put("code", 200);
            map.put("data", "更改用户成功");
        }
        return map;

    }

}
