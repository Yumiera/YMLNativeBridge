package me.yum1era.jvmti.event.callbacks;

public interface JvmtiEventVMObjectAlloc extends JvmtiEventCallback
{
    void VMObjectAlloc(
            Thread thread,
            Object object,
            Class<?> object_klass,
            long size
    );
}
