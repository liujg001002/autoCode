package com.yintu.supply.interceptor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Configuration
public class CommonInterceptor implements HandlerInterceptor {
	private static final Logger LOGGER = LoggerFactory.getLogger(CommonInterceptor.class);

	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	/**
	 * 在请求处理之前进行调用（Controller方法调用之前）
	 * 
	 * @param request
	 * @param response
	 * @param handler
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
//	    // IP限流 在线Demo所需 一秒限10个请求
//        String token1 = redisRaterLimiter.acquireTokenFromBucket(ipInfoUtil.getIpAddr(request), 10, 1000);
//        if (StrUtil.isBlank(token1)) {
//            throw new XbootException("你手速怎么这么快，请点慢一点");
//        }
//
//        if(rateLimitEnable){
//            String token2 = redisRaterLimiter.acquireTokenFromBucket(CommonConstant.LIMIT_ALL, limit, timeout);
//            if (StrUtil.isBlank(token2)) {
//                throw new XbootException("当前访问总人数太多啦，请稍后再试");
//            }
//        }
//
//        try {
//            HandlerMethod handlerMethod = (HandlerMethod) handler;
//            Method method = handlerMethod.getMethod();
//            RateLimiter rateLimiter = method.getAnnotation(RateLimiter.class);
//            if (rateLimiter != null) {
//                int limit = rateLimiter.limit();
//                int timeout = rateLimiter.timeout();
//                String token3 = redisRaterLimiter.acquireTokenFromBucket(method.getName(), limit, timeout);
//                if (StrUtil.isBlank(token3)) {
//                    throw new XbootException("当前访问人数太多啦，请稍后再试");
//                }
//            }
//        }catch (Exception e){
//
//        }
		
		LOGGER.debug("=========preHandle  begin==========");
		LOGGER.debug("IP : " + getIpAddr(request));
		LOGGER.debug("ServerName : " + request.getServerName());
		LOGGER.debug("Port : " + request.getServerPort());
		LOGGER.debug("ContextPath : " + request.getContextPath());
		LOGGER.debug("ServletPath : " + request.getServletPath());
		LOGGER.debug("QueryString : " + request.getQueryString());
		LOGGER.debug("RequestBody : " + inputstream2String2(request.getInputStream()));
		LOGGER.debug("=========preHandle    end==========");
		return true;
	}

	/**
	 * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
	 * 
	 * @param request
	 * @param response
	 * @param handler
	 * @param modelAndView
	 * @throws Exception
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	/**
	 * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
	 * 
	 * @param request
	 * @param response
	 * @param handler
	 * @param ex
	 * @throws Exception
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		HandlerMethod h = (HandlerMethod) handler;
		LOGGER.debug("=========afterCompletion  begin==========");
		LOGGER.debug("Contreoller : " + h.getBean().getClass().getName());
		LOGGER.debug("MethodName : " + h.getMethod().getName());
		LOGGER.debug("=========afterCompletion    end==========\n\n");
	}
	
	public String inputstream2String (InputStream is) throws IOException {
		StringBuilder sb = new StringBuilder();
		String line;

		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		while ((line = br.readLine()) != null) {
		    sb.append(line);
		}
		String str = sb.toString();
		return str;
	}
	
	public String inputstream2String2 (InputStream is) throws IOException {
		return IOUtils.toString(is);
	}
}
