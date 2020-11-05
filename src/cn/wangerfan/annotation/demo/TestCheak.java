package cn.wangerfan.annotation.demo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import java.lang.reflect.Method;

public class TestCheak {
    public static void main(String[] args) throws IOException {

        //获取测试类对象
        Calculator c = new Calculator();
        //获取字节码文件对象
        Class cls = c.getClass();
        //获取所有方法
        Method[] methods = cls.getMethods();
        int number = 0;//定义异常出现的次数
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("bug.txt"));
        for (Method method:methods) {
            //判断方法上是否有相应的注解
            if(method.isAnnotationPresent(Check.class)){
                //如果有就执行
                try {
                    method.invoke(c);
                } catch (Exception e) {
                    //捕获异常
                    number ++;
                    String simpleName = e.getClass().getSimpleName();
                    bufferedWriter.write(method.getName()+"方法出异常了");
                    bufferedWriter.newLine();
                    bufferedWriter.write("异常名称"+simpleName);
                    bufferedWriter.newLine();
                    bufferedWriter.write("异常原因"+e.getCause().getMessage());
                    bufferedWriter.newLine();
                    bufferedWriter.write("---------------");

                }
            }
        }
        bufferedWriter.write("本次一共出现"+number+"次异常");
        bufferedWriter.flush();
        bufferedWriter.close();

    }
}
