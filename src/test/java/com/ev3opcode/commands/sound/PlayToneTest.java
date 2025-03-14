package com.ev3opcode.commands.sound;

import org.junit.Before;
import org.junit.Test;

import com.ev3opcode.helpers.BinaryFormatHelper;
import com.ev3opcode.commands.sound.arguments.Duration;
import com.ev3opcode.commands.sound.arguments.DurationValue;
import com.ev3opcode.commands.sound.arguments.Frequency;
import com.ev3opcode.commands.sound.arguments.FrequencyValue;
import com.ev3opcode.commands.sound.arguments.Volume;
import com.ev3opcode.commands.sound.arguments.VolumeValue;

import static org.junit.Assert.assertEquals;

public class PlayToneTest {
    private PlayTone m_command;
    private String m_expectedByteCode = "94010282E80382E803";

    @Before
    public void setUp() throws Exception {
        Volume volume = new VolumeValue(2);
        Frequency frequency = new FrequencyValue(1000);
        Duration duration = new DurationValue(1000);

        m_command = new PlayTone(volume, frequency, duration);
    }

    @Test(expected = RuntimeException.class)
    public void volumeValueArgument_negative_throwsException() {
        new VolumeValue(-100);
    }

    @Test(expected = RuntimeException.class)
    public void volumeValueArgument_101_throwsException() {
        new VolumeValue(101);
    }

    @Test(expected = RuntimeException.class)
    public void frequencyValueArgument_zero_throwsException() {
        new FrequencyValue(0);
    }

    @Test(expected = RuntimeException.class)
    public void frequencyValueArgument_1000000_throwsException() {
        new VolumeValue(1000000);
    }

    @Test(expected = RuntimeException.class)
    public void durationValueArgument_32bits_throwsException() {
        new DurationValue(0xFFFFFF);
    }

    @Test
    public void getSize_PlayTone_9() {
        assertEquals(9, m_command.getSize());
    }

    @Test
    public void getBytes_PlayTone_lengthOf9() {
        assertEquals(9, m_command.getBytes().length);
    }

    @Test
    public void getBytes_PlayTone_expectedByteCode() {
        Byte[] byteCode = m_command.getBytes();
        for (int i = 0, j = 0; i < m_expectedByteCode.length() - 2; i += 2, ++j) {
            String expectedByteCode = m_expectedByteCode.substring(i, i + 2);
            assertEquals(expectedByteCode, BinaryFormatHelper.byteToHexString(byteCode[j]));
        }
    }
}