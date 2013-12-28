package com.alexdforeman.emu.emulator.opcodes;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.alexdforeman.emu.emulator.State;

/**
 * Test the OpCode11 class.
 * @author http://github.com/alexdforeman
 */
public class OpCode11Test {

    private static final int _INITAL_PC = 0x01E6;
    private static final int _FINAL_PC = 0x01E9;
    private static final int _FINAL_D = 0x001B;
    private static final int _FINAL_E = 0x0000;

    /**
     * Test the LXI D command correctly loads the D and E.
     * @throws IOException If we cant load the file
     */
    @Test
    public final void test() throws IOException {
        final State state = StateHelper.getState();
        state.setPc(_INITAL_PC);
        state.setD(1);
        state.setE(2);
        IOpCode opcode = new OpCode11();
        opcode.exec(state);
        Assert.assertEquals(_FINAL_D, state.getD());
        Assert.assertEquals(_FINAL_E, state.getE());
        Assert.assertEquals(_FINAL_PC, state.getPc());
    }
}
