package me.yum1era.jvmti;

import java.util.Objects;

public class JvmtiClassDefinition {
    private final Class<?> target;
    private final byte[] data;
    public JvmtiClassDefinition(Class<?> target, byte[] data) {
        this.target = Objects.requireNonNull(target);
        this.data = Objects.requireNonNull(data);
    }

    public Class<?> getTarget() {
        return target;
    }

    public byte[] getData() {
        return data;
    }



}
