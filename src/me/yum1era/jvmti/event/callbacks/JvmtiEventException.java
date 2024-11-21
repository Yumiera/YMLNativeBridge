package me.yum1era.jvmti.event.callbacks;

public interface JvmtiEventException extends JvmtiEventCallback
{
    void Exception(
            Thread thread,
            long method,
            long location,
            Throwable exception,
            long catchMethod,
            long catchLocation
    );
}
