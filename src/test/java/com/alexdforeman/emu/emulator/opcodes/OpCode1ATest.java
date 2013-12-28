package com.alexdforeman.emu.emulator.opcodes;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.alexdforeman.emu.emulator.State;

/**
 * Test the OpCode1A class.
 * @author http://github.com/alexdforeman
 */
public class OpCode1ATest {

    private static final int _INITIAL_PC = 0x1A32;
    private static final int _FINAL_PC = 0x1A33;
    private static final int _FINAL_A = 0x2401;
    private static final int _INITIAL_D = 0x0024;
    private static final int _INITIAL_E = 0x0001;

    /**
     * Test the LXI SP command correctly loads the SP.
     * @throws IOException If we cant load the file
     */
    @Test
    public final void test() throws IOException {
        final State state = StateHelper.getState();
        state.setPc(_INITIAL_PC);
        state.setD(_INITIAL_D);
        state.setE(_INITIAL_E);
        IOpCode opcode = new OpCode1A();
        opcode.exec(state);
        Assert.assertEquals(_FINAL_PC, state.getPc());
        Assert.assertEquals(_FINAL_A, state.getA());
    }
}
