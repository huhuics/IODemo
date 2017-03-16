/**
 * 深圳金融电子结算中心
 * Copyright (c) 1995-2017 All Rights Reserved.
 */
package cn.io.anno;

import java.lang.reflect.Method;

/**
 * 
 * @author HuHui
 * @version $Id: MyAnnotWorker.java, v 0.1 2017年3月16日 上午1:16:01 HuHui Exp $
 */
public class MyAnnotWorker {

    public static void main(String[] args) throws Exception {

        Class<Student> object = Student.class;

        Method[] methods = object.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(MyAnnotation.class)) {
                MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
                System.out.println("name = " + annotation.name());
                System.out.println("age = " + annotation.age());
                System.out.println("newNames = " + annotation.newNames().length);
                method.invoke(object.newInstance(), annotation.age(), annotation.name());
            }
        }

    }

}
