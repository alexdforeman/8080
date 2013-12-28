package com.alexdforeman.emu.emulator.opcodes;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.alexdforeman.emu.emulator.State;

/**
 * Test the OpCodeNop class.
 * @author http://github.com/alexdforeman
 */
public class OpCodeNopTest {

    /**
     * Test NOP advances the pc and nothing else.
     * @throws IOException If we cant load the file
     */
    @Test
    public final void test() throws IOException {
        final State state = StateHelper.getState();
        final int pc = state.getPc();
        final IOpCode opcode = new OpCodeNop();
        opcode.exec(state);
        Assert.assertEquals(pc + 1, state.getPc());
    }
}
