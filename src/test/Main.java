package test;

import me.yum1era.jvmti.*;
import me.yum1era.jvmti.event.JvmtiEvent;
import me.yum1era.jvmti.event.JvmtiEventCallbacks;
import me.yum1era.jvmti.event.JvmtiEventMode;
import me.yum1era.jvmti.event.callbacks.JvmtiEventCallback;
import me.yum1era.jvmti.instrument.impl.InstrumentationImpl;
import me.yum1era.jvmti.utils.JavaUtil;
import test.impl.TestTransformer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.lang.reflect.Method;
import java.net.URL;
import java.util.Arrays;


public class Main {
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
        ClassLoader classLoader =   Main.class.getClassLoader();
        NativeAgent nativeAgent = new NativeAgent();
        nativeAgent.setClassLoader("AppClassLoader");
        nativeAgent.retransf0rm("test.Test");
        test.TransTest();
    }

}