package me.yum1era.jvmti.event.callbacks;

public interface JvmtiEventClassLoad extends JvmtiEventCallback
{
    void ClassLoad(
            Thread thread,
            Class<?> klass
    );
}
