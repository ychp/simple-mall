package com.yingchengpeng.mall.common.aspect;

import com.alibaba.fastjson.JSON;
import com.yingchengpeng.mall.common.exception.BusinessException;
import com.yingchengpeng.mall.common.exception.DependencyException;
import com.yingchengpeng.mall.common.exception.SystemException;
import com.yingchengpeng.mall.common.exception.code.MallErrorCode;
import com.yingchengpeng.mall.common.utils.AopUtils;
import com.yingchengpeng.mall.gateway.rpc.dto.response.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

/**
 * 异常处理
 *
 * @author yingchengpeng
 * @date 2022-07-30
 */
@Slf4j
@Aspect
@Order(1)
@Component
public class ApiExceptionAndLogAspect {

    /**
     * 切rpc接口
     */
    @Pointcut("execution(public * com.yingchengpeng.mall..gateway.rpc.service.impl.*.*(..))")
    public void apiPointcut() {
    }

    @Around(value = "apiPointcut()")
    public Object process(ProceedingJoinPoint joinPoint) {

        Object result = null;
        String methodName = getMethod(joinPoint);
        Class<?> returnType = getReturnType(joinPoint);
        long startTime = System.currentTimeMillis();

        Object[] parameters = joinPoint.getArgs();

        try {
            // 设置请求的唯一key，方便日志的grep
            result = joinPoint.proceed();
        } catch (BusinessException be) {
            log.info("method = {}, parameters = {}, exception = {}", methodName, JSON.toJSON(parameters), be);
            result = createFailResult(be.getCode(), be.getMessage(), returnType);
        } catch (DependencyException de) {
            result = processDependencyException(de, methodName, parameters, returnType);
        } catch (SystemException e) {
            log.error("method = {}, parameters = {}, exception = {}", methodName, JSON.toJSON(parameters), e);
            result = createFailResult(e.getCode(), e.getMessage(), returnType);
        } catch (IllegalArgumentException ie) {
            log.warn("method = {}, parameters = {}, exception = {}", methodName, JSON.toJSON(parameters), ie);
            result = createFailResult(MallErrorCode.PARAMETER_ERROR.getCode(), ie.getMessage(), returnType);
        } catch (ConstraintViolationException e) {
            result = processConstraintViolationException(e, methodName, parameters, returnType);
        } catch (Throwable ex) {
            log.error("method = {}, parameters = {}, exception = {}", methodName, JSON.toJSON(parameters), ex);
            result = createFailResult(
                    MallErrorCode.OTHER_ERROR_CODE.getCode(), MallErrorCode.OTHER_ERROR_CODE.getMessage(), returnType);
        } finally {
            long costTime = System.currentTimeMillis() - startTime;
            log.info("method = {}, parameters = {}, result = {}, cost_time = {} ms",
                    methodName, JSON.toJSON(parameters), JSON.toJSON(result), costTime);
        }

        return result;
    }


    private Object processDependencyException(DependencyException de, String methodName, Object[] parameters, Class<?> returnType) {
        Map<String, Object> attachments = de.getAttachments();
        if (attachments != null) {
            log.error("({}){}, request={}, rpcInterface={}, rpcParams={}, rpcResult={}, case {}",
                    methodName,
                    attachments.get(DependencyException.RPC_FUNCTION),
                    JSON.toJSON(parameters),
                    attachments.get(DependencyException.RPC_INTERFACE),
                    attachments.get(DependencyException.RPC_PARAM),
                    attachments.get(DependencyException.RPC_RESULT), de);
        }
        return createFailResult(de.getCode(), de.getMessage(), returnType);
    }

    private Object processConstraintViolationException(ConstraintViolationException e, String methodName, Object[] parameters, Class<?> returnType) {
        log.error("method = {}, parameters = {}, exception = {}", methodName, JSON.toJSON(parameters), e);
        Set<ConstraintViolation<?>> errors = e.getConstraintViolations();
        String message = "参数错误 : " + AopUtils.buildErrorDisplayMsg(errors);
        return createFailResult(MallErrorCode.PARAMETER_ERROR.getCode(), message, returnType);
    }

    private String getMethod(ProceedingJoinPoint joinPoint) {
        Method method = AopUtils.getMethod(joinPoint);
        return String.format("%s#%s", joinPoint.getTarget().getClass().getSimpleName(), method == null ? "" : method.getName());
    }

    private Class<?> getReturnType(ProceedingJoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        return ((MethodSignature) signature).getReturnType();
    }


    public static <T> T createFailResult(int errorCode, String message, Class<T> returnClass) {
        if (returnClass.isAssignableFrom(BaseResult.class)) {
            BaseResult result = new BaseResult(errorCode, message);
            return (T) result;
        }
        return null;
    }

}


