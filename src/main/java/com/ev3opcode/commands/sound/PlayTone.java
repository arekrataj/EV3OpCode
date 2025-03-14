package com.ev3opcode.commands.sound;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;

import com.ev3opcode.commands.sound.arguments.Duration;
import com.ev3opcode.commands.sound.arguments.Frequency;
import com.ev3opcode.commands.sound.arguments.Volume;

public final class PlayTone extends SoundCommand {
    private static byte OPCODE = 0x1;

    private Volume m_volume;
    private Frequency m_frequency;
    private Duration m_duration;

    public PlayTone(Volume volume, Frequency frequency, Duration duration) {
        m_volume = volume;
        m_frequency = frequency;
        m_duration = duration;
    }

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
        int volumeSize = m_volume.getSize();
        int frequencySize = m_frequency.getSize();
        int durationSize = m_duration.getSize();

        return thisSize + volumeSize + frequencySize + durationSize;
    }

    @NotNull
    @Override
    public Byte[] getBytes() {
        ArrayList<Byte> outputBytes = new ArrayList<>();

        outputBytes.add(super.getOpCode());
        outputBytes.add(this.getOpCode());
        outputBytes.addAll(Arrays.asList(m_volume.getBytes()));
        outputBytes.addAll(Arrays.asList(m_frequency.getBytes()));
        outputBytes.addAll(Arrays.asList(m_duration.getBytes()));

        return outputBytes.toArray(new Byte[0]);
    }
}
