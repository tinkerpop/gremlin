package com.tinkerpop.gremlin.groovy.util

import groovyjarjarasm.asm.ClassReader
import org.codehaus.groovy.runtime.GeneratedClosure

import java.lang.instrument.ClassFileTransformer
import java.lang.instrument.IllegalClassFormatException
import java.lang.instrument.UnmodifiableClassException
import java.security.ProtectionDomain

/**
 * @author Stephen Mallette (http://stephen.genoprime.com)
 */
class ClosureTransformer implements ClassFileTransformer {
    private static volatile ClosureTransformer instance = null
    private static final Object lock = new Object()

    protected final Map<Class<?>, byte[]> classToByteCode = Collections.synchronizedMap(new WeakHashMap<Class<?>, byte[]>())
    protected final Map<String, Class<?>> nameToClass = new HashMap<String, Class<?>>()
    protected final Map<String, Class<?>> resourceNameToClass = new HashMap<String, Class<?>>()
    protected final Map<String, ClosureClass> nameToDeferredClass = new HashMap<String, ClosureClass>()

    public static final String generatedClosureName = GeneratedClosure.class.getName().replace('.', '/')

    public static ClosureTransformer getInstance() {
        if(instance==null) {
            synchronized(lock) {
                if(instance==null) {
                    instance = new ClosureTransformer()
                }
            }
        }
        return instance
    }

    ClosureTransformer() {
        ClosureAgent.instrumentation.addTransformer(this, true)
    }

    @Override
    public byte[] transform(java.lang.ClassLoader classLoader, java.lang.String className,
                            java.lang.Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        byte[] bytecode = classfileBuffer
        if(classBeingRedefined == null) {
            if(classLoader instanceof GroovyClassLoader && isGeneratedClosure(bytecode)) {
                put(className, classLoader, bytecode)
            }
        } else {
            if(GeneratedClosure.class.isAssignableFrom(classBeingRedefined)) {
                put(classBeingRedefined, bytecode)
            }
        }
        return bytecode
    }

    public void put(Class<?> clazz, byte[] bytecode) {
        classToByteCode.put(clazz, bytecode)
        nameToClass.put(clazz.getName(), clazz)
        resourceNameToClass.put(clazz.getName().replace('.', '/') + ".class", clazz)
    }

    public void put(String className, ClassLoader classLoader, byte[] bytecode) {
        final ClosureClass dc = ClosureClass.newInstance(classLoader, className, bytecode)
        nameToDeferredClass.put(className, dc)
    }

    public byte[] getByteCode(String className) {
        byte[] bytecode
        Class<?> clazz = nameToClass.get(className)
        if(clazz==null) {
            bytecode = getDeferredByteCode(className, null)
        } else {
            bytecode = classToByteCode.get(clazz)
            if(bytecode==null) {
                bytecode = getDeferredByteCode(className, clazz)
            }
        }
        return bytecode
    }

    protected byte[] getDeferredByteCode(String className, Class<?> clazz) {
        byte[] bytecode = null
        ClosureClass dc = nameToDeferredClass.get(className)
        if(dc==null && clazz != null) {
            try {
                ClosureAgent.instrumentation.retransformClasses(clazz)
            } catch (UnmodifiableClassException e) {
            }
        }
        if(dc!=null) {
            bytecode = dc.getBytecode()
            synchronized(dc) {
                if(nameToDeferredClass.containsKey(className)) {
                    try {
                        Class<?> cl = Class.forName(className, true, dc.getClassLoader())
                        put(cl, dc.getBytecode())
                        nameToDeferredClass.remove(className)
                    } catch (Exception e) {}
                }
            }
        }
        return bytecode

    }

    public byte[] getByteCodeFromResource(String className) {
        byte[] bytecode  = null
        Class<?> clazz = resourceNameToClass.get(className)
        if(clazz==null) {
            bytecode = getDeferredByteCode(className.replace('/', '.').replace(".class", ""), null)
        } else {
            bytecode = classToByteCode.get(clazz)
        }
        return bytecode
    }

    public byte[] getByteCode(Class<?> clazz) {
        byte[] bytecode  = null
        bytecode = classToByteCode.get(clazz)
        if(bytecode==null) {
            bytecode = getByteCode(clazz.getName())
            if(bytecode==null) {
                try {
                    ClosureAgent.instrumentation.retransformClasses(clazz)
                    bytecode = classToByteCode.get(clazz)
                } catch (UnmodifiableClassException e) {
                }
            }
        }
        return bytecode
    }

    protected boolean isGeneratedClosure(byte[] bytecode) {
        try {
            for(String iface: new ClassReader(bytecode).getInterfaces()) {
                if(generatedClosureName.equals(iface)) return true
            }
            return false
        } catch (Exception e) {
            return false
        }
    }
}