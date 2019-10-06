package com.shsxt.crm.utils;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

public class LoginUserUtil {
    /**
     * 从cookie中获取userId
     *
     */
    public  static  int releaseUserIdFromCookie(HttpServletRequest request){
        //根据cookieUtil 类 获取指定的cookie        getCookieValue （ request ，key）
        String userIdString =CookieUtil.getCookieValue(request,"idStr");
        //javalang3   判断userIdString 是否为空  为空返回0
        if (StringUtils.isBlank(userIdString)){
            return  0;
        }
        //从 userIdBase64 类中解密 id的值  返回一个用户id
        Integer userId =UserIDBase64.decoderUserID(userIdString);
        return userId;

    }
}
