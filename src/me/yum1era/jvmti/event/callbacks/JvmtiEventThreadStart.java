package me.yum1era.jvmti.event.callbacks;

public interface JvmtiEventThreadStart extends JvmtiEventCallback
{
    void ThreadStart(Thread thread);
}
