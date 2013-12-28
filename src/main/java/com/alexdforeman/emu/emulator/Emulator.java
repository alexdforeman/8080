package com.alexdforeman.emu.emulator;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.alexdforeman.emu.emulator.opcodes.IOpCode;

/**
 * Emulator of an 8080.
 * @author http://github.com/alexdforeman
 */
public class Emulator {

    private static final int _SIZE_OF_SPACE_INVADERS = 0x2000;
    private static final int _SIZE_OF_8080_MEM_SPACE = 0xFFFF;
    private static final int _0XFF = 0xFF;
    private final State _state;

    /**
     * Constructor.
     * @param state_ The state of the program.
     */
    public Emulator(final State state_) {
        _state = state_;
    }

    /**
     * Start executing the Emulator.
     */
    public final void start() {
        int i = 1;
        while (true) {
            int instruction = _state.getMemory()[_state.getPc()];
            System.out.println("-- " + Integer.toHexString(instruction));
            IOpCode opcode = OpcodeCache.get(instruction);
            opcode.exec(_state);
            System.out.println(i++);
        }
    }

    /**
     * @param args_ Program args.
     */
    public static void main(String... args_) {
        try (DataInputStream data = new DataInputStream(new FileInputStream(new File(
                "/home/alex/Development/SpaceInvaders/rom/invaders")))) {
            byte[] program = new byte[_SIZE_OF_SPACE_INVADERS];
            data.read(program);
            int[] convertedProgram = new int[_SIZE_OF_8080_MEM_SPACE];
            for (int i = 0; i < program.length; i++) {
                convertedProgram[i] = (int) program[i] & _0XFF;
            }
            State state = new State(convertedProgram);

            Emulator emu = new Emulator(state);
            emu.start();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
