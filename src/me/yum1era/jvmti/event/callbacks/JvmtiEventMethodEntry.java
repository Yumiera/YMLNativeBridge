package me.yum1era.jvmti.event.callbacks;

public interface JvmtiEventMethodEntry extends JvmtiEventCallback
{
    void MethodEntry(
            Thread thread,
            long method
    );
}
