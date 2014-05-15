/*
 * Created on 16/lug/07
 *
 * $Id: Parameters.java,v 1.2 2007/07/20 07:02:32 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.oil.avr.preferencepages;

public class Parameters {

	public final static Parameters instance = new Parameters();

	/**
	 * Returns the full path of Uisp command (including the program name)
	 */
	public String getUispPath() {
		return "" + Options.getValues().get(Options.AVR_CONF_UISP_PATH);
	}

	/**
	 * 
	 * @return the tty (serial port) where is located the avr5
	 */
	public String getDevTty() {
		return "" + Options.getValues().get(Options.AVR_CONF_SERIAL_DEVICE);
	}

	// --------------------------------------------------------------------

	/**
	 * 
	 * @return the full command required to enable JTag option of connected avr5
	 */
	public String getCommand_EnableJTag() {
		return getUispPath() + " -dprog=avrisp -dpart=ATMEGA128 -dserial="
				+ getDevTty() + " --wr_fuse_h=0x19";
	}

	/**
	 * 
	 * @return the full command required to disable JTag option of connected
	 *         avr5
	 */
	public String getCommand_DisableJTag() {
		return getUispPath() + " -dprog=avrisp -dpart=ATMEGA128 -dserial="
				+ getDevTty() + " --wr_fuse_h=0xD9";
	}

	/**
	 * 
	 * @return the full command required to read JTag option of connected avr5
	 */
	public String getCommand_ReadFuse() {
		return getUispPath() + " -dprog=avrisp -dpart=ATMEGA128 -dserial="
				+ getDevTty() + " --rd_fuses";
	}

	// ---------------------------------------------------------------------

	/**
	 * 
	 * @return the full command required to erase the Flash Memory of connected
	 *         avr5
	 */
	public String getCommand_Erase() {
		return getUispPath() + " -dprog=avrisp -dpart=ATMEGA128 -dserial="
				+ getDevTty() + " --erase";
	}

	/**
	 * This method is used to program flash memory, just after <b>Erase command</b>
	 * and before <b>Verify command</b>
	 * 
	 * @param inputFile
	 *            the binary image that will be written inside the flash memory
	 * 
	 * @return the full command required to programm the Flash Memory of
	 *         connected avr5
	 */
	public String getCommand_Program(String inputFile) {
		return getUispPath() + " -dprog=avrisp -dpart=ATMEGA128 -dserial="
				+ getDevTty() + " --upload if=" + inputFile;
	}

	/**
	 * @param inputFile
	 *            the binary image of the flash memory (have to be verified)
	 * 
	 * @return the full command required to verify the Flash Memory of connected
	 *         avr5
	 */
	public String getCommand_Verify(String inputFile) {
		return getUispPath() + " -dprog=avrisp -dpart=ATMEGA128 -dserial="
				+ getDevTty() + " --verify if=" + inputFile;
	}

}
