/**
 * 深圳金融电子结算中心
 * Copyright (c) 1995-2017 All Rights Reserved.
 */
package cn.io.anno;

/**
 * 
 * @author HuHui
 * @version $Id: Student.java, v 0.1 2017年3月16日 上午12:56:41 HuHui Exp $
 */
public class Student {

    @MyAnnotation(age = 19, name = "huhui", newNames = { "hu", "hui" })
    public void setProps(int age, String name) {
        System.out.println("student age=" + age + ", name= " + name);
    }

}
