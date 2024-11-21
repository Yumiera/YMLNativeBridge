package me.yum1era.jvmti.event.callbacks;

public interface JvmtiEventSingleStep extends JvmtiEventCallback
{
    void SingleStep(
            Thread thread,
            long method,
            long location
    );
}
