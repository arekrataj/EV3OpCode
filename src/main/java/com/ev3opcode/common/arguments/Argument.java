package com.ev3opcode.common.arguments;

import com.ev3opcode.common.ByteCode;
import com.ev3opcode.common.types.DataType;

public abstract class Argument implements ByteCode {
    DataType<?> m_dataType;

    @Override
    public int getSize() {
        return m_dataType.getSize();
    }

    @Override
    public Byte[] getBytes() {
        return m_dataType.getBytes();
    }
}
