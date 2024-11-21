package me.yum1era.jvmti.event;

import java.util.Arrays;

public enum JvmtiEventMode {

    JVMTI_ENABLE(1),
    JVMTI_DISABLE(0);

    private final int id;

    JvmtiEventMode(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static JvmtiEventMode getById(int id) {
        return Arrays.stream(values())
                .filter(em -> em.getId() == id)
                .findAny().orElse(null);
    }

}
