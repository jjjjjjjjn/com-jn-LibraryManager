package com.jn.controller;

import com.jn.domain.User;
import com.jn.service.LendAndReturnService;
import com.jn.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: LendAndReturn
 * @Package: com.jn.controller
 * @Description:
 * @author：jn
 * @date： 2019/12/3 18:21
 */
@Controller
public class LendAndReturn {
    @Autowired
    LendAndReturnService lendAndReturnService;
    @Autowired
    CookieUtil cookieUtil;

    @RequestMapping(value = "lend")
    @ResponseBody
    public Map<String, Object> lend(HttpServletRequest request, @RequestBody Map<String, String> mymap) {
        Long book_id = Long.parseLong(mymap.get("book_id"));

        Cookie[] cookies = request.getCookies();
        User user1 = (User) cookieUtil.getUser(cookies);
        long user_id = user1.getUser_id();
        int flag = lendAndReturnService.lendBook(book_id, user_id);
        Map<String, Object> map = new HashMap<>();
        if (flag == 401) {
            map.put("code", 401);
            map.put("data", "书籍库存量不足");

            return map;
        }
        if (flag == 402) {
            map.put("code", 402);
            map.put("data", "用户借书已达上限");
            return map;
        }
        if (flag == 403) {
            map.put("code", 403);
            map.put("data", "用户余额不足");
        }
        if (flag == 3) {
            map.put("code", 200);
            map.put("data", "借阅成功");
        }
        return map;
    }

    @RequestMapping(value = "return1")
    @ResponseBody
    public Map<String, Object> return1(HttpServletRequest request, @RequestBody Map<String, String> mymap) {

        Long book_id = Long.parseLong(mymap.get("book_id"));
        Long re_id = Long.parseLong(mymap.get("re_id"));
        Cookie[] cookies = request.getCookies();
        User user1 = (User) cookieUtil.getUser(cookies);

        long user_id = user1.getUser_id();
        int flag = lendAndReturnService.returnBook(re_id, book_id, user_id);
        Map<String, Object> map = new HashMap<>();
        if (flag == 3) {
            map.put("code", 200);
            map.put("data", "还书成功");
        }
        return map;
    }

}
