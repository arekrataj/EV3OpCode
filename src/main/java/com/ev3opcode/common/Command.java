package com.ev3opcode.common;

public abstract class Command implements ByteCode {
    public abstract Byte getOpCode();

    public abstract int allocatedGlobalBlockSize();

    public abstract int allocatedLocalBlockSize();
}
