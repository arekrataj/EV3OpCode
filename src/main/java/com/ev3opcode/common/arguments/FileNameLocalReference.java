package com.ev3opcode.common.arguments;

import org.jetbrains.annotations.Contract;

public final class FileNameLocalReference extends ArgumentLocalReference implements FileName {
    private int m_offsetCached;

    public FileNameLocalReference(int offset) {
        super(offset);
        m_offsetCached = offset;
    }

    @Contract(pure = true)
    public int getNameOffset() {
        return m_offsetCached;
    }
}
