package com.shsxt.crm.utils;

import com.shsxt.base.exceptions.ParamsException;

public class AssertsUtils {

    /**
     * 断言            isTrue（表达式为真，自己写的msg）
     *                      {
     *                          抛出一个自定义异常  传自己写的msg进去
     *                      }
     *
     *
     *
     * @param flag
     * @param msg
     */

    public  static  void  isTrue(boolean flag,String msg){
        /**
         * 判断  如果传过来的flag 为真    抛出一个运行期异常  传一个msg进去
         */
        if (flag){
            //抛出一个自己定义的  paramException  程序停止运行
            throw  new ParamsException(msg);
        }
    }

    public  static  void  isTrue(boolean flag,Integer code ,String msg){
        /**
         * 判断  如果传过来的flag 为真    抛出一个运行期异常  传一个msg进去
         */
        if (flag){
            throw  new ParamsException(code,msg);
        }
    }
    public  static  void  isTrue(boolean flag){
        /**
         * 判断  如果传过来的flag 为真    抛出一个运行期异常  传一个msg进去
         */
        if (flag){
            throw  new ParamsException();
        }
    }
}
