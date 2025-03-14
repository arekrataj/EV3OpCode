package com.ev3opcode.common.arguments;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class FileNameValue extends ArgumentValue implements FileName {
    private String m_nameCached;

    public FileNameValue(String name) {
        setName(name);
    }

    @Contract(pure = true)
    @NotNull
    public String getName() {
        return m_nameCached;
    }

    public void setName(String name) {
        super.setValue(name);
        m_nameCached = name;
    }
}
