package me.yum1era.jvmti.event.callbacks;

public interface JvmtiEventBreakpoint extends JvmtiEventCallback
{
    void Breakpoint(
            Thread thread,
            long method,
            long location
    );
}
