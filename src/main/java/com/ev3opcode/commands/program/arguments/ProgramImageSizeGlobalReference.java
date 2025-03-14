package com.ev3opcode.commands.program.arguments;

import org.jetbrains.annotations.Contract;

import com.ev3opcode.common.arguments.ArgumentGlobalReference;

public final class ProgramImageSizeGlobalReference extends ArgumentGlobalReference implements ProgramImageSize {
    private int m_offsetCached;

    public ProgramImageSizeGlobalReference(int offset) {
        super(offset);
        m_offsetCached = offset;
    }

    @Contract(pure = true)
    public int getImageSizeOffset() {
        return m_offsetCached;
    }
}
