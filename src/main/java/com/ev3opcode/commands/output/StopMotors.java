package com.ev3opcode.commands.output;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import com.ev3opcode.common.Command;

public final class StopMotors extends Command {
    private static byte OPCODE = (byte) 0xB4;

    public StopMotors() {
    }

    @Contract(pure = true)
    @Override
    public Byte getOpCode() {
        return OPCODE;
    }

    @Contract(pure = true)
    @Override
    public int allocatedGlobalBlockSize() {
        return 0;
    }

    @Contract(pure = true)
    @Override
    public int allocatedLocalBlockSize() {
        return 0;
    }

    @Contract(pure = true)
    @Override
    public int getSize() {
        return 1; // 1 byte op-code
    }

    @NotNull
    @Contract(value = " -> new", pure = true)
    @Override
    public Byte[] getBytes() {
        return new Byte[] { OPCODE };
    }
}
