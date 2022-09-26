//package com.example.session.aop;
//
//import com.example.session.auth.model.User;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpServletRequest;
//
//@Aspect
//@Component
//public class LoginCheckAspect {
//
//    @Around(value="@annotation(loginCheck)")
//    public Object loginCheck(ProceedingJoinPoint pjp, LoginCheck loginCheck) throws Throwable {
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        User user = (User) request.getSession().getAttribute("user");
//
//        return pjp.proceed();
//    }
//}
