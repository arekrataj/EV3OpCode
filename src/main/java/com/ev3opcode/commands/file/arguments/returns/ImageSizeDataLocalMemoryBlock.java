package com.ev3opcode.commands.file.arguments.returns;

import org.jetbrains.annotations.Contract;

import com.ev3opcode.common.tools.DataOptimizer;
import com.ev3opcode.common.types.LongLocalVariable16;
import com.ev3opcode.common.types.LongLocalVariable32;
import com.ev3opcode.common.types.LongLocalVariable8;
import com.ev3opcode.common.types.ShortLocalVariable;

public final class ImageSizeDataLocalMemoryBlock extends ImageSizeDataMemoryBlock {
    private int m_imageSizeDataOffsetCached;

    public ImageSizeDataLocalMemoryBlock(int imageSizeDataOffset) {
        if (DataOptimizer.canBePackedIn5Bits(imageSizeDataOffset))
            super.m_imageSizeDataOffset = new ShortLocalVariable((byte) imageSizeDataOffset);
        else if (DataOptimizer.canBePackedIn8Bits(imageSizeDataOffset))
            super.m_imageSizeDataOffset = new LongLocalVariable8((byte) imageSizeDataOffset);
        else if (DataOptimizer.canBePackedIn16Bits(imageSizeDataOffset))
            super.m_imageSizeDataOffset = new LongLocalVariable16((short) imageSizeDataOffset);
        else
            super.m_imageSizeDataOffset = new LongLocalVariable32(imageSizeDataOffset);

        m_imageSizeDataOffsetCached = imageSizeDataOffset;
    }

    @Contract(pure = true)
    @Override
    public boolean isGlobal() {
        return false;
    }

    @Contract(pure = true)
    @Override
    public int getImageSizeDataOffset() {
        return m_imageSizeDataOffsetCached;
    }
}
