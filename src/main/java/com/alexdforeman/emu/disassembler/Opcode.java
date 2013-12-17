package com.alexdforeman.emu.disassembler;

/**
 * Describe here.
 * @author http://github.com/alexdforeman
 */
public class Opcode {

	private final Integer _opcode;
	private final String _instr;
	private final Integer _size;
	private final String _flags;
	private final String _func;

	/**
	 * Constructor.
	 * @param opcode_ Integer
	 * @param instr_ String
	 * @param size_ String
	 * @param flags_ String
	 * @param func_ String
	 */
	public Opcode(final Integer opcode_, final String instr_, final String size_,
			final String flags_, final String func_) {
		_opcode = opcode_;
		_instr = instr_;
		if (size_ == null || size_.equals(" ")) {
			_size = 1;
		} else {
			_size = Integer.parseInt(size_);
		}
		_flags = flags_;
		_func = func_;
	}

	/**
	 * Get the opcode.
	 * @return the opcode
	 */
	public final Integer getOpcode() {
		return _opcode;
	}

	/**
	 * Get the instruction.
	 * @return the instr
	 */
	public final String getInstr() {
		return _instr;
	}

	/**
	 * Get the size.
	 * @return the size
	 */
	public final Integer getSize() {
		return _size;
	}

	/**
	 * Get the flags.
	 * @return the flags
	 */
	public final String getFlags() {
		return _flags;
	}

	/**
	 * Get the function.
	 * @return the func
	 */
	public final String getFunc() {
		return _func;
	}
}
