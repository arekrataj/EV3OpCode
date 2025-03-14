package com.ev3opcode.commands.file.arguments.returns;

import org.jetbrains.annotations.NotNull;

import com.ev3opcode.common.returns.ReturnedDataMemoryBlock;
import com.ev3opcode.common.types.DataType;

public abstract class ImageSizeDataMemoryBlock implements ReturnedDataMemoryBlock {
    DataType<?> m_imageSizeDataOffset;

    public abstract int getImageSizeDataOffset();

    @Override
    public int getSize() {
        return m_imageSizeDataOffset.getSize();
    }

    @NotNull
    @Override
    public Byte[] getBytes() {
        return m_imageSizeDataOffset.getBytes();
    }
}
