package com.alexdforeman.emu.emulator.opcodes;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.alexdforeman.emu.emulator.State;

/**
 * Test the OpCode70 class.
 * @author http://github.com/alexdforeman
 */
public class OpCode70Test {

    private static final int _INITIAL_B = 0x2401;
    private static final int _INITIAL_PC = 0x1A33;
    private static final int _FINAL_PC = 0x1A34;
    private static final int _FINAL_H = 0x0024;
    private static final int _FINAL_L = 0x0001;

    /**
     * Test opcode 70.
     * @throws IOException If we can't load the file
     */
    @Test
    public final void test() throws IOException {
        final State state = StateHelper.getState();
        state.setPc(_INITIAL_PC);
        state.setB(_INITIAL_B);
        state.setH(1);
        state.setL(1);
        IOpCode opcode = new OpCode70();
        opcode.exec(state);
        Assert.assertEquals(_FINAL_PC, state.getPc());
        Assert.assertEquals(_FINAL_H, state.getH());
        Assert.assertEquals(_FINAL_L, state.getL());
    }
}
