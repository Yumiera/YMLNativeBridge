package me.yum1era.jvmti.utils;

import me.yum1era.jvmti.JvmtiEnv;
import me.yum1era.jvmti.JvmtiError;
import me.yum1era.jvmti.event.JvmtiEvent;
import me.yum1era.jvmti.event.JvmtiEventMode;
import me.yum1era.jvmti.event.callbacks.JvmtiEventCallback;

import static me.yum1era.jvmti.JvmtiError.JVMTI_ERROR_NONE;
import static me.yum1era.jvmti.JvmtiError.JVMTI_ERROR_NOT_AVAILABLE;


public class JvmtiUtils {

    public static native void setupEnv();

    public static <T extends JvmtiEventCallback> T newCallback(T callb, JvmtiEvent event) {
        JvmtiError err = JvmtiEnv.SetEventNotificationMode(JvmtiEventMode.JVMTI_ENABLE, event, null);
        if (JVMTI_ERROR_NONE.equals(err)) {
        } else if (JVMTI_ERROR_NOT_AVAILABLE.equals(err)) {
            System.err.println("Event not available (Maybe debug mode fixes it?)");
        } else {
            System.err.println("Couldn't enable event: " + err);
        }
        return callb;
    }
}
