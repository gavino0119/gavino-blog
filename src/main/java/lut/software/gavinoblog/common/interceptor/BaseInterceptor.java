package lut.software.gavinoblog.common.interceptor;

import lut.software.gavinoblog.common.constant.Types;
import lut.software.gavinoblog.common.constant.WebConst;
import lut.software.gavinoblog.common.utils.*;
import lut.software.gavinoblog.pojo.User;
import lut.software.gavinoblog.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ywg
 * @version 1.0
 * @description 自定义拦截器
 * @date 2020/3/10 9:52
 */
@Component
public class BaseInterceptor implements HandlerInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseInterceptor.class);
    private static final String USER_AGENT = "User-Agent";

    @Autowired
    private UserService userService;

    @Autowired
    private Commons commons;

    @Autowired
    private HttpSession session;


    private MapCache cache = MapCache.single();


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {

        // 请求URL不包含域名
        String uri = request.getRequestURI();
        // 日志输出
        LOGGER.info("UserAgent：{}", request.getHeader(USER_AGENT));
        LOGGER.info("用户访问地址：{}，来路地址：{}",uri, IPKit.getIpAddressByRequest1(request));

        // 请求拦截处理
        User user = TaleUtils.getLoginUser(request);
        if (null == user) {
            Integer uid = TaleUtils.getCookieUid(request);
            if (null != uid) {
                //这里还是有安全隐患,cookie是可以伪造的
                user = userService.getUserInfoById(uid);
                request.getSession().setAttribute(WebConst.LOGIN_SESSION_KEY, user);
            }
        }

        if (uri.startsWith("/admin") && !uri.startsWith("/admin/login") && null == user
                && !uri.startsWith("/admin/css") && !uri.startsWith("/admin/images")
                && !uri.startsWith("/admin/js") && !uri.startsWith("/admin/plugins")
                && !uri.startsWith("/admin/editormd")) {
            response.sendRedirect(request.getContextPath() + "/admin/login");
            return false;
        }

        // 设置GET请求的token
        if (request.getMethod().equals("GET")) {
            String csrf_token = UUID.UU64();
            // 默认存储30分钟
            cache.hset(Types.CSRF_TOKEN.getType(), csrf_token, uri,30 * 60);
            request.setAttribute("_csrf_token", csrf_token);
        }
        // 返回true才会执行postHandle
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView view) throws Exception {

        request.setAttribute("commons", commons);

    }

}
