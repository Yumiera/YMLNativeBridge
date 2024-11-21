package me.yum1era.jvmti.event.callbacks;

public interface JvmtiEventMethodExit extends JvmtiEventCallback
{
    void MethodExit(
            Thread thread,
            long method,
            boolean wasPoppedByException,
            Object returnValue
    );
}
