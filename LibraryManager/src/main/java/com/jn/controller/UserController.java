package com.jn.controller;


import com.jn.domain.Book;
import com.jn.domain.Record;
import com.jn.domain.User;
import com.jn.service.*;
import com.jn.util.CookieUtil;
import com.jn.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: UserController
 * @Package: com.jn.controller
 * @Description:
 * @author：jn
 * @date： 2019/12/2 16:00
 */


@Controller
public class UserController {
    @Autowired
    UserUpdateService userUpdateService;
    @Autowired
    ShowByTypeService showByTypeService;
    @Autowired
    SearchBookService searchBookService;
    @Autowired
    ShowRecordService showRecordService;
    @Autowired
    CookieUtil cookieUtil;

    @RequestMapping(value = "showType")
    @ResponseBody
    public Map<String, Object> showType(HttpServletRequest request) {


        List<String> tlist = showByTypeService.types();
        Map<String, Object> map = new HashMap<>();
        map.put("data", tlist);
        if (tlist != null) {
            map.put("code", 200);
        }
        return map;
    }

    @RequestMapping(value = "showByType")
    @ResponseBody
    public Map<String, Object> showByType(@RequestBody Map<String, String> mymap) {


        String type = mymap.get("type");
        Map<String, Object> bmap = showByTypeService.showByType(type, Integer.parseInt(mymap.get("pageNo")));
        Map<String, Object> map = new HashMap<>();
        if (bmap == null) {
            return map;
        }
        map.put("code", 200);
        map.put("data", bmap);
        return map;
    }

    @RequestMapping(value = "searchBook")
    @ResponseBody
    public Map<String, Object> searchBook(@RequestBody Map<String, String> mymap) {
        Book book = new Book(mymap.get("name"), mymap.get("category"), mymap.get("author"), mymap.get("press"));
        int pageNo1 = Integer.parseInt(mymap.get("pageNo"));
        Map<String, Object> bmap = searchBookService.searchBook(book, pageNo1);
        Map<String, Object> map = new HashMap<>();
        if (bmap == null) {
            return map;
        }
        map.put("code", 200);
        map.put("data", bmap);
        return map;
    }

    @RequestMapping(value = "lendRecord")
    @ResponseBody
    public Map<String, Object> lendRecord(HttpServletRequest request, @RequestBody Map<String, String> mymap) {

        int pageNo = Integer.parseInt(mymap.get("pageNo"));
        Cookie[] cookies = request.getCookies();
        User user1 = (User) cookieUtil.getUser(cookies);
        long user_id = user1.getUser_id();
        Map<String, Object> records = showRecordService.showRecord(user_id, pageNo);
        Map<String, Object> map = new HashMap<>();
        if (records.size() == 0) {
            return map;
        }
        map.put("code", 200);
        map.put("data", records);
        return map;
    }

    @RequestMapping(value = "userSelfUpdate")
    @ResponseBody
    public Map<String, Object> userSelfUpdate(@RequestBody Map<String, String> mymap) {

        int flag = userUpdateService.userUpdate(mymap.get("oldname"), mymap.get("oldpassword"), mymap.get("newname"), mymap.get("newpassword"));
        Map<String, Object> map = new HashMap<>();

        if (flag == 401) {
            map.put("code", 401);
            map.put("data", "此用户名不可用");
            return map;
        }
        if (flag == 402) {
            map.put("code", 402);
            map.put("data", "旧用户名密码输入错误");
            return map;
        }
        if (flag == 1) {
            map.put("code", 200);
            map.put("data", "用户名密码更改成功");
            return map;
        }
        return map;
    }
}
