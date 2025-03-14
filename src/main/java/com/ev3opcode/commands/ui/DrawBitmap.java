package com.ev3opcode.commands.ui;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;

import com.ev3opcode.commands.ui.arguments.Color;
import com.ev3opcode.commands.ui.arguments.XStart;
import com.ev3opcode.commands.ui.arguments.YStart;
import com.ev3opcode.common.arguments.FileName;

public final class DrawBitmap extends UIDrawCommand {
    private static byte OPCODE = 0x1C;

    private Color m_color;
    private XStart m_xStart;
    private YStart m_yStart;
    private FileName m_fileName;

    public DrawBitmap(Color color, XStart xStart, YStart yStart, FileName fileName) {
        m_color = color;
        m_xStart = xStart;
        m_yStart = yStart;
        m_fileName = fileName;
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

    @Contract(pure = true)
    @Override
    public Byte getOpCode() {
        return OPCODE;
    }

    @Override
    public int getSize() {
        int thisSize = super.getSize() + 1;
        int colorSize = m_color.getSize();
        int xStartSize = m_xStart.getSize();
        int yStartSize = m_yStart.getSize();
        int fileNameSize = m_fileName.getSize();

        return thisSize + colorSize + xStartSize + yStartSize + fileNameSize;
    }

    @NotNull
    @Override
    public Byte[] getBytes() {
        ArrayList<Byte> outputBytes = new ArrayList<>();

        outputBytes.add(super.getOpCode());
        outputBytes.add(this.getOpCode());
        outputBytes.addAll(Arrays.asList(m_color.getBytes()));
        outputBytes.addAll(Arrays.asList(m_xStart.getBytes()));
        outputBytes.addAll(Arrays.asList(m_yStart.getBytes()));
        outputBytes.addAll(Arrays.asList(m_fileName.getBytes()));

        return outputBytes.toArray(new Byte[0]);
    }
}
