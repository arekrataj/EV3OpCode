package com.ev3opcode.commands.file.arguments.returns;

import org.jetbrains.annotations.Contract;

import com.ev3opcode.common.tools.DataOptimizer;
import com.ev3opcode.common.types.LongGlobalVariable16;
import com.ev3opcode.common.types.LongGlobalVariable32;
import com.ev3opcode.common.types.LongGlobalVariable8;
import com.ev3opcode.common.types.ShortGlobalVariable;

public final class ImageAddressDataGlobalMemoryBlock extends ImageAddressDataMemoryBlock {
    private int m_imageAddressDataOffsetCached;

    public ImageAddressDataGlobalMemoryBlock(int imageAddressDataOffset) {
        if (DataOptimizer.canBePackedIn5Bits(imageAddressDataOffset))
            super.m_imageAddressDataOffset = new ShortGlobalVariable((byte) imageAddressDataOffset);
        else if (DataOptimizer.canBePackedIn8Bits(imageAddressDataOffset))
            super.m_imageAddressDataOffset = new LongGlobalVariable8((byte) imageAddressDataOffset);
        else if (DataOptimizer.canBePackedIn16Bits(imageAddressDataOffset))
            super.m_imageAddressDataOffset = new LongGlobalVariable16((short) imageAddressDataOffset);
        else
            super.m_imageAddressDataOffset = new LongGlobalVariable32(imageAddressDataOffset);

        m_imageAddressDataOffsetCached = imageAddressDataOffset;
    }

    @Contract(pure = true)
    @Override
    public boolean isGlobal() {
        return true;
    }

    @Contract(pure = true)
    @Override
    public int getImageAddressDataOffset() {
        return m_imageAddressDataOffsetCached;
    }
}
