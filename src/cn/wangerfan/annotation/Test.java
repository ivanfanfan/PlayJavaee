package cn.wangerfan.annotation;

/**
 * 注解解析
 */
@Pro(className = "cn.wangerfan.annotation.Demo1",methodName = "show1")
public class Test {

    public static void main(String[] args) {
        //获取该类的字节码文件
        Class<Test> testClass = Test.class;
        //获取注解的字节码对象
        Pro an = testClass.getAnnotation(Pro.class);
        //获取抽象方法
        String s = an.className();
        String s1 = an.methodName();
        System.out.println(s+"--------"+s1);
    }

}
