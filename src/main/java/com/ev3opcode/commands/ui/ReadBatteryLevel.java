package com.ev3opcode.commands.ui;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;

import com.ev3opcode.commands.ui.arguments.returns.BatteryLevelMemoryBlock;
import com.ev3opcode.common.ResponseBuffer;

public final class ReadBatteryLevel extends UIReadCommand {
    private static byte OPCODE = 0x12;

    private BatteryLevelMemoryBlock m_batteryLevelMemoryBlock;

    public final class ReturnedValues {
        private int m_batteryLevel;

        private ReturnedValues(@NotNull ResponseBuffer responseBuffer) {
            Byte[] batteryLevelByte = responseBuffer.read(m_batteryLevelMemoryBlock.getBatteryLevelOffset(), 1);

            m_batteryLevel = batteryLevelByte[0];
        }

        @Contract(pure = true)
        public int getBatteryLevel() {
            return m_batteryLevel;
        }
    }

    public ReadBatteryLevel(BatteryLevelMemoryBlock batteryLevelMemoryBlock) {
        m_batteryLevelMemoryBlock = batteryLevelMemoryBlock;
    }

    @Contract(pure = true)
    @Override
    public Byte getOpCode() {
        return OPCODE;
    }

    @Contract(pure = true)
    @Override
    public int allocatedGlobalBlockSize() {
        if (m_batteryLevelMemoryBlock.isGlobal())
            return 1; // for two 1-byte global variables
        return 0;
    }

    @Contract(pure = true)
    @Override
    public int allocatedLocalBlockSize() {
        if (!m_batteryLevelMemoryBlock.isGlobal())
            return 1; // for two 1-byte global variables
        return 0;
    }

    @Override
    public int getSize() {
        int thisSize = super.getSize() + 1;
        int returnedDataMemoryBlockSize = m_batteryLevelMemoryBlock.getSize();

        return thisSize + returnedDataMemoryBlockSize;
    }

    @NotNull
    @Override
    public Byte[] getBytes() {
        ArrayList<Byte> outputBytes = new ArrayList<>();

        outputBytes.add(super.getOpCode());
        outputBytes.add(this.getOpCode());
        outputBytes.addAll(Arrays.asList(m_batteryLevelMemoryBlock.getBytes()));

        return outputBytes.toArray(new Byte[0]);
    }

    @NotNull
    @Contract("_ -> new")
    public ReturnedValues getReturnedValues(ResponseBuffer responseBuffer) {
        return new ReturnedValues(responseBuffer);
    }
}
