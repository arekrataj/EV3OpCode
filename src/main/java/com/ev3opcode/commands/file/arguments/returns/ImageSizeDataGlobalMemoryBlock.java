package com.ev3opcode.commands.file.arguments.returns;

import org.jetbrains.annotations.Contract;

import com.ev3opcode.common.tools.DataOptimizer;
import com.ev3opcode.common.types.LongGlobalVariable16;
import com.ev3opcode.common.types.LongGlobalVariable32;
import com.ev3opcode.common.types.LongGlobalVariable8;
import com.ev3opcode.common.types.ShortGlobalVariable;

public final class ImageSizeDataGlobalMemoryBlock extends ImageSizeDataMemoryBlock {
    private int m_imageSizeDataOffsetCached;

    public ImageSizeDataGlobalMemoryBlock(int imageSizeDataOffset) {
        if (DataOptimizer.canBePackedIn5Bits(imageSizeDataOffset))
            super.m_imageSizeDataOffset = new ShortGlobalVariable((byte) imageSizeDataOffset);
        else if (DataOptimizer.canBePackedIn8Bits(imageSizeDataOffset))
            super.m_imageSizeDataOffset = new LongGlobalVariable8((byte) imageSizeDataOffset);
        else if (DataOptimizer.canBePackedIn16Bits(imageSizeDataOffset))
            super.m_imageSizeDataOffset = new LongGlobalVariable16((short) imageSizeDataOffset);
        else
            super.m_imageSizeDataOffset = new LongGlobalVariable32(imageSizeDataOffset);

        m_imageSizeDataOffsetCached = imageSizeDataOffset;
    }

    @Contract(pure = true)
    @Override
    public boolean isGlobal() {
        return true;
    }

    @Contract(pure = true)
    @Override
    public int getImageSizeDataOffset() {
        return m_imageSizeDataOffsetCached;
    }
}
