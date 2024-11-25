package test;

import me.yum1era.jvmti.JvmtiCapabilities;
import me.yum1era.jvmti.JvmtiEnv;
import me.yum1era.jvmti.NativeAgent;
import me.yum1era.jvmti.event.JvmtiEvent;
import me.yum1era.jvmti.event.JvmtiEventCallbacks;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;

import static me.yum1era.jvmti.utils.JvmtiUtils.newCallback;

public class Demo2 {

    public static void main(String[] args) {

        JvmtiEnv.loadDll();
        NativeAgent nativeAgent = new NativeAgent();
        Test test = new Test();
        test.TransTest();

        JvmtiCapabilities capab = new JvmtiCapabilities();
        capab.can_retransform_classes = true;
        capab.can_retransform_any_class = true;
        JvmtiEnv.AddCapabilities(capab);


        JvmtiEventCallbacks callb = new JvmtiEventCallbacks();
        callb.ClassFileLoadHook = newCallback((classBeingRedefined, loader, name, protectionDomain, classData) -> {
            if (name != null && name.equals("test/Test")) {
               // return transformClass(classData);
                return transformClass(nativeAgent.ymlClassTransformer.transform(name,classData));
            }


            return null;
        }, JvmtiEvent.JVMTI_EVENT_CLASS_FILE_LOAD_HOOK);
        JvmtiEnv.SetEventCallbacks(callb);


        System.out.println("Loaded classes count: "
                + JvmtiEnv.GetLoadedClasses().length);
        System.out.println("Loaded classes count (Classloader): "
                + JvmtiEnv.GetClassLoaderClasses(Demo2.class.getClassLoader()).length);

        try {
            JvmtiEnv.RetransformClasses(new Class<?>[] { test.Test.class });
        } catch (Exception e) {
            e.printStackTrace();
        }

        test.TransTest();
    }

    public static byte[] transformClass(byte[] classData) {
        ClassReader cr = new ClassReader(classData);
        ClassNode classNode = new ClassNode();
        cr.accept(classNode, 0);

        // 修改 TransTest 方法
        for (MethodNode methodNode : classNode.methods) {
            if (methodNode.name.equals("TransTest")) {
                // 插入新的指令
                methodNode.instructions.insert(new MethodInsnNode(
                        Opcodes.INVOKESTATIC,
                        Type.getInternalName(test.impl.TestTransformer.class),
                        "HookTest",
                        "()V",
                        false
                ));
            }
        }

        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        classNode.accept(cw);
        return cw.toByteArray();
    }
}