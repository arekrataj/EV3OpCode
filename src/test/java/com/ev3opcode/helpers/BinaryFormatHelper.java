package com.ev3opcode.helpers;

public class BinaryFormatHelper {
    public static String byteToBinaryString(byte b) {
        return String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
    }

    public static String intToBinaryString(short s) {
        return String.format("%16s", Integer.toBinaryString(s & 0xFFFF)).replace(' ', '0');
    }

    public static String intToBinaryString(int i) {
        return String.format("%32s", Integer.toBinaryString(i)).replace(' ', '0');
    }

    public static String byteToHexString(byte b) {
        return String.format("%2s", Integer.toHexString(b & 0xFF)).replace(' ', '0').toUpperCase();
    }

    public static String intToHexString(short s) {
        return String.format("%4s", Integer.toHexString(s & 0xFFFF)).replace(' ', '0').toUpperCase();
    }

    public static String intToHexString(int i) {
        return String.format("%8s", Integer.toHexString(i)).replace(' ', '0').toUpperCase();
    }
}
