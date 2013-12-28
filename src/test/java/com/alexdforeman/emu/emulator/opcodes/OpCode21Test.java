package com.alexdforeman.emu.emulator.opcodes;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.alexdforeman.emu.emulator.State;

/**
 * Test the OpCode21 class.
 * @author http://github.com/alexdforeman
 */
public class OpCode21Test {

    private static final int _INITAL_PC = 0x01E9;
    private static final int _FINAL_PC = 0x01EC;
    private static final int _FINAL_H = 0x0020;
    private static final int _FINAL_L = 0x0000;

    /**
     * Test the LXI H command correctly loads the D and E.
     * @throws IOException If we cant load the file
     */
    @Test
    public final void test() throws IOException {
        final State state = StateHelper.getState();
        state.setPc(_INITAL_PC);
        state.setH(1);
        state.setL(2);
        IOpCode opcode = new OpCode21();
        opcode.exec(state);
        Assert.assertEquals(_FINAL_H, state.getH());
        Assert.assertEquals(_FINAL_L, state.getL());
        Assert.assertEquals(_FINAL_PC, state.getPc());
    }
}
