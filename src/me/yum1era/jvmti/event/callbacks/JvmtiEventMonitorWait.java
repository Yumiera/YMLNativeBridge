package me.yum1era.jvmti.event.callbacks;

public interface JvmtiEventMonitorWait extends JvmtiEventCallback
{
    void MonitorWait(
            Thread thread,
            Object object,
            long timeout
    );
}
