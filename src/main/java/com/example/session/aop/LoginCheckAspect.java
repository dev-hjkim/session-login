package com.example.session.aop;

import com.example.session.auth.model.User;
import com.example.session.exception.UserNotFoundException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@Aspect
@Component
public class LoginCheckAspect {

    @Around(value="@annotation(loginCheck)")
    public Object loginCheck(ProceedingJoinPoint pjp, LoginCheck loginCheck) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        User user = (User) request.getSession().getAttribute("user");

        if (user == null) {
            throw new UserNotFoundException();
        }

        Method method = MethodSignature.class.cast(pjp.getSignature()).getMethod();
        Object[] args = pjp.getArgs();
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        for (int i=0; i<args.length; i++) {
            for (Annotation parameterAnnotation : parameterAnnotations[i]) {
                if (parameterAnnotation.annotationType() == UserParam.class && method.getParameterTypes()[i] == User.class) {
                    args[i] = user;
                }
            }
        }

        return pjp.proceed(args);
    }
}
