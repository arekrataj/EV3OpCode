package com.ev3opcode.commands.program.arguments;

import org.jetbrains.annotations.Contract;

import com.ev3opcode.common.arguments.ArgumentValue;

public final class ProgramImageSizeValue extends ArgumentValue implements ProgramImageSize {
    private int m_imageSizeCached;

    public ProgramImageSizeValue(int imageSize) {
        setImageSize(imageSize);
    }

    @Contract(pure = true)
    public int getImageSize() {
        return m_imageSizeCached;
    }

    public void setImageSize(int imageSize) {
        super.setValue(imageSize);
        m_imageSizeCached = imageSize;
    }
}
