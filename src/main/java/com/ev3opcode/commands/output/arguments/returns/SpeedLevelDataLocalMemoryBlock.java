package com.ev3opcode.commands.output.arguments.returns;

import org.jetbrains.annotations.Contract;

import com.ev3opcode.common.tools.DataOptimizer;
import com.ev3opcode.common.types.LongLocalVariable8;
import com.ev3opcode.common.types.ShortLocalVariable;

public final class SpeedLevelDataLocalMemoryBlock extends SpeedLevelDataMemoryBlock {
    private int m_speedLevelOffsetCached;

    public SpeedLevelDataLocalMemoryBlock(int speedLevelDataOffset) {
        if (DataOptimizer.canBePackedIn5Bits(speedLevelDataOffset))
            super.m_speedLevelOffset = new ShortLocalVariable((byte) speedLevelDataOffset);
        else if (DataOptimizer.canBePackedIn8Bits(speedLevelDataOffset))
            super.m_speedLevelOffset = new LongLocalVariable8((byte) speedLevelDataOffset);

        m_speedLevelOffsetCached = speedLevelDataOffset;
    }

    @Contract(pure = true)
    @Override
    public boolean isGlobal() {
        return false;
    }

    @Contract(pure = true)
    @Override
    public int getSpeedLevelOffset() {
        return m_speedLevelOffsetCached;
    }
}
