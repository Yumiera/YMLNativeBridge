package me.yum1era.jvmti.event.callbacks;

public interface JvmtiEventExceptionCatch extends JvmtiEventCallback
{
    void ExceptionCatch(
            Thread thread,
            long method,
            long location,
            Throwable exception
    );
}
