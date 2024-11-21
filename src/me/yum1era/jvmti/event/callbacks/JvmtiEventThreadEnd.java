package me.yum1era.jvmti.event.callbacks;

public interface JvmtiEventThreadEnd extends JvmtiEventCallback
{
    void ThreadEnd(Thread thread);
}
