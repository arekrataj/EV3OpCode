package com.ev3opcode.commands.ui;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;

import com.ev3opcode.commands.ui.arguments.Color;
import com.ev3opcode.commands.ui.arguments.YSize;
import com.ev3opcode.commands.ui.arguments.YStart;

public final class FillWindow extends UIDrawCommand {
    private static byte OPCODE = 0x13;

    private Color m_color;
    private YStart m_yStart;
    private YSize m_ySize;

    public FillWindow(Color color, YStart yStart, YSize ySize) {
        m_color = color;
        m_yStart = yStart;
        m_ySize = ySize;
    }

    @NotNull
    @Contract(pure = true)
    @Override
    public Byte getOpCode() {
        return OPCODE;
    }

    @Contract(pure = true)
    @Override
    public int allocatedGlobalBlockSize() {
        return 0;
    }

    @Contract(pure = true)
    @Override
    public int allocatedLocalBlockSize() {
        return 0;
    }

    @Override
    public int getSize() {
        int thisSize = super.getSize() + 1;
        int colorSize = m_color.getSize();
        int yStartSize = m_ySize.getSize();
        int ySizeSize = m_ySize.getSize();

        return thisSize + colorSize + yStartSize + ySizeSize;
    }

    @NotNull
    @Override
    public Byte[] getBytes() {
        ArrayList<Byte> outputBytes = new ArrayList<>();

        outputBytes.add(super.getOpCode());
        outputBytes.add(this.getOpCode());
        outputBytes.addAll(Arrays.asList(m_color.getBytes()));
        outputBytes.addAll(Arrays.asList(m_ySize.getBytes()));
        outputBytes.addAll(Arrays.asList(m_ySize.getBytes()));

        return outputBytes.toArray(new Byte[0]);
    }
}
