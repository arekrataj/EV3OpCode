package com.ev3opcode.commands.ui;

import com.ev3opcode.common.Command;

public abstract class UIDrawCommand extends Command {
    @Override
    public Byte getOpCode() {
        return (byte) 0x84;
    }

    @Override
    public int getSize() {
        return 1;
    }
}
