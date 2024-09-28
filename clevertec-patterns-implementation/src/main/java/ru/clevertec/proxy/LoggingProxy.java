package ru.clevertec.proxy;

import ru.clevertec.proxy.annotation.Log;

import java.lang.reflect.Method;

public class LoggingProxy {

    private final Object target;

    public LoggingProxy(Object target) {
        this.target = target;
    }

    public void invoke(Object... args) throws Exception{

        Method[] methods = target.getClass().getMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Log.class)) {
                System.out.println("Starting method: " + method.getDeclaringClass().getSimpleName() + "." + method.getName());
                method.invoke(target, args);
                System.out.println("Finished method: " + method.getDeclaringClass().getSimpleName() + "." + method.getName());
            }
        }
    }
}
