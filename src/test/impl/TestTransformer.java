package test.impl;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.*;

public class TestTransformer implements Opcodes {
    public static void transformTest(ClassNode classNode, MethodNode methodNode) {
        if (methodNode.name.equalsIgnoreCase("TransTest")) {
            methodNode.instructions.insert(new MethodInsnNode(Opcodes.INVOKESTATIC,
                    Type.getInternalName(TestTransformer.class),"HookTest", "()V", false));
        }
    }
    public static void HookTest() {
        System.out.println("Hooked Test!");
    }

}
