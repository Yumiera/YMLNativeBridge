package me.yum1era.jvmti.utils;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Stack;

/**
 * @author hp888 on 11.11.2019.
 */

public  class JavaUtil
{
    private JavaUtil() {}

    public static boolean equals(final byte[] firstByteArray, final byte[] secondByteArray) {
        if (firstByteArray.length != secondByteArray.length)
            return false;

        for (int i = 0; i < firstByteArray.length; i++) {
            if (firstByteArray[i] != secondByteArray[i])
                return false;
        }

        return true;
    }

    static void printStacktrace(final Throwable throwable) {
        System.err.println("Exception: " + throwable.toString());
        Arrays.stream(throwable.getStackTrace()).forEach(stackTraceElement -> System.err.println(" at " + stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + " (" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ")"));

        final Stack<Throwable> throwableStack = new Stack<>();
        throwableStack.push(throwable.getCause());

        while (!throwableStack.empty()) {
            final Throwable newThrowable = throwableStack.pop();
            if (newThrowable.getCause() == null) {
                System.err.println("Exception: " + newThrowable.toString());
                Arrays.stream(throwable.getStackTrace()).forEach(stackTraceElement -> System.err.println(" at " + stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + " (" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ")"));
                break;
            }

            System.err.println("Exception: " + newThrowable.toString());
            Arrays.stream(throwable.getStackTrace()).forEach(stackTraceElement -> System.err.println("at " + stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + " (" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ")"));
        }
    }

    public static String getClassName(Class clazz){
     return clazz.getName().replaceAll("\\.", "/");
    }

    public static String getMethodSignature(Method method) {
        StringBuilder signature = new StringBuilder();

        // 添加参数类型
        Class<?>[] parameterTypes = method.getParameterTypes();
        signature.append("(");
        for (Class<?> paramType : parameterTypes) {
            signature.append(getTypeDescriptor(paramType));
        }
        signature.append(")");

        // 添加返回类型
        Class<?> returnType = method.getReturnType();
        signature.append(getTypeDescriptor(returnType));

        return signature.toString();
    }

    public static String getTypeDescriptor(Class<?> type) {
        if (type.isArray()) {
            return "[" + getTypeDescriptor(type.getComponentType());
        }
        switch (type.getSimpleName()) {
            case "void":
                return "V";
            case "boolean":
                return "Z";
            case "char":
                return "C";
            case "byte":
                return "B";
            case "short":
                return "S";
            case "int":
                return "I";
            case "long":
                return "J";
            case "float":
                return "F";
            case "double":
                return "D";
            default:
                return "L" + type.getName().replace('.', '/') + ";";
        }
    }
}