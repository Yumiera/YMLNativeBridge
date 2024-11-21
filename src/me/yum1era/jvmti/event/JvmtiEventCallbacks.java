package me.yum1era.jvmti.event;

import me.yum1era.jvmti.event.callbacks.*;

public class JvmtiEventCallbacks
{

    public JvmtiEventVMInit VMInit;
    public JvmtiEventVMDeath VMDeath;
    public JvmtiEventThreadStart ThreadStart;
    public JvmtiEventThreadEnd ThreadEnd;
    public JvmtiEventClassFileLoadHook ClassFileLoadHook;
    public JvmtiEventClassLoad ClassLoad;
    public JvmtiEventClassPrepare ClassPrepare;
    public JvmtiEventVMStart VMStart;
    public JvmtiEventException Exception;
    public JvmtiEventExceptionCatch ExceptionCatch;
    public JvmtiEventSingleStep SingleStep;
    public JvmtiEventFramePop FramePop;
    public JvmtiEventBreakpoint Breakpoint;
    public JvmtiEventFieldAccess FieldAccess;
    public JvmtiEventFieldModification FieldModification;
    public JvmtiEventMethodEntry MethodEntry;
    public JvmtiEventMethodExit MethodExit;

    public JvmtiEventMonitorWait MonitorWait;
    public JvmtiEventMonitorWaited MonitorWaited;
    public JvmtiEventMonitorContendedEnter MonitorContendedEnter;
    public JvmtiEventMonitorContendedEntered MonitorContendedEntered;

    public JvmtiEventVMObjectAlloc VMObjectAlloc;

}
