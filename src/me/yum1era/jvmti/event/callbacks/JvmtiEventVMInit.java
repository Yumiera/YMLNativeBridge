package me.yum1era.jvmti.event.callbacks;

public interface JvmtiEventVMInit extends JvmtiEventCallback
{
    void VMInit(Thread thread);
}
