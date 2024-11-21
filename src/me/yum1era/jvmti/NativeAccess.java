package me.yum1era.jvmti;



import me.yum1era.jvmti.instrument.ClassTransformer;
import me.yum1era.jvmti.utils.JavaUtil;

import java.security.ProtectionDomain;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public class NativeAccess {

    private static final Set<ClassTransformer> transformers = new HashSet<>();

    private static ClassTransformer[] transformersArray;
    private static boolean modified;

    private NativeAccess() {}

    public static void addTransformer(final ClassTransformer classTransformer) {
        transformers.add(classTransformer);
        modified = true;
    }

    public static byte[] transformClass(final ClassLoader loader, final String className, final Class<?> classBeingRedefined, final ProtectionDomain protectionDomain, final byte[] classfileBuffer) {
        if (classBeingRedefined == null)
            return classfileBuffer;

        final AtomicReference<byte[]> atomicReference = new AtomicReference<>();
        transformers.forEach(classTransformer -> {
            final byte[] newByteArray = classTransformer.transform(loader, className, classBeingRedefined, protectionDomain, classfileBuffer);
            if (Objects.isNull(atomicReference.get())) {
                atomicReference.set(newByteArray);
                return;
            }

            if (JavaUtil.equals(atomicReference.get(), newByteArray))
                return;

            atomicReference.set(newByteArray);
        });

        return atomicReference.get();
    }

    public static ClassTransformer[] getTransformersAsArray() {
        if (modified) {
            modified = false;
            transformersArray = transformers.toArray(new ClassTransformer[0]);
            return transformersArray;
        }

        return transformersArray == null
                ? transformersArray = transformers.toArray(new ClassTransformer[0])
                : transformersArray;
    }


}
