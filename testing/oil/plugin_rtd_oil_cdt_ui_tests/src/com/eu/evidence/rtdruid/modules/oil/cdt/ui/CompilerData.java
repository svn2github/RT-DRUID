/**
 * 30/mag/2012
 */
package com.eu.evidence.rtdruid.modules.oil.cdt.ui;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import com.eu.evidence.rtdruid.modules.oil.cdt.ui.examples.ExamplesLoader;

/**
 * 
 * @author Nicola Serreli
 * @since 2.0
 * 
 */
public class CompilerData {

	/**
	 * 
	 */
	public static final String RENESAS = "renesas";
	/**
	 * 
	 */
	public static final String E200Zx = "e200Zx";
	/**
	 * 
	 */
	public static final String PIC32 = "pic32";
	/**
	 * 
	 */
	public static final String S12 = "s12";
	/**
	 * 
	 */
	public static final String DS_PIC = "dsPic";
	/**
	 * 
	 */
	public static final String CORTEX = "cortex";
	/**
	 * 
	 */
	public static final String AVR5 = "avr5";
	/**
	 * 
	 */
	public static final String ARM7 = "arm7";
	static final public Map<String, CompilerData> AllCompilerData;

	public static class CompilerPath {
		protected final String ID;
		protected final String defaultValue;
		protected final String testValue;
		protected final String oilTest;

		public CompilerPath(String id, String defValue, String testValue) {
			this(id, defValue, testValue, null);
		}

		public CompilerPath(String id, String defValue, String testValue, String oilTest) {
			this.ID = id;
			this.defaultValue = defValue;
			this.testValue = testValue;
			this.oilTest = oilTest;
		}

		/**
		 * @return the iD
		 */
		public String getID() {
			return ID;
		}

		/**
		 * @return the defaultValue
		 */
		public String getDefaultValue() {
			return defaultValue;
		}

		/**
		 * @return the testValue
		 */
		public String getTestValue() {
			return testValue;
		}
		
		/**
		 * @return the oilTest
		 */
		public String getOilTest() {
			return oilTest;
		}
	}

	public static class CompilerDataBuilder {

		protected String ID;
		protected String[] preferenceTreePath;
		protected ArrayList<CompilerPath> compilerSet = new ArrayList<CompilerData.CompilerPath>();

		/**
		 * @param iD
		 *            the iD to set
		 */
		public CompilerDataBuilder(String iD) {
			ID = iD;
		}

		/**
		 * @param preferenceTreePath
		 *            the preferenceTreePath to set
		 */
		public CompilerDataBuilder setPreferenceTreePath(String[] preferenceTreePath) {
			this.preferenceTreePath = preferenceTreePath;
			return this;
		}

		/**
		 * Add an element to compiler paths
		 * 
		 * @param elem
		 *            a compiler path
		 * @return
		 */
		public CompilerDataBuilder addCompiler(CompilerPath elem) {
			compilerSet.add(elem);
			return this;
		}

		public CompilerData makeCompilerData() {
			return new CompilerData(ID, preferenceTreePath,
					(CompilerPath[]) compilerSet.toArray(new CompilerPath[compilerSet.size()]));
		}
	}

