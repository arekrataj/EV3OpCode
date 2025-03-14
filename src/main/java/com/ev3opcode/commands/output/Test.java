package com.ev3opcode.commands.output;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;

import com.ev3opcode.commands.output.arguments.MotorBitField;
import com.ev3opcode.commands.output.arguments.returns.TestResultDataMemoryBlock;
import com.ev3opcode.commands.output.types.TestResult;
import com.ev3opcode.common.Command;
import com.ev3opcode.common.ResponseBuffer;
import com.ev3opcode.common.arguments.ChainLayerNumber;

public final class Test extends Command {
    private static byte OPCODE = (byte) 0xA9;

    private ChainLayerNumber m_chainLayerNumber;
    private MotorBitField m_motorBitField;
    private TestResultDataMemoryBlock m_testResultDataMemoryBlock;

    public final class ReturnedValues {
        private TestResult m_testResult;

        private ReturnedValues(@NotNull ResponseBuffer responseBuffer) {
            Byte[] testResultBytes = responseBuffer.read(m_testResultDataMemoryBlock.getTestResultOffset(), 1);

            m_testResult = new TestResult(testResultBytes[0]);
        }

        @Contract(pure = true)
        public TestResult getTestResult() {
            return m_testResult;
        }
    }

    public Test(
            ChainLayerNumber chainLayerNumber,
            MotorBitField motorBitField,
            TestResultDataMemoryBlock testResultDataMemoryBlock) {
        m_chainLayerNumber = chainLayerNumber;
        m_motorBitField = motorBitField;
        m_testResultDataMemoryBlock = testResultDataMemoryBlock;
    }

    @Contract(pure = true)
    @Override
    public Byte getOpCode() {
        return OPCODE;
    }

    @Contract(pure = true)
    @Override
    public int allocatedGlobalBlockSize() {
        int totalGlobalMemoryAllocated = 0;

        if (m_testResultDataMemoryBlock.isGlobal())
            totalGlobalMemoryAllocated += 1;

        return totalGlobalMemoryAllocated;
    }

    @Contract(pure = true)
    @Override
    public int allocatedLocalBlockSize() {
        int totalLocalMemoryAllocated = 0;

        if (!m_testResultDataMemoryBlock.isGlobal())
            totalLocalMemoryAllocated += 1;

        return totalLocalMemoryAllocated;
    }

    @Override
    public int getSize() {
        int opCodeSize = 1; // plus 1 for this command opcode
        int chainLayerNumberSize = m_chainLayerNumber.getSize();
        int motorBitField = m_motorBitField.getSize();
        int speedLevelDataMemoryBlockSize = m_testResultDataMemoryBlock.getSize();

        return opCodeSize +
                chainLayerNumberSize +
                motorBitField +
                speedLevelDataMemoryBlockSize;
    }

    @NotNull
    @Override
    public Byte[] getBytes() {
        ArrayList<Byte> outputBytes = new ArrayList<>();

        outputBytes.add(this.getOpCode());
        outputBytes.addAll(Arrays.asList(m_chainLayerNumber.getBytes()));
        outputBytes.addAll(Arrays.asList(m_motorBitField.getBytes()));
        outputBytes.addAll(Arrays.asList(m_testResultDataMemoryBlock.getBytes()));

        return outputBytes.toArray(new Byte[0]);
    }

    @NotNull
    @Contract("_ -> new")
    public ReturnedValues getReturnedValues(ResponseBuffer responseBuffer) {
        return new Test.ReturnedValues(responseBuffer);
    }
}
