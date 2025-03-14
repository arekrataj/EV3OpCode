package com.ev3opcode.commands.sound;

import com.ev3opcode.common.Command;

public abstract class SoundCommand extends Command {
    @Override
    public Byte getOpCode() {
        return (byte) 0x94;
    }

    @Override
    public int getSize() {
        return 1;
    }
}
