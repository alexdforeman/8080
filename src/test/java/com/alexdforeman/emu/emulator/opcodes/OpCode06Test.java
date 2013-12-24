package com.alexdforeman.emu.emulator.opcodes;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.alexdforeman.emu.emulator.State;

/**
 * Test the OpCode06 class.
 * @author http://github.com/alexdforeman
 */
public class OpCode06Test {

    private static final int _INITIAL_B = 0x7777;
    private static final int _FINAL_B = 0x0000;
    private static final int _PC_ADDR = 0x18D7;

    /**
     * Test the LXI SP command correctly loads the SP.
     * @throws IOException If we cant load the file
     */
    @Test
    public final void test() throws IOException {
        final State state = StateHelper.getState();
        state.setPc(_INITIAL_B);
        state.setPc(_PC_ADDR);
        IOpCode opcode = new OpCode06();
        opcode.exec(state);
        Assert.assertEquals(_FINAL_B, state.getB());
    }
}
