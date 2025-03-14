package com.ev3opcode.commands.output.arguments.returns;

import org.jetbrains.annotations.Contract;

import com.ev3opcode.common.tools.DataOptimizer;
import com.ev3opcode.common.types.LongLocalVariable16;
import com.ev3opcode.common.types.LongLocalVariable32;
import com.ev3opcode.common.types.LongLocalVariable8;
import com.ev3opcode.common.types.ShortLocalVariable;

public final class TachoCountDataLocalMemoryBlock extends TachoCountDataMemoryBlock {
    private int m_tachoCountDataOffsetCached;

    public TachoCountDataLocalMemoryBlock(int tachoCountDataOffset) {
        if (DataOptimizer.canBePackedIn5Bits(tachoCountDataOffset))
            super.m_tachoCountOffset = new ShortLocalVariable((byte) tachoCountDataOffset);
        else if (DataOptimizer.canBePackedIn8Bits(tachoCountDataOffset))
            super.m_tachoCountOffset = new LongLocalVariable8((byte) tachoCountDataOffset);
        else if (DataOptimizer.canBePackedIn16Bits(tachoCountDataOffset))
            super.m_tachoCountOffset = new LongLocalVariable16((short) tachoCountDataOffset);
        else
            super.m_tachoCountOffset = new LongLocalVariable32(tachoCountDataOffset);

        m_tachoCountDataOffsetCached = tachoCountDataOffset;
    }

    @Contract(pure = true)
    @Override
    public boolean isGlobal() {
        return false;
    }

    @Contract(pure = true)
    @Override
    public int getTachoCountOffset() {
        return m_tachoCountDataOffsetCached;
    }
}
