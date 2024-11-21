package me.yum1era.jvmti.event.callbacks;

import java.security.ProtectionDomain;

public interface JvmtiEventClassFileLoadHook extends JvmtiEventCallback
{
    byte[] ClassFileLoadHook(
            Class<?> classBeingRedefined,
            ClassLoader loader,
            String name,
            ProtectionDomain protectionDomain,
            byte[] classData
    );
}
