package com.tianhh.toy;

import com.tianhh.toy.content.content1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@SpringBootApplication
public class ToyApplication {
    public  static ConfigurableApplicationContext context=null;
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
         ToyApplication.context= SpringApplication.run(ToyApplication.class, args);
        Object o= getObj(content1.class);
        System.out.println(o!=null);
    }


    public static <T> Object getObj(Class<T> t,) throws InvocationTargetException, IllegalAccessException {
        for (Method method : t.getMethods()) {
            if(!method.isBridge())
                return method.invoke(context.getBean(content1.class),null);
        }
        return null;
    }
}
