package lut.software.gavinoblog.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.MessageFormat;

/**
 * @author ywg
 * @version 1.0
 * @description 统一异常处理  会判断所有标注有Controller这个注解的控制器，如果有异常则拦截下来
 * @date 2020/3/6 10:19
 */
@ControllerAdvice
public class BusinessException extends RuntimeException {

    //获取日志(slf4j包下的)
    private static final Logger LOGGER = LoggerFactory.getLogger(BusinessException.class);
    protected String errorCode;
    protected String[] errorMessageArguments;
//    protected APIResponse apiResponse;

    protected BusinessException() {
        this("");
    }

    public BusinessException(String message) {
        super(message);
        this.errorCode = "fail";
        this.errorMessageArguments = new String[0];
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
        this.errorCode = "fail";
        this.errorMessageArguments = new String[0];
    }

    public static BusinessException withErrorCode(String errorCode) {
        BusinessException businessException = new BusinessException();
        businessException.errorCode = errorCode;
        return businessException;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String[] getErrorMessageArguments() {
        return this.errorMessageArguments = errorMessageArguments;
    }

    public BusinessException withErrorMessageArguments(String... errorMessageArguments) {
        if(errorMessageArguments != null) {
            this.errorMessageArguments = errorMessageArguments;
        }

        return this;
    }

//    public APIResponse response() {
//        if (this.apiResponse != null) {
//            return this.apiResponse;
//        } else {
//            this.apiResponse = APIResponse.widthCode(this.getErrorCode());
//            if (this.getErrorMessageArguments() != null && this.getErrorMessageArguments().length > 0) {
//                try {
//                    this.apiResponse.setMsg(MessageFormat.format(this.apiResponse.getMsg(),this.getErrorMessageArguments()));
//                } catch (Exception var2) {
//                    LOGGER.error(var2.getMessage());
//                }
//            }
//            return this.apiResponse;
//        }
//    }



    /**
     * 该注解标识该方法可以用作异常处理,拦截Exception级别的异常信息
     * */
//    @ExceptionHandler(Exception.class)
//    public ModelAndView exceptionHandler(HttpServletRequest http, Exception e) {
//
//        ModelAndView modelAndView = new ModelAndView();
//
//        //记录日志
//        //会将,后的参数传递到{}中，顺序传递
//        LOGGER.error("请求路径：{}, 异常信息：{}", http.getRequestURI(), e);
//
//        modelAndView.addObject("url", http.getRequestURI());
//        modelAndView.addObject("exception", e);
//        //设置返回到哪个页面
//        modelAndView.setViewName("error/error");
//
//        return modelAndView;
//    }

}
