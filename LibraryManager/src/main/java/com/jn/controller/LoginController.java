package com.jn.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jn.domain.Manager;
import com.jn.domain.User;
import com.jn.service.LoginService;
import com.jn.util.JedisUtil;
import com.jn.util.MyUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: ManagerController
 * @Package: com.jn.controller
 * @Description:
 * @author：jn
 * @date： 2019/11/29 10:44
 */
@Controller
public class LoginController {
    @Autowired
    LoginService loginService;
    @Autowired
    JedisUtil jedisUtil;

    @RequestMapping(value = "login")
    @ResponseBody
    public Map<String, Object> login(@RequestBody Map<String, String> map2, HttpServletRequest request, HttpServletResponse response) {
        String name = map2.get("name");
        String password = map2.get("password");
        Map<String, Object> map3 = loginService.login(name, password);
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> map1 = new HashMap<>();
        if (map3 == null) {
            return map;
        }
        String uuid = MyUUID.getUUID();
        if (map3.containsKey("user")) {
            User user = (User) map3.get("user");
            jedisUtil.putPerson(uuid, user.getUser_name(), user.getUser_password());
            map.put("code", 200);
            map1.put("power", 1);
            map1.put("user", user);
            map.put("data", map1);
        } else if (map3.containsKey("manager")) {
            Manager manager = (Manager) map3.get("manager");
            jedisUtil.putPerson(uuid, manager.getM_name(), manager.getM_password());
            map.put("code", 200);
            map1.put("power", 2);
            map1.put("manager", manager);
            map.put("data", map1);
        }
        Cookie cookie1 = new Cookie("uuid", uuid);
        response.addCookie(cookie1);

        return map;
    }


}
