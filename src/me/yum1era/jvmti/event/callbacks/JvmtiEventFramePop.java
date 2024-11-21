package me.yum1era.jvmti.event.callbacks;

public interface JvmtiEventFramePop extends JvmtiEventCallback
{
    void FramePop(
            Thread thread,
            long method,
            boolean wasPoppedByException
    );
}
