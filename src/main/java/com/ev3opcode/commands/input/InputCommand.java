package com.ev3opcode.commands.input;

import com.ev3opcode.common.Command;

public abstract class InputCommand extends Command {
    @Override
    public Byte getOpCode() {
        return (byte) 0x99;
    }

    @Override
    public int getSize() {
        return 1;
    }
}
