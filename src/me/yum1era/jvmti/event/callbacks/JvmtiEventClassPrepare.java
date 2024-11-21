package me.yum1era.jvmti.event.callbacks;

public interface JvmtiEventClassPrepare extends JvmtiEventCallback
{
    void ClassPrepare(
            Thread thread,
            Class<?> klass
    );
}
