package test;

import me.yum1era.jvmti.*;


public class Demo1 {
    static {
        System.load("F:\\YMLDev\\YMLNativeBridge\\x64\\Release\\YMLNativeBridge.dll");
    }
    public static void main(String[] args) throws NoSuchMethodException, InterruptedException {
       /* NativeRegister nativeRegister = new NativeRegister();

        Method method = JvmtiEnv.class.getMethod("GetCurrentThread");
        String method_signature = JavaUtil.getMethodSignature(method);
        nativeRegister.register(JavaUtil.getClassName(JvmtiEnv.class),method.getName(),method_signature,"native"+method.getName());
        System.out.println(method.getName());
        System.out.println(method_signature);
        System.out.println(JvmtiEnv.GetCurrentThread());*/
        Test test = new Test();
        test.TransTest();
        ClassLoader classLoader =   Demo1.class.getClassLoader();
        NativeAgent nativeAgent = new NativeAgent();
        nativeAgent.setClassLoader("AppClassLoader");
        nativeAgent.retransf0rm("test.Test");
        test.TransTest();
    }

}