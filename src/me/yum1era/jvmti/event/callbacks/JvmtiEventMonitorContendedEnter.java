package me.yum1era.jvmti.event.callbacks;

public interface JvmtiEventMonitorContendedEnter extends JvmtiEventCallback
{
    void MonitorContendedEnter(
            Thread thread,
            Object object
    );
}
