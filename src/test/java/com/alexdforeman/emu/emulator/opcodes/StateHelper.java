package com.alexdforeman.emu.emulator.opcodes;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import com.alexdforeman.emu.emulator.State;

/**
 * Simple Class to load the state.
 * @author http://github.com/alexdforeman
 */
public final class StateHelper {
    private static final int _SIZE_OF_SPACE_INVADERS = 8192;
    private static final int _SIZE_OF_8080_MEM_SPACE = 0xFFFF;
    private static final int _0XFF = 0xFF;

    static State getState() throws IOException {
        try (DataInputStream data = new DataInputStream(new FileInputStream(new File(
                "/home/alex/Development/SpaceInvaders/rom/invaders")))) {
            byte[] program = new byte[_SIZE_OF_SPACE_INVADERS];
            data.read(program);
            int[] convertedProgram = new int[_SIZE_OF_8080_MEM_SPACE];
            for (int i = 0; i < program.length; i++) {
                convertedProgram[i] = (int) program[i] & _0XFF;
            }
            return new State(convertedProgram);
        }
    }

    private StateHelper() { }
}
