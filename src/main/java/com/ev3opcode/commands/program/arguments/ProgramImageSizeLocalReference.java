package com.ev3opcode.commands.program.arguments;

import org.jetbrains.annotations.Contract;

import com.ev3opcode.common.arguments.ArgumentLocalReference;

public final class ProgramImageSizeLocalReference extends ArgumentLocalReference implements ProgramImageSize {
    private int m_offsetCached;

    public ProgramImageSizeLocalReference(int offset) {
        super(offset);
        m_offsetCached = offset;
    }

    @Contract(pure = true)
    public int getImageSizeOffset() {
        return m_offsetCached;
    }
}
