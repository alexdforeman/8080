package com.alexdforeman.emu.emulator.opcodes;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.alexdforeman.emu.emulator.State;

/**
 * Test the OpCodeCD class.
 * @author http://github.com/alexdforeman
 */
public class OpCodeCDTest {

    private static final int _INITIAL_PC = 0x18D9;
    private static final int _FINAL_PC = 0x01E6;
    private static final int _INITIAL_SP = 0x2400;
    private static final int _FINAL_SP = 0x23FE;

    /**
     * Test JMP.
     * @throws IOException If we cant load the file
     */
    @Test
    public final void test() throws IOException {
        final State state = StateHelper.getState();
        state.setPc(_INITIAL_PC);
        state.setSp(_INITIAL_SP);
        IOpCode opcode = new OpCodeCD();
        opcode.exec(state);
        Assert.assertEquals(_FINAL_PC, state.getPc());
        Assert.assertEquals(_FINAL_SP, state.getSp());
    }
}
