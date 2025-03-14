package com.ev3opcode.commands.ui.arguments.returns;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;

import com.ev3opcode.common.returns.ReturnedDataMemoryBlock;
import com.ev3opcode.common.types.DataType;

public abstract class BatteryLevelMemoryBlock implements ReturnedDataMemoryBlock {
    DataType<?> m_batteryLevelOffset;

    public abstract int getBatteryLevelOffset();

    @Override
    public int getSize() {
        return m_batteryLevelOffset.getSize();
    }

    @NotNull
    @Override
    public Byte[] getBytes() {
        ArrayList<Byte> outputBytes = new ArrayList<>();

        outputBytes.addAll(Arrays.asList(m_batteryLevelOffset.getBytes()));

        return outputBytes.toArray(new Byte[0]);
    }
}
