package com.ev3opcode.commands.output.arguments.returns;

import org.jetbrains.annotations.Contract;

import com.ev3opcode.common.tools.DataOptimizer;
import com.ev3opcode.common.types.LongGlobalVariable16;
import com.ev3opcode.common.types.LongGlobalVariable32;
import com.ev3opcode.common.types.LongGlobalVariable8;
import com.ev3opcode.common.types.ShortGlobalVariable;

public final class TachoCountDataGlobalMemoryBlock extends TachoCountDataMemoryBlock {
    private int m_tachoCountDataOffsetCached;

    public TachoCountDataGlobalMemoryBlock(int tachoCountDataOffset) {
        if (DataOptimizer.canBePackedIn5Bits(tachoCountDataOffset))
            super.m_tachoCountOffset = new ShortGlobalVariable((byte) tachoCountDataOffset);
        else if (DataOptimizer.canBePackedIn8Bits(tachoCountDataOffset))
            super.m_tachoCountOffset = new LongGlobalVariable8((byte) tachoCountDataOffset);
        else if (DataOptimizer.canBePackedIn16Bits(tachoCountDataOffset))
            super.m_tachoCountOffset = new LongGlobalVariable16((short) tachoCountDataOffset);
        else
            super.m_tachoCountOffset = new LongGlobalVariable32(tachoCountDataOffset);

        m_tachoCountDataOffsetCached = tachoCountDataOffset;
    }

    @Contract(pure = true)
    @Override
    public boolean isGlobal() {
        return true;
    }

    @Contract(pure = true)
    @Override
    public int getTachoCountOffset() {
        return m_tachoCountDataOffsetCached;
    }
}
