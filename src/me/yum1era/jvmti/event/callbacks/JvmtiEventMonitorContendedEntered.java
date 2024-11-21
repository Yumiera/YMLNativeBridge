package me.yum1era.jvmti.event.callbacks;

public interface JvmtiEventMonitorContendedEntered extends JvmtiEventCallback
{
    void MonitorContendedEntered(
            Thread thread,
            Object object
    );
}
