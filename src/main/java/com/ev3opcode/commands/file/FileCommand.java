package com.ev3opcode.commands.file;

import com.ev3opcode.common.Command;

public abstract class FileCommand extends Command {
    @Override
    public Byte getOpCode() {
        return (byte) 0xC0;
    }

    @Override
    public int getSize() {
        return 1;
    }
}
