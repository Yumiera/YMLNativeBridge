package me.yum1era.jvmti.instrument;


public interface Instrumentation
{
    Class<?>[] getAllLoadedClasses();

    ClassTransformer[] getTransformers();

    void retransformClasses(final Class<?>[] classes);

    Class<?>[] getLoadedClasses(final ClassLoader classLoader);

    void addTransformer(final ClassTransformer classTransformer);
}