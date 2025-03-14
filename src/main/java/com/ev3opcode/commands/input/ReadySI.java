package com.ev3opcode.commands.input;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;

import com.ev3opcode.commands.input.arguments.DeviceMode;
import com.ev3opcode.commands.input.arguments.DeviceType;
import com.ev3opcode.commands.input.arguments.returns.SensorSIDataMemoryBlock;
import com.ev3opcode.common.ResponseBuffer;
import com.ev3opcode.common.arguments.ChainLayerNumber;
import com.ev3opcode.common.arguments.NumberOfReturnValues;
import com.ev3opcode.common.arguments.PortNumber;
import com.ev3opcode.common.tools.BinaryConverter;

public final class ReadySI extends InputCommand {
    private static byte OPCODE = 0x1D;

    private ChainLayerNumber m_chainLayerNumber;
    private PortNumber m_portNumber;
    private DeviceType m_deviceType;
    private DeviceMode m_deviceMode;
    private NumberOfReturnValues m_numberOfReturnValues;
    private SensorSIDataMemoryBlock m_sensorSIDataMemoryBlock;
    private int m_expectedNumberOfReturnedValues = -1; // when reference to number of requested values is given, then
                                                       // this value is used to determine the size of allocation.

    private ReadySI(
            ChainLayerNumber chainLayerNumber,
            PortNumber portNumber,
            DeviceType deviceType,
            DeviceMode deviceMode,
            SensorSIDataMemoryBlock sensorSIDataMemoryBlock) {
        m_chainLayerNumber = chainLayerNumber;
        m_portNumber = portNumber;
        m_deviceType = deviceType;
        m_deviceMode = deviceMode;
        m_sensorSIDataMemoryBlock = sensorSIDataMemoryBlock;
    }

    public final class ReturnedValues {
        private Float[] m_values;

        private ReturnedValues(ResponseBuffer responseBuffer) {
            int bufferSize = m_numberOfReturnValues.isReference() ? m_expectedNumberOfReturnedValues
                    : m_numberOfReturnValues.getValue();

            m_values = new Float[bufferSize];

            for (int i = 0; i < bufferSize; ++i) {
                int startIndex = m_sensorSIDataMemoryBlock.getSensorValuesOffset() + (i * 4); // there are 4 bytes in
                                                                                              // single value
                Byte[] valueBytes = responseBuffer.read(startIndex, 4);
                m_values[i] = BinaryConverter.floatFromFourBytesLE(valueBytes);
            }
        }

        @Contract(pure = true)
        public Float[] getValues() {
            return m_values;
        }
    }

    public ReadySI(
            ChainLayerNumber chainLayerNumber,
            PortNumber portNumber,
            DeviceType deviceType,
            DeviceMode deviceMode,
            @NotNull NumberOfReturnValues numberOfReturnValues,
            SensorSIDataMemoryBlock sensorSIDataMemoryBlock) {
        this(chainLayerNumber, portNumber, deviceType, deviceMode, sensorSIDataMemoryBlock);

        if (numberOfReturnValues.isReference())
            throw new RuntimeException(
                    "The size of the memory to be allocated cannot be determined from memory offset. Use constant value instead.");

        m_numberOfReturnValues = numberOfReturnValues;
    }

    // constructor for memory offsets for NumberOfReturnValues
    public ReadySI(
            ChainLayerNumber chainLayerNumber,
            PortNumber portNumber,
            DeviceType deviceType,
            DeviceMode deviceMode,
            @NotNull NumberOfReturnValues numberOfReturnValues,
            byte expectedNumberOfReturnedValues,
            SensorSIDataMemoryBlock sensorSIDataMemoryBlock) {
        this(chainLayerNumber, portNumber, deviceType, deviceMode, sensorSIDataMemoryBlock);

        m_numberOfReturnValues = numberOfReturnValues;
        m_expectedNumberOfReturnedValues = expectedNumberOfReturnedValues;
    }

    @Contract(pure = true)
    @Override
    public Byte getOpCode() {
        return OPCODE;
    }

    @Override
    public int allocatedGlobalBlockSize() {
        if (m_sensorSIDataMemoryBlock.isGlobal()) {
            if (!m_numberOfReturnValues.isReference())
                return m_numberOfReturnValues.getValue() * 4;
            else if (m_expectedNumberOfReturnedValues >= 0)
                return m_expectedNumberOfReturnedValues * 4;
            else
                throw new RuntimeException("The size of global allocation memory cannot be determined.");
        }

        return 0;
    }

    @Override
    public int allocatedLocalBlockSize() {
        if (!m_sensorSIDataMemoryBlock.isGlobal()) {
            if (!m_numberOfReturnValues.isReference())
                return m_numberOfReturnValues.getValue() * 4;
            else if (m_expectedNumberOfReturnedValues >= 0)
                return m_expectedNumberOfReturnedValues * 4;
            else
                throw new RuntimeException("The size of global allocation memory cannot be determined.");
        }

        return 0;
    }

    @Override
    public int getSize() {
        int opCodeSize = super.getSize() + 1; // plus 1 for this command opcode
        int chainLayerNumberSize = m_chainLayerNumber.getSize();
        int portNumberSize = m_portNumber.getSize();
        int deviceTypeSize = m_deviceType.getSize();
        int deviceModeSize = m_deviceMode.getSize();
        int numberOfRequestedValuesSize = m_numberOfReturnValues.getSize();
        int sensorSIDataMemoryBlockSize = m_sensorSIDataMemoryBlock.getSize();

        return opCodeSize +
                chainLayerNumberSize +
                portNumberSize +
                deviceTypeSize +
                deviceModeSize +
                numberOfRequestedValuesSize +
                sensorSIDataMemoryBlockSize;
    }

    @NotNull
    @Override
    public Byte[] getBytes() {
        ArrayList<Byte> outputBytes = new ArrayList<>();

        outputBytes.add(super.getOpCode());
        outputBytes.add(this.getOpCode());
        outputBytes.addAll(Arrays.asList(m_chainLayerNumber.getBytes()));
        outputBytes.addAll(Arrays.asList(m_portNumber.getBytes()));
        outputBytes.addAll(Arrays.asList(m_deviceType.getBytes()));
        outputBytes.addAll(Arrays.asList(m_deviceMode.getBytes()));
        outputBytes.addAll(Arrays.asList(m_numberOfReturnValues.getBytes()));
        outputBytes.addAll(Arrays.asList(m_sensorSIDataMemoryBlock.getBytes()));

        return outputBytes.toArray(new Byte[0]);
    }

    @NotNull
    @Contract("_ -> new")
    public ReturnedValues getReturnedValues(ResponseBuffer responseBuffer) {
        return new ReturnedValues(responseBuffer);
    }
}
