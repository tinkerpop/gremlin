package com.tinkerpop.gremlin.groovy.util

/**
 * @author Stephen Mallette (http://stephen.genoprime.com)
 */
class ClosureClass {
    private final ClassLoader classLoader
    private final String className
    private final byte[] bytecode

public static ClosureClass newInstance(ClassLoader classLoader, String className, byte[] bytecode) {
        return new ClosureClass(classLoader, className, bytecode)
    }

    private ClosureClass(ClassLoader classLoader, String className, byte[] bytecode) {
        this.classLoader = classLoader
        this.className = className
        this.bytecode = bytecode
    }

    public ClassLoader getClassLoader() {
        return classLoader
    }

    public String getClassName() {
        return className
    }

    public byte[] getBytecode() {
        return bytecode
    }

    public String toString() {
        final String TAB = "\n\t"
        StringBuilder retValue = new StringBuilder()
        retValue.append("ClosureClass [")
                .append(TAB).append("classLoader:").append(this.classLoader)
                .append(TAB).append("className:").append(this.className)
                .append(TAB).append("bytecode:").append(this.bytecode.length)
                .append("\n]")
        return retValue.toString()
    }

    @Override
    public int hashCode() {
        final int prime = 31
        int result = 1
        result = prime * result
        + ((className == null) ? 0 : className.hashCode())
        return result
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true
        if (obj == null)
            return false
        if (getClass() != obj.getClass())
            return false
        ClosureClass other = (ClosureClass) obj
        if (className == null) {
            if (other.className != null)
                return false
        } else if (!className.equals(other.className))
            return false
        return true
    }



}