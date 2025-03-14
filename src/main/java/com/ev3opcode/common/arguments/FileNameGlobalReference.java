package com.ev3opcode.common.arguments;

import org.jetbrains.annotations.Contract;

public final class FileNameGlobalReference extends ArgumentGlobalReference implements FileName {
    private int m_offsetCached;

    public FileNameGlobalReference(int offset) {
        super(offset);
        m_offsetCached = offset;
    }

    @Contract(pure = true)
    public int getNameOffset() {
        return m_offsetCached;
    }
}
