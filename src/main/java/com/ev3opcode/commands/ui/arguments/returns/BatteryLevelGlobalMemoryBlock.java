package com.ev3opcode.commands.ui.arguments.returns;

import org.jetbrains.annotations.Contract;

import com.ev3opcode.common.tools.DataOptimizer;
import com.ev3opcode.common.types.LongGlobalVariable16;
import com.ev3opcode.common.types.LongGlobalVariable32;
import com.ev3opcode.common.types.LongGlobalVariable8;
import com.ev3opcode.common.types.ShortGlobalVariable;

public final class BatteryLevelGlobalMemoryBlock extends BatteryLevelMemoryBlock {
    private int m_batteryLevelOffsetCached;

    public BatteryLevelGlobalMemoryBlock(int batteryLevelOffset) {
        if (DataOptimizer.canBePackedIn5Bits(batteryLevelOffset))
            super.m_batteryLevelOffset = new ShortGlobalVariable((byte) batteryLevelOffset);
        else if (DataOptimizer.canBePackedIn8Bits(batteryLevelOffset))
            super.m_batteryLevelOffset = new LongGlobalVariable8((byte) batteryLevelOffset);
        else if (DataOptimizer.canBePackedIn16Bits(batteryLevelOffset))
            super.m_batteryLevelOffset = new LongGlobalVariable16((short) batteryLevelOffset);
        else
            super.m_batteryLevelOffset = new LongGlobalVariable32(batteryLevelOffset);

        m_batteryLevelOffsetCached = batteryLevelOffset;
    }

    @Contract(pure = true)
    @Override
    public boolean isGlobal() {
        return true;
    }

    @Contract(pure = true)
    @Override
    public int getBatteryLevelOffset() {
        return m_batteryLevelOffsetCached;
    }
}
