package com.jn.service;

import com.jn.domain.Manager;

import java.util.Map;

/**
 * @ClassName: ManagerService
 * @Package: com.jn.service
 * @Description:
 * @author：jn
 * @date： 2019/11/29 10:31
 */
public interface LoginService {
//    登陆
    Map<String,Object> login(String name, String password);
}
