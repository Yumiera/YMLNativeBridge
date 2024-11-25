package me.yum1era.jvmti;

import me.yum1era.jvmti.instrument.ClassTransformer;
import me.yum1era.jvmti.instrument.Instrumentation;
import me.yum1era.jvmti.instrument.impl.InstrumentationImpl;
import me.yum1era.jvmti.utils.Reflections;

import java.util.Arrays;

public class NativeAgent {
    public YMLClassTransformer ymlClassTransformer;
    public InstrumentationImpl instrumentation_impl;
    public NativeAgent(){
        ymlClassTransformer = new YMLClassTransformer();
        instrumentation_impl = new InstrumentationImpl();
    }
    public void retransformclass(Instrumentation instrumentation, ClassTransformer classTransformer, String string) {
        Reflections.load();
        instrumentation.addTransformer(classTransformer);
        instrumentation.retransformClasses((Class[]) Arrays.stream(instrumentation.getAllLoadedClasses()).filter(arg_0 -> NativeAgent.retransformclass(string, arg_0)).toArray(NativeAgent::retransformclass));
    }

    private static Class[] retransformclass(int n) {
        return new Class[n];
    }

    private static boolean retransformclass(String string, Class clazz) {
        return clazz.getName().startsWith(string);
    }

    public void retransf0rm(String className){
       this.retransformclass(instrumentation_impl,ymlClassTransformer,className);
    }

    public Class[] getAllLoadedClasses(){
       return instrumentation_impl.getAllLoadedClasses();
    }

    public Class[] getLoadedClasses(ClassLoader classLoader){
        return instrumentation_impl.getLoadedClasses(classLoader);
    }

    public void setClassLoader(String classLoader)
    {
        instrumentation_impl.setClassLoader(classLoader);
    }
}
