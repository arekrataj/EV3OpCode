package com.ev3opcode.commands.program.arguments;

import org.jetbrains.annotations.Contract;

import com.ev3opcode.common.arguments.ArgumentValue;

public final class ProgramImageAddressValue extends ArgumentValue implements ProgramImageAddress {
    private int m_imageAddressCached;

    public ProgramImageAddressValue(int imageAddress) {
        setImageAddress(imageAddress);
    }

    @Contract(pure = true)
    public int getImageAddress() {
        return m_imageAddressCached;
    }

    public void setImageAddress(int imageAddress) {
        super.setValue(imageAddress);
        m_imageAddressCached = imageAddress;
    }
}
