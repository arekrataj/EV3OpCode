package com.ev3opcode.commands.input.arguments.returns;

import org.jetbrains.annotations.Contract;

import com.ev3opcode.common.tools.DataOptimizer;
import com.ev3opcode.common.types.LongLocalVariable16;
import com.ev3opcode.common.types.LongLocalVariable32;
import com.ev3opcode.common.types.LongLocalVariable8;
import com.ev3opcode.common.types.ShortLocalVariable;

public final class SensorSIDataLocalMemoryBlock extends SensorSIDataMemoryBlock {
    private int m_sensorValuesOffsetCached;

    public SensorSIDataLocalMemoryBlock(int sensorValuesOffset) {
        if (DataOptimizer.canBePackedIn5Bits(sensorValuesOffset))
            super.m_sensorValuesOffset = new ShortLocalVariable((byte) sensorValuesOffset);
        else if (DataOptimizer.canBePackedIn8Bits(sensorValuesOffset))
            super.m_sensorValuesOffset = new LongLocalVariable8((byte) sensorValuesOffset);
        else if (DataOptimizer.canBePackedIn16Bits(sensorValuesOffset))
            super.m_sensorValuesOffset = new LongLocalVariable16((short) sensorValuesOffset);
        else
            super.m_sensorValuesOffset = new LongLocalVariable32(sensorValuesOffset);

        m_sensorValuesOffsetCached = sensorValuesOffset;
    }

    @Contract(pure = true)
    @Override
    public boolean isGlobal() {
        return false;
    }

    @Contract(pure = true)
    @Override
    public int getSensorValuesOffset() {
        return m_sensorValuesOffsetCached;
    }
}
