package com.ev3opcode.commands.file.arguments.returns;

import org.jetbrains.annotations.NotNull;

import com.ev3opcode.common.returns.ReturnedDataMemoryBlock;
import com.ev3opcode.common.types.DataType;

public abstract class ImageAddressDataMemoryBlock implements ReturnedDataMemoryBlock {
    DataType<?> m_imageAddressDataOffset;

    public abstract int getImageAddressDataOffset();

    @Override
    public int getSize() {
        return m_imageAddressDataOffset.getSize();
    }

    @NotNull
    @Override
    public Byte[] getBytes() {
        return m_imageAddressDataOffset.getBytes();
    }
}
