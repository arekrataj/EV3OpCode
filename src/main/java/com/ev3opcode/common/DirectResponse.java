package com.ev3opcode.common;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public final class DirectResponse {
    private int m_size;
    private short m_messageNumber;
    private DirectResponseType m_responseType;
    private ResponseBuffer m_responseBuffer;

    @Contract(pure = true)
    private static short fromLittleEndian(@NotNull Byte[] leBytes) {
        return (short) (leBytes[0] | (leBytes[1] << 0x8));
    }

    @Contract(pure = true)
    private DirectResponse(
            int size,
            short messageNumber,
            DirectResponseType responseType,
            ResponseBuffer responseBuffer) {
        m_size = size;
        m_messageNumber = messageNumber;
        m_responseType = responseType;
        m_responseBuffer = responseBuffer;
    }

    @NotNull
    @Contract("_ -> new")
    public static DirectResponse fromByteCode(@NotNull Byte[] byteCode) {
        if (byteCode.length < 5)
            throw new RuntimeException("Incorrect response length (< 5 bytes).");

        Byte[] replySizeBytes = Arrays.copyOfRange(byteCode, 0, 2);
        Byte[] messageCounterBytes = Arrays.copyOfRange(byteCode, 2, 4);
        Byte responseTypeByte = byteCode[4];
        Byte[] responseBytes = Arrays.copyOfRange(byteCode, 5, byteCode.length);

        int size = fromLittleEndian(replySizeBytes);
        short messageCounter = fromLittleEndian(messageCounterBytes);
        DirectResponseType responseType = DirectResponseType.getValueOf(responseTypeByte);
        ResponseBuffer responseBuffer = new ResponseBuffer(responseBytes);

        return new DirectResponse(size, messageCounter, responseType, responseBuffer);
    }

    @Contract(pure = true)
    public int getSize() {
        return m_size;
    }

    @Contract(pure = true)
    public short getMessageNumber() {
        return m_messageNumber;
    }

    @Contract(pure = true)
    public DirectResponseType getResponseType() {
        return m_responseType;
    }

    @Contract(pure = true)
    public ResponseBuffer getResponseBuffer() {
        return m_responseBuffer;
    }
}
