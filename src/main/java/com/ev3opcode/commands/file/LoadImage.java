package com.ev3opcode.commands.file;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;

import com.ev3opcode.commands.file.arguments.returns.ImageAddressDataMemoryBlock;
import com.ev3opcode.commands.file.arguments.returns.ImageSizeDataMemoryBlock;
import com.ev3opcode.commands.program.arguments.ProgramId;
import com.ev3opcode.common.ResponseBuffer;
import com.ev3opcode.common.arguments.FileName;
import com.ev3opcode.common.tools.BinaryConverter;

public final class LoadImage extends FileCommand
{
    private static byte OPCODE = 0x8;

    private ProgramId m_programId;
    private FileName m_nameArgument;
    private ImageSizeDataMemoryBlock m_imageSizeDataMemoryBlock;
    private ImageAddressDataMemoryBlock m_imageAddressDataMemoryBlock;

    public final class ReturnedValues
    {
        private int m_imageSize, m_imageAddress;

        private ReturnedValues(@NotNull ResponseBuffer responseBuffer)
        {
            Byte[] imageSizeBytes = responseBuffer.read(m_imageSizeDataMemoryBlock.getImageSizeDataOffset(), 4);
            Byte[] imageAddressBytes = responseBuffer.read(m_imageAddressDataMemoryBlock.getImageAddressDataOffset(), 4);

            m_imageSize = BinaryConverter.intFromFourBytesLE(imageSizeBytes);
            m_imageAddress = BinaryConverter.intFromFourBytesLE(imageAddressBytes);
        }

        @Contract(pure = true)
        public int getImageSize()
        {
            return m_imageSize;
        }

        @Contract(pure = true)
        public int getImageAddress()
        {
            return m_imageAddress;
        }
    }

    public LoadImage(
            ProgramId programId,
            FileName fileName,
            ImageSizeDataMemoryBlock imageSizeDataMemoryBlock,
            ImageAddressDataMemoryBlock imageAddressDataMemoryBlock
    )
    {
        m_programId = programId;
        m_nameArgument = fileName;
        m_imageSizeDataMemoryBlock = imageSizeDataMemoryBlock;
        m_imageAddressDataMemoryBlock = imageAddressDataMemoryBlock;
    }

    @Contract(pure = true)
    @Override
    public Byte getOpCode()
    {
        return OPCODE;
    }

    @Contract(pure = true)
    @Override
    public int allocatedGlobalBlockSize()
    {
        int totalGlobalMemoryAllocated = 0;

        if (m_imageSizeDataMemoryBlock.isGlobal())
            totalGlobalMemoryAllocated += 4;
        if(m_imageAddressDataMemoryBlock.isGlobal())
            totalGlobalMemoryAllocated += 4;

        return totalGlobalMemoryAllocated;
    }

    @Contract(pure = true)
    @Override
    public int allocatedLocalBlockSize()
    {
        int totalLocalMemoryAllocated = 0;

        if (!m_imageSizeDataMemoryBlock.isGlobal())
            totalLocalMemoryAllocated += 4;
        if(!m_imageAddressDataMemoryBlock.isGlobal())
            totalLocalMemoryAllocated += 4;

        return totalLocalMemoryAllocated;
    }

    @Override
    public int getSize()
    {
        int opCodeSize = super.getSize() + 1;   // plus 1 for this command opcode
        int programIdSize = m_programId.getSize();
        int nameSize = m_nameArgument.getSize();
        int returnedImageSizeDataMemoryBlockSize = m_imageSizeDataMemoryBlock.getSize();
        int returnedImageAddressDataMemoryBlockSize = m_imageAddressDataMemoryBlock.getSize();

        return opCodeSize +
                programIdSize +
                nameSize +
                returnedImageSizeDataMemoryBlockSize +
                returnedImageAddressDataMemoryBlockSize;
    }

    @NotNull
    @Override
    public Byte[] getBytes()
    {
        ArrayList<Byte> outputBytes = new ArrayList<>();

        outputBytes.add(super.getOpCode());
        outputBytes.add(this.getOpCode());
        outputBytes.addAll(Arrays.asList(m_programId.getBytes()));
        outputBytes.addAll(Arrays.asList(m_nameArgument.getBytes()));
        outputBytes.addAll(Arrays.asList(m_imageSizeDataMemoryBlock.getBytes()));
        outputBytes.addAll(Arrays.asList(m_imageAddressDataMemoryBlock.getBytes()));

        return outputBytes.toArray(new Byte[0]);
    }

    @NotNull
    @Contract("_ -> new")
    public ReturnedValues getReturnedValues(ResponseBuffer responseBuffer)
    {
        return new ReturnedValues(responseBuffer);
    }
}
