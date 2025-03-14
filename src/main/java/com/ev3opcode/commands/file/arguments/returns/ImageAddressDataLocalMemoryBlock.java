package com.ev3opcode.commands.file.arguments.returns;

import org.jetbrains.annotations.Contract;

import com.ev3opcode.common.tools.DataOptimizer;
import com.ev3opcode.common.types.LongLocalVariable16;
import com.ev3opcode.common.types.LongLocalVariable32;
import com.ev3opcode.common.types.LongLocalVariable8;
import com.ev3opcode.common.types.ShortLocalVariable;

public final class ImageAddressDataLocalMemoryBlock extends ImageAddressDataMemoryBlock {
    private int m_imageAddressDataOffsetCached;

    public ImageAddressDataLocalMemoryBlock(int imageAddressDataOffset) {
        if (DataOptimizer.canBePackedIn5Bits(imageAddressDataOffset))
            super.m_imageAddressDataOffset = new ShortLocalVariable((byte) imageAddressDataOffset);
        else if (DataOptimizer.canBePackedIn8Bits(imageAddressDataOffset))
            super.m_imageAddressDataOffset = new LongLocalVariable8((byte) imageAddressDataOffset);
        else if (DataOptimizer.canBePackedIn16Bits(imageAddressDataOffset))
            super.m_imageAddressDataOffset = new LongLocalVariable16((short) imageAddressDataOffset);
        else
            super.m_imageAddressDataOffset = new LongLocalVariable32(imageAddressDataOffset);

        m_imageAddressDataOffsetCached = imageAddressDataOffset;
    }

    @Contract(pure = true)
    @Override
    public boolean isGlobal() {
        return false;
    }

    @Contract(pure = true)
    @Override
    public int getImageAddressDataOffset() {
        return m_imageAddressDataOffsetCached;
    }
}
