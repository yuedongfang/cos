package com.chaoren.aop.exception;

import com.chaoren.base.result.Result;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * SpringMVC系统异常处理
 *
 * @author niuxiaozu
 */
public class SystemExceptionHandler extends AbstractHandlerExceptionResolver {


    /**
     * 注入视图bean用于解析modelandview
     */
    private View viewBean;

    private static final Log log = LogFactory.getLog(SystemExceptionHandler.class);

    public SystemExceptionHandler(View viewBean) {
        this.viewBean = viewBean;
    }

    @Override
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        Object i = request.getAttribute("oldTokenIsClear");
        Result result = new Result();

        if (ex instanceof BusinessException) {
            log.error("业务异常:" + ex.getMessage() + "\turl:" + request.getRequestURI());
            result.setSuccess(false);
            result.setExCode(((BusinessException) ex).getCode());
            result.setMsg(ex.getMessage());
        } else {
            log.error("系统异常:" + ex.getMessage() + "\turl:" + request.getRequestURI(), ex);
            result.setSuccess(false);
            result.setExCode(((BusinessException) ex).getCode());
            result.setMsg("未知原因");
        }
        ModelAndView modelAndView = new ModelAndView(viewBean);
        modelAndView.addObject("success", result.isSuccess());
        modelAndView.addObject("excode", result.getExCode());
        modelAndView.addObject("msg", result.getMsg());
        return modelAndView;
    }

    public View getViewBean() {
        return viewBean;
    }

    public void setViewBean(View viewBean) {
        this.viewBean = viewBean;
    }
}