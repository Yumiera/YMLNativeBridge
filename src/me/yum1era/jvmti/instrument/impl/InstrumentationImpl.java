package me.yum1era.jvmti.instrument.impl;


import me.yum1era.jvmti.NativeAccess;
import me.yum1era.jvmti.instrument.ClassTransformer;
import me.yum1era.jvmti.instrument.Instrumentation;

public class InstrumentationImpl implements Instrumentation
{
    @Override
    public ClassTransformer[] getTransformers() {
        return NativeAccess.getTransformersAsArray();
    }

    @Override
    public native Class<?>[] getAllLoadedClasses();

    @Override
    public native void retransformClasses(Class<?>[] classes);

    @Override
    public native Class<?>[] getLoadedClasses(ClassLoader classLoader);

    @Override
    public native void setClassLoader(String classLoader);

    @Override
    public void addTransformer(final ClassTransformer classTransformer) {;
        NativeAccess.addTransformer(classTransformer);
    }
}