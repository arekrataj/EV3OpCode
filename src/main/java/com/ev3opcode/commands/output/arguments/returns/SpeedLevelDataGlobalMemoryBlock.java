package com.ev3opcode.commands.output.arguments.returns;

import org.jetbrains.annotations.Contract;

import com.ev3opcode.common.tools.DataOptimizer;
import com.ev3opcode.common.types.LongGlobalVariable8;
import com.ev3opcode.common.types.ShortGlobalVariable;

public final class SpeedLevelDataGlobalMemoryBlock extends SpeedLevelDataMemoryBlock {
    private int m_speedLevelOffsetCached;

    public SpeedLevelDataGlobalMemoryBlock(int speedLevelDataOffset) {
        if (DataOptimizer.canBePackedIn5Bits(speedLevelDataOffset))
            super.m_speedLevelOffset = new ShortGlobalVariable((byte) speedLevelDataOffset);
        else if (DataOptimizer.canBePackedIn8Bits(speedLevelDataOffset))
            super.m_speedLevelOffset = new LongGlobalVariable8((byte) speedLevelDataOffset);

        m_speedLevelOffsetCached = speedLevelDataOffset;
    }

    @Contract(pure = true)
    @Override
    public boolean isGlobal() {
        return true;
    }

    @Contract(pure = true)
    @Override
    public int getSpeedLevelOffset() {
        return m_speedLevelOffsetCached;
    }
}
