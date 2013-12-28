package com.alexdforeman.emu.emulator.opcodes;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.alexdforeman.emu.emulator.State;

/**
 * Test the OpCode710 class.
 * @author http://github.com/alexdforeman
 */
public class OpCode71Test {

    private static final int _INITIAL_C = 0x2401;
    private static final int _INITIAL_PC = 0x1A33;
    private static final int _FINAL_PC = 0x1A34;
    private static final int _FINAL_H = 0x0024;
    private static final int _FINAL_L = 0x0001;

    /**
     * Test opcode 71.
     * @throws IOException If we can't load the file
     */
    @Test
    public final void test() throws IOException {
        final State state = StateHelper.getState();
        state.setPc(_INITIAL_PC);
        state.setC(_INITIAL_C);
        state.setH(1);
        state.setL(1);
        IOpCode opcode = new OpCode71();
        opcode.exec(state);
        Assert.assertEquals(_FINAL_PC, state.getPc());
        Assert.assertEquals(_FINAL_H, state.getH());
        Assert.assertEquals(_FINAL_L, state.getL());
    }
}
