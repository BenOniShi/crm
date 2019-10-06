package com.shsxt.base;

import com.shsxt.crm.model.ResultInfo;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;

public class BaseController {

    /**
     *通常，Spring-MVC始终会先调用该方法，然后再调用任何请求处理程序方法。也就是说，在调用带有@RequestMapping注释
     * 的控制器方法之前，先调用@ModelAttribute方法。该序列背后的逻辑是，必须在控制器方法内部开始任何处理之前创建模型对象。
     * @param request
     */
    @ModelAttribute
    public void preHandler(HttpServletRequest request) {
        request.setAttribute("ctx", request.getContextPath());
    }

    /**
     *
     * @return
     */
    public ResultInfo success() {
        return new ResultInfo();
    }

    public ResultInfo success(Object result) {
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setResult(result);
        return resultInfo;

    }
    public ResultInfo success(String result) {
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setMsg(result);
        return resultInfo;

    }
}
