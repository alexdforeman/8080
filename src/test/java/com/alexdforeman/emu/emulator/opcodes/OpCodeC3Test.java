package com.alexdforeman.emu.emulator.opcodes;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.alexdforeman.emu.emulator.State;

/**
 * Test the OpCodeC3 class.
 * @author http://github.com/alexdforeman
 */
public class OpCodeC3Test {

    private static final int _INITIAL_PC = 0x0003;
    private static final int _FINAL_PC = 0x18D4;

    /**
     * Test JMP.
     * @throws IOException If we cant load the file
     */
    @Test
    public final void test() throws IOException {
        final State state = StateHelper.getState();
        state.setPc(_INITIAL_PC);
        IOpCode opcode = new OpCodeC3();
        opcode.exec(state);
        Assert.assertEquals(_FINAL_PC, state.getPc());
    }
}
