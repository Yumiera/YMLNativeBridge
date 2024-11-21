package me.yum1era.jvmti.event.callbacks;

public interface JvmtiEventFieldAccess extends JvmtiEventCallback
{
    void FieldAccess(
            Thread thread,
            long method,
            long location,
            Class<?> fieldKlass,
            Object object,
            long field
    );
}
