package com.ev3opcode.common.types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.ev3opcode.common.ByteCode;

public abstract class DataType<T> implements ByteCode {
    private List<Byte> m_bytesBuffer = new ArrayList<>();

    protected T m_value;

    protected Byte[] getFilledByteBuffer(Byte flags, Byte... followingBytes) {
        m_bytesBuffer.clear();
        m_bytesBuffer.add(flags);
        Collections.addAll(m_bytesBuffer, followingBytes);

        return m_bytesBuffer.toArray(new Byte[0]);
    }

    public T getValue() {
        return m_value;
    }
}
