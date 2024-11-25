package me.yum1era.jvmti;

import me.yum1era.jvmti.instrument.ClassTransformer;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

import java.security.ProtectionDomain;
import java.util.HashSet;
import java.util.Set;
import java.util.function.BiConsumer;

import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;
import test.impl.TestTransformer;

public class YMLClassTransformer implements ClassTransformer, Opcodes {
    public static Set<String> classNameSet = new HashSet<String>();

    public static boolean needTransform(String string) {
        return classNameSet.contains(string);
    }

    private byte[] transformMethods(byte[] byArray, BiConsumer<ClassNode, MethodNode> biConsumer) {
        ClassReader classReader = new ClassReader(byArray);
        ClassNode classNode = new ClassNode();
        ClassWriter classWriter = new ClassWriter(0);
        try {
            classReader.accept(classNode, 0);
            classNode.methods.forEach(arg_0 -> YMLClassTransformer.transformMethods(biConsumer, classNode, arg_0));
            classNode.accept(classWriter);
        } catch (Throwable throwable) {
            // empty catch block
        }
        return classWriter.toByteArray();
    }

    public byte[] transform(String string, byte[] byArray) {
        try {

            switch (string) {
                case "test.Test":
                    return this.transformMethods(byArray, TestTransformer::transformTest);
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return byArray;
    }

    @Override
    public byte[] transform(ClassLoader classLoader, String string, Class<?> clazz, ProtectionDomain protectionDomain, byte[] byArray) {
        return this.transform(clazz.getName(), byArray);
    }

    private static void transformMethods(BiConsumer biConsumer, ClassNode classNode, MethodNode methodNode) {
        biConsumer.accept(classNode, methodNode);
    }

}


