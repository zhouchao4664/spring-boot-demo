package com.zhouchao.config.aop;

/**
 * @Author zhouchao
 * @Date 2021/4/23 18:00
 * @Description
 **/

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhouchao.utils.NetworkUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

@Aspect
@Order(5)
@Component
public class ControllerAspect {

    @Autowired
    private ObjectMapper mapper;

    private static final Logger logger = LogManager.getLogger(ControllerAspect.class);

    ThreadLocal<Long> startTime = new ThreadLocal<Long>();

    @Pointcut("execution(public * com.zhouchao.controller..*.*(..))")
    public void cutPoint() {

    }

    @Before("cutPoint()")
    public void doBefore(JoinPoint joinPoint){
        startTime.set(System.currentTimeMillis());

        try {
            ServletRequestAttributes attribute = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attribute.getRequest();
            Enumeration<String> enums = request.getParameterNames();
            List<String> params = new ArrayList<>();

            while(enums.hasMoreElements()) {
                String paramName = enums.nextElement();
                String param = paramName + ":" + request.getParameter(paramName);
                params.add(param);

            }

            logger.info("URL: {},Method: {},Params: {},IP: {},Device: {}",request.getRequestURL().toString(),request.getMethod(),params.toString(),NetworkUtils.getClientIp(request),request.getHeader("User-Agent").toLowerCase());
            //logger.info("Class Method: {},Args: {}", joinPoint.getSignature().getDeclaringTypeName()+ "." + joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
            Object[] args = joinPoint.getArgs();
            String arg = "";
            for (int i = 0;i< args.length;i++){
                Object arg1 = args[i];
                if( arg1 instanceof ServletResponse){
                    args[i] = "";
                }
            }
            logger.info("Class Method: {},Args: {}", joinPoint.getSignature().getDeclaringTypeName()+ "." + joinPoint.getSignature().getName(), mapper.writeValueAsString(joinPoint.getArgs()));
        } catch (JsonProcessingException e) {
            logger.error(e);
        }


    }


    @AfterReturning(returning="ret",pointcut="cutPoint()")
    public void doAfterReturning(Object ret)  {

        try {
            logger.info("REPONSE: {}", mapper.writeValueAsString(ret));
            logger.info("SPEND TIME:{} ms",System.currentTimeMillis() - startTime.get());
        } catch (JsonProcessingException e) {
            logger.error(e);
        }finally{
            startTime.remove();
        }
    }

}
