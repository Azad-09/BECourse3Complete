package com.example.mongoRest.Sprint4BE.aspects;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.util.Arrays;


@Aspect
@Component
public class LoggingAspect {
    static final Logger logger = (Logger) LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("execution (* com.example.mongoRest.Sprint4BE.controller.ProductController.*(..))")
    public void controllerMethods(){}


    @Before("controllerMethods()")
    public void beforeAdvise(JoinPoint joinPoint){
        logger.info("--------------@Before-------------");
        logger.debug("Method Name{}", joinPoint.getSignature().getName());
        logger.debug("Method Args{}", Arrays.toString(joinPoint.getArgs()));
        logger.info("------------------------------------");
    }

    @After("controllerMethods()")
    public void afterAdvise(JoinPoint joinPoint){
        logger.info("-----------------@After----------");
        logger.debug("Method Name{}" , joinPoint.getSignature().getName());
        logger.debug("Methodd Args{}", Arrays.toString(joinPoint.getArgs()));
        logger.info("-----------------------------------");

    }

    @AfterReturning(value = "controllerMethods()",returning = "result")
    public void afterReturningAdvice(JoinPoint joinPoint,Object result)
    {
        logger.info("-------------@After Returning-------------");
        logger.debug("Method Name {}",joinPoint.getSignature().getName());
        logger.debug("Method Args {}", Arrays.toString(joinPoint.getArgs()));
        logger.debug("Returning Value", result);
        logger.info("----------------------------------------");
    }

    @AfterThrowing(value = "controllerMethods()",throwing = "error")
    public void afterThrowingAdvice(JoinPoint joinPoint,Throwable error)
    {
        logger.info("-------------@After Returning-------------");
        logger.debug("Method Name {}",joinPoint.getSignature().getName());
        logger.debug("Method Args {}", Arrays.toString(joinPoint.getArgs()));
        logger.debug("Exception", error);
        logger.info("----------------------------------------");
    }
}
