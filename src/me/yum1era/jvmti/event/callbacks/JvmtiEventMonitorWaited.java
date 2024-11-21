package me.yum1era.jvmti.event.callbacks;

public interface JvmtiEventMonitorWaited extends JvmtiEventCallback
{
    void MonitorWaited(
            Thread thread,
            Object object,
            boolean timed_out
    );
}
