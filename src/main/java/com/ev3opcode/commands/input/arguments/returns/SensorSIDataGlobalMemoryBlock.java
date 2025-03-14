package com.ev3opcode.commands.input.arguments.returns;

import org.jetbrains.annotations.Contract;

import com.ev3opcode.common.tools.DataOptimizer;
import com.ev3opcode.common.types.LongGlobalVariable16;
import com.ev3opcode.common.types.LongGlobalVariable32;
import com.ev3opcode.common.types.LongGlobalVariable8;
import com.ev3opcode.common.types.ShortGlobalVariable;

public final class SensorSIDataGlobalMemoryBlock extends SensorSIDataMemoryBlock {
    private int m_sensorValuesOffsetCached;

    public SensorSIDataGlobalMemoryBlock(int sensorValuesOffset) {
        if (DataOptimizer.canBePackedIn5Bits(sensorValuesOffset))
            super.m_sensorValuesOffset = new ShortGlobalVariable((byte) sensorValuesOffset);
        else if (DataOptimizer.canBePackedIn8Bits(sensorValuesOffset))
            super.m_sensorValuesOffset = new LongGlobalVariable8((byte) sensorValuesOffset);
        else if (DataOptimizer.canBePackedIn16Bits(sensorValuesOffset))
            super.m_sensorValuesOffset = new LongGlobalVariable16((short) sensorValuesOffset);
        else
            super.m_sensorValuesOffset = new LongGlobalVariable32(sensorValuesOffset);

        m_sensorValuesOffsetCached = sensorValuesOffset;
    }

    @Contract(pure = true)
    @Override
    public boolean isGlobal() {
        return true;
    }

    @Contract(pure = true)
    @Override
    public int getSensorValuesOffset() {
        return m_sensorValuesOffsetCached;
    }
}
