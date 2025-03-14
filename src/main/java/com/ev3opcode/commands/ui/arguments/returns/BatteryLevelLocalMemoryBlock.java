package com.ev3opcode.commands.ui.arguments.returns;

import org.jetbrains.annotations.Contract;

import com.ev3opcode.common.tools.DataOptimizer;
import com.ev3opcode.common.types.LongLocalVariable16;
import com.ev3opcode.common.types.LongLocalVariable32;
import com.ev3opcode.common.types.LongLocalVariable8;
import com.ev3opcode.common.types.ShortLocalVariable;

public final class BatteryLevelLocalMemoryBlock extends BatteryLevelMemoryBlock {
    private int m_batteryLevelOffsetCached;

    public BatteryLevelLocalMemoryBlock(int batteryLevelOffset) {
        if (DataOptimizer.canBePackedIn5Bits(batteryLevelOffset))
            super.m_batteryLevelOffset = new ShortLocalVariable((byte) batteryLevelOffset);
        else if (DataOptimizer.canBePackedIn8Bits(batteryLevelOffset))
            super.m_batteryLevelOffset = new LongLocalVariable8((byte) batteryLevelOffset);
        else if (DataOptimizer.canBePackedIn16Bits(batteryLevelOffset))
            super.m_batteryLevelOffset = new LongLocalVariable16((short) batteryLevelOffset);
        else
            super.m_batteryLevelOffset = new LongLocalVariable32(batteryLevelOffset);

        m_batteryLevelOffsetCached = batteryLevelOffset;
    }

    @Contract(pure = true)
    @Override
    public boolean isGlobal() {
        return false;
    }

    @Contract(pure = true)
    @Override
    public int getBatteryLevelOffset() {
        return m_batteryLevelOffsetCached;
    }
}