	static {

		AllCompilerData = new LinkedHashMap<String, CompilerData>();

		AllCompilerData.put(ARM7,
				(new CompilerDataBuilder(ARM7)).setPreferenceTreePath(new String[] { "RT-Druid", "Oil", "Arm7" })
						.addCompiler(new CompilerPath("Gcc path", "c:\\path\\to\\gcc", "new_arm7_path",
								ExamplesLoader.safeLoad("arm7_1")))
						.makeCompilerData());
		AllCompilerData.put(AVR5,
				(new CompilerDataBuilder(AVR5)).setPreferenceTreePath(new String[] { "RT-Druid", "Oil", "Avr5" })
						.addCompiler(new CompilerPath("Gcc path", "C:\\programmi\\AVRGCC\\avrgcc", "new_avr5_path",
								ExamplesLoader.safeLoad("avr5_1")))
						.makeCompilerData());
		AllCompilerData.put(
				CORTEX,
				(new CompilerDataBuilder(CORTEX))
						.setPreferenceTreePath(new String[] { "RT-Druid", "Oil", "cortex" })
						.addCompiler(
								new CompilerPath("IAR Compiler path",
										"C:\\Programmi\\IAR Systems\\Embedded Workbench 6.0 Kickstart\\arm",
										"new_cortex_iar_path",
										ExamplesLoader.safeLoad("cortex_iar")))
						.addCompiler(
								new CompilerPath("CCS Compiler path", "C:\\Programmi\\Texas Instruments\\ccsv4",
										"new_cortex_ccs_path",
										ExamplesLoader.safeLoad("cortex_ccs")))
						.addCompiler(new CompilerPath("Keil Compiler path", "C:\\Keil\\ARM", "new_cortex_keil_path",
								ExamplesLoader.safeLoad("cortex_keil")))
						.makeCompilerData());
		AllCompilerData.put(DS_PIC,
				(new CompilerDataBuilder(DS_PIC)).setPreferenceTreePath(new String[] { "RT-Druid", "Oil", "dsPic" })
						.addCompiler(new CompilerPath("Gcc path", "c:\\Programmi\\Microchip\\MPLAB C30", "new_dspic_gcc_path",
								ExamplesLoader.safeLoad("dspic_gcc")))
						.addCompiler(new CompilerPath("Asm path", "c:\\Programmi\\Microchip\\MPLAB ASM30 Suite", "new_dspic_asm_path")).makeCompilerData());
		AllCompilerData.put(
				E200Zx,
				(new CompilerDataBuilder(E200Zx))
						.setPreferenceTreePath(new String[] { "RT-Druid", "Oil", "e200Zx" })
						.addCompiler(new CompilerPath("Codewarrior Compiler Path", "C:/default/path", "new_s12_codewarrior_path",
								ExamplesLoader.safeLoad("e200zx_codewarrior")))
						.addCompiler(new CompilerPath("Diab Compiler Path", "", "new_s12_diab_path",
								ExamplesLoader.safeLoad("e200zx_diab")))
						.makeCompilerData());
		AllCompilerData.put(
				S12,
				(new CompilerDataBuilder(S12))
						.setPreferenceTreePath(new String[] { "RT-Druid", "Oil", "Freescale S12" })
						.addCompiler(new CompilerPath("Cosmic Compiler Path", "c:\\Program Files\\COSMIC\\EVAL12X", "new_s12_cosmic_path",
								ExamplesLoader.safeLoad("s12_cosmic")))
						.addCompiler(new CompilerPath("Codewarrior Compiler Path", "c:\\Program Files\\Freescale\\CWS12v5.1", "new_s12_codewarrior_path",
								ExamplesLoader.safeLoad("s12_codewarrior"))).makeCompilerData());
		AllCompilerData.put(PIC32,
				(new CompilerDataBuilder(PIC32)).setPreferenceTreePath(new String[] { "RT-Druid", "Oil", "Pic32" })
						.addCompiler(new CompilerPath("Gcc path", "c:\\Programmi\\Microchip\\MPLAB C32", "new_pic32_gcc_path",
								ExamplesLoader.safeLoad("pic32_gcc")))
						.addCompiler(new CompilerPath("Asm path", "", "new_pic32_asm_path")).makeCompilerData());
		AllCompilerData.put(RENESAS,
				(new CompilerDataBuilder(RENESAS)).setPreferenceTreePath(new String[] { "RT-Druid", "Oil", "Renesas" })
						.addCompiler(new CompilerPath("CCRX path", "C:\\Programmi\\Renesas\\Hew\\Tools\\Renesas\\RX\\1_2_0", "new_renesas_path",
								ExamplesLoader.safeLoad("renesas_compiler"))).makeCompilerData());
	}

	protected final String ID;
	protected final String[] preferenceTreePath;
	protected final CompilerPath[] compilerSet;

	protected CompilerData(String ID, String[] treePath, CompilerPath[] set) {
		this.ID = ID;
		this.preferenceTreePath = treePath;
		this.compilerSet = set;
	}

	/**
	 * @return the iD
	 */
	public String getID() {
		return ID;
	}

	/**
	 * @return the preferenceTreePath
	 */
	public String[] getPreferenceTreePath() {
		return preferenceTreePath;
	}

	/**
	 * @return the compilerSet
	 */
	public CompilerPath[] getCompilerSet() {
		return compilerSet;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ID;
	}
}
