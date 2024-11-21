package me.yum1era.jvmti;

import me.yum1era.jvmti.event.JvmtiEvent;
import me.yum1era.jvmti.event.JvmtiEventCallbacks;
import me.yum1era.jvmti.event.JvmtiEventMode;

public class JvmtiEnv {
    private JvmtiEnv() {
    }

    // Threading
    public static native Thread GetCurrentThread();

    public static native Thread[] GetAllThreads();

    public static native JvmtiError SuspendThread(Thread thread);

    public static native JvmtiError ResumeThread(Thread thread);

    public static native JvmtiError StopThread(Thread thread, Throwable t);

    public static native JvmtiError InterruptThread(Thread thread);
    // Threading

    // Capabilities
    public static native JvmtiError AddCapabilities(JvmtiCapabilities capabilities);

    public static native JvmtiError RelinquishCapabilities(JvmtiCapabilities capabilities);

    public static native JvmtiCapabilities GetCapabilities();
    // Capabilities

    // Instrumentation
    public static native Class<?>[] GetLoadedClasses();

    public static native Class<?>[] GetClassLoaderClasses(ClassLoader classLoader);

   // public static native Class GetClassLoader();

    public static native JvmtiError RetransformClasses(Class<?>[] classes);

    public static native JvmtiError RedefineClasses(JvmtiClassDefinition[] classDefinitions);
    // Instrumentation

    // Event
    public static native JvmtiError SetEventCallbacks(JvmtiEventCallbacks callbacks);

    public static native JvmtiError SetEventNotificationMode(JvmtiEventMode mode, JvmtiEvent type, Thread thread);
    // Event

    /*static {
        try(InputStream inputStream = JvmtiEnv.class.getResourceAsStream("/jvmtiCpp.dll")) {
            if(inputStream == null) throw new IOException("jvmtiCpp.dll not found!");

            File file = File.createTempFile("jvmtiCpp", ".dll");
            try(FileOutputStream outputStream = new FileOutputStream(file)) {
                byte[] tmp = new byte[1024];

                int read;
                while((read = inputStream.read(tmp)) != -1)
                    outputStream.write(tmp, 0, read);
            }
            file.deleteOnExit();

            System.load(file.getAbsolutePath());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}
