package com.alexdforeman.emu.emulator.opcodes;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.alexdforeman.emu.emulator.State;

/**
 * Test the OpCode74 class.
 * @author http://github.com/alexdforeman
 */
public class OpCode74Test {

    private static final int _INITIAL_PC = 0x1A33;
    private static final int _FINAL_PC = 0x1A34;
    private static final int _INITIAL_H = 0x0024;
    private static final int _INITIAL_L = 0x0001;
    private static final int _INITIAL_M = 0x2401;

    /**
     * Test the LXI SP command correctly loads the SP.
     * @throws IOException If we can't load the file
     */
    @Test
    public final void test() throws IOException {
        final State state = StateHelper.getState();
        state.setPc(_INITIAL_PC);
        state.setH(_INITIAL_H);
        state.setL(_INITIAL_L);
        IOpCode opcode = new OpCode74();
        opcode.exec(state);
        Assert.assertEquals(_FINAL_PC, state.getPc());
        int[] memory = state.getMemory();
        Assert.assertEquals(_INITIAL_H, memory[_INITIAL_M]);
    }
}
