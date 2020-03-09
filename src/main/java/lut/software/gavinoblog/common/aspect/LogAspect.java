package lut.software.gavinoblog.common.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author ywg
 * @version 1.0
 * @description 日志切面类
 * @date 2020/3/7 10:40
 */
@Aspect
@Component
//@Slf4j
public class LogAspect {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* lut.software.gavinoblog.controller.*.*(..))")
    public void log(){}

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String url = request.getRequestURL().toString();
        String ip = request.getRemoteAddr();
        String classMethod = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        RequestLog requestLog = new RequestLog(url, ip ,classMethod, args);
        LOGGER.info("Request : {}", requestLog);
    }
    @After("log()")
    public void doAfter(){
        //log.info("--------doAfter--------");
    }
    @AfterReturning(returning = "result", pointcut = "log()")
    public void doAfterReturn(Object result){
        LOGGER.info("Result : {}", result);
    }

    /**
     *
     */
    private class RequestLog{
        private String url;
        private String ip;
        private String classMethod;
        private Object[] args;

        public RequestLog(String url, String ip, String classMethod, Object[] args) {
            this.url = url;
            this.ip = ip;
            this.classMethod = classMethod;
            this.args = args;
        }
        @Override
        public String toString() {
            return "{" +
                    "url='" + url + '\'' +
                    ", ip='" + ip + '\'' +
                    ", classMethod='" + classMethod + '\'' +
                    ", args=" + Arrays.toString(args) +
                    '}';
        }
    }
}