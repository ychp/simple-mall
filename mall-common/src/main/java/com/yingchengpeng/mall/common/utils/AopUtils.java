package com.yingchengpeng.mall.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;

import javax.validation.ConstraintViolation;
import java.lang.reflect.Method;
import java.util.Set;

/**
 * @author yingchengpeng
 * @date 2022-07-30
 */
@Slf4j
public class AopUtils {

    public static Method getMethod(ProceedingJoinPoint pjp) {
        Signature sig = pjp.getSignature();
        if (!(sig instanceof MethodSignature)) {
            log.error("getMethod encounter error, unSupport signature:{}", sig.getName());
            return null;
        }
        MethodSignature msig = (MethodSignature) sig;
        Object target = pjp.getTarget();

        Method currentMethod = null;
        try {
            currentMethod = target.getClass().getMethod(msig.getName(), msig.getParameterTypes());
        } catch (NoSuchMethodException e) {
            log.error("getMethod encounter error, NoSuchMethodException {}", sig.getName(), e);
        }
        return currentMethod;
    }

    public static String buildErrorDisplayMsg(Set<ConstraintViolation<?>> constraintSet) {

        if (constraintSet != null && !constraintSet.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            constraintSet.forEach(c -> sb.append(c.getMessage()).append(","));
            return sb.deleteCharAt(sb.length() - 1).toString();
        } else {
            return "";
        }
    }

}
