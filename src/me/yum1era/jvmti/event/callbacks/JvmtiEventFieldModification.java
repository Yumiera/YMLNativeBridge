package me.yum1era.jvmti.event.callbacks;

public interface JvmtiEventFieldModification extends JvmtiEventCallback
{
    void FieldModification(
            Thread thread,
            long method,
            long location,
            Class<?> fieldKlass,
            Object object,
            long field,
            char signatureType,
            Object newValue
    );
}
