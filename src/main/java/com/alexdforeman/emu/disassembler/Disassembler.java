package com.alexdforeman.emu.disassembler;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * Disassembles a 8080 game and prints to screen.
 * @author http://github.com/alexdforeman
 */
public class Disassembler {

    private static final int _THREE_OPCODE = 3;
    private static final int _TWO_OPCODE = 2;

	private Map<Integer, Opcode> _opcodes;

	/**
	 * Creates a Disassembler with the input stream of a 8080 game.
	 * @param stream_ an InputStream
	 * @throws IOException if things go wrong
	 */
	public Disassembler(final InputStream stream_) throws IOException {
		_opcodes = OpcodeLoader.getOpcodes(stream_);
	}

	/**
	 * The work horse behind the class.
	 * @param fileName_ a path to a file
	 */
	public final void disassemble(final String fileName_) {

        try (DataInputStream data = new DataInputStream(new FileInputStream(new File(
                fileName_)))) {
            int opcode = data.read();
            int line = 0;
            while (opcode != -1) {
            	Opcode action = _opcodes.get(opcode);
            	System.out.printf("%04x ", line);

        		if (action.getSize() == _THREE_OPCODE) {
        			System.out.printf("%02x | %10s | %02x %02x | %s%n",
        					action.getOpcode(),
        					action.getInstr(),
        					data.read(),
        					data.read(),
        					action.getFunc());
        			line = line + _THREE_OPCODE;
        		} else if (action.getSize() == _TWO_OPCODE) {
        			System.out.printf("%02x | %10s | %02x    | %s%n",
        					action.getOpcode(),
        					action.getInstr(),
        					data.read(),
        					action.getFunc());
        			line = line + _TWO_OPCODE;
        		} else {
            			System.out.printf("%02x | %10s |       | %s%n",
            					action.getOpcode(),
            					action.getInstr(),
            					action.getFunc());
                    	line++;
        		}
            	opcode = data.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	};

    /**
     * Main method.  The entry point to our disassembler.
     * @param args_ String...
     * @throws IOException If we cant find the opcodes.
     */
    public static void main(String... args_) throws IOException {
    	InputStream resourceAsStream = Disassembler.class.getResourceAsStream("/Opcodes-8080");
    	Disassembler disassembler = new Disassembler(resourceAsStream);
    	disassembler.disassemble(args_[0]);
    }
}
