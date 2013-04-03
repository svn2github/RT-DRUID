/*
 * Created on Apr 21, 2004
 */
package com.eu.evidence.rtdruid.desk;

// projects package

// standard java package
import java.util.Properties;
import java.util.Stack;

// exceptions

/**
 * @author Nicola Serreli
 */
public abstract class Messages {
	
	public final static String ENV_LOG_LEVEL = "RTDRUID_LOG_LEVEL";
	
	private static Messages current;
	private static Stack<Messages> old = new Stack<Messages>();

	public static enum LogLevel {
		none(0), error(1), warning(2), info(3), debug(4);
		
		protected final int level;
		
		private LogLevel(int level) {
			this.level = level;
		}
		
		public boolean enabled(LogLevel currentLevel) {
			return level<=currentLevel.level;
		}
		
		public boolean enabled() {
			return level<=currentLevel.level;
		}
		
		public static LogLevel parse(String txt) {
			if ("none".equalsIgnoreCase(txt)) {
				return none;
			} else if ("error".equalsIgnoreCase(txt)) {
				return error;
			} else if ("warning".equalsIgnoreCase(txt)) {
				return warning;
			} else if ("info".equalsIgnoreCase(txt)) {
				return info;
			} else if ("debug".equalsIgnoreCase(txt)) {
				return debug;
			}
			return null;
		}
	};

	protected static LogLevel currentLevel;
	
	static {
		LogLevel l = LogLevel.parse(System.getenv(ENV_LOG_LEVEL));
		if (l == null) {
			l = LogLevel.info;
		}
		currentLevel = l;
	}
	
	/** Identifies output of an error message */
	public final static int ERROR = 1;
	/** Identifies output of a warning message */
	public final static int WARNING = 2;
	/** Identifies standard output */
	public final static int OUTPUT = 3;
	/** Identifies a debug message */
	public final static int DEBUG = 4;
	
	/** Identifies if use or not "auto new line" at the end of the text */
	public final static int AUTO_NL = 1<<30;
		
//	private int
	
	/** The number of warnings */
	private int wNumber = 0;
	/** The number of errors */
	private int eNumber = 0;

	// -----------------------------
	
	/** Returns the current instance of this class
	 */
	private final static Messages instance() {
		if (current == null) {
			if (old.size() == 0) {
				// default output is to console 
				current = new Console();
			} else {
				current = (Messages) old.pop();
			}
		}
		return current;
	}

	/**
	 * @param currentLevel the currentLevel to set
	 */
	public static void setCurrentLevel(LogLevel currentLevel) {
		Messages.currentLevel = currentLevel;
	}
	
	public final static void setCurrent(Messages newMess) {
		if (newMess == null) {
			throw new NullPointerException("Try to set a null message class");
		}
		
		if (current != null) {
			old.push(current);
		}
		current = newMess;
	}
	
	public final static void setPrevious() {
		if (old.size() == 0) {
			// set to no one: the next time look for the default output 
			current = null;
		} else {
			current = (Messages) old.pop();
		}
	}
	
	// -----------------------------
	

	/** Returns the number of warnings
	 */
	public final static int getWarningNumber() {
		return instance().wNumber;
	}

	/** Returns the number of errors
	 */
	public final static int getErrorNumber() {
		return instance().eNumber;
	}
	
	/** Returns the number of errors
	 */
	public final static void clearNumbers() {
		Messages t = instance();
		t.eNumber = 0;
		t.wNumber = 0;
	}
	

	// ----------------- Output
	
	/** Sends a normal message (without New Line)
	 * 
	 * @param text contains the message
	 */
	public final static void sendText(String text) {
		if (LogLevel.info.enabled()) {
			instance().output(OUTPUT, text, text, "", new Properties());
		}
	}
	
	/** Sends a normal message (without New Line)
	 * 
	 * @param text contains the message
	 * @param detailedText like text but with more details (useful for debug)
	 * @param errorCode identifies the error (or at least where the message was generated)
	 *  @param otherInfo contains others not important info 
	 */
	public final static void sendText(String text, String detailedText, String errorCode, Properties otherInfo) {
		if (LogLevel.info.enabled()) {
			instance().output(OUTPUT, text, detailedText  == null ? text : detailedText, errorCode, otherInfo);
		}
	}
	
	/** Sends a warning (without New Line)
	 * 
	 * @param text contains the message
	 * @param detailedText like text but with more details (useful for debug)
	 * @param errorCode identifies the error (or at least where the message was generated)
	 *  @param otherInfo contains others not important info 
	 */
	public final static void sendWarning(String text, String detailedText, String errorCode, Properties otherInfo) {
		Messages t = instance();
		t.wNumber++;
		if (LogLevel.warning.enabled()) {
			t.output(WARNING, text, detailedText == null ? text : detailedText, errorCode, otherInfo);
		}
	}
	
	/** Sends an error (without New Line)
	 * 
	 * @param text contains the message
	 * @param detailedText like text but with more details (useful for debug)
	 * @param errorCode identifies the error (or at least where the message was generated)
	 *  @param otherInfo contains others not important info 
	 */
	public final static void sendError(String text, String detailedText, String errorCode, Properties otherInfo) {
		Messages t = instance();
		t.eNumber++;
		if (LogLevel.error.enabled()) {
			t.output(ERROR, text, detailedText  == null ? text : detailedText, errorCode, otherInfo);
		}
	}

	/** Sends a debug message (without New Line)
	 * 
	 * @param text contains the message
	 */
	public final static void sendDebug(String text) {
		// if debug is enabled ...
		if (LogLevel.debug.enabled())
			instance().output(DEBUG, text, text, "", new Properties());
	}
	
	/** Sends a debug message
	 * 
	 * @param text contains the message
	 * @param detailedText like text but with more details (useful for debug)
	 * @param errorCode identifies the error (or at least where the message was generated)
	 *  @param otherInfo contains others not important info 
	 */
	public final static void sendDebug(String text, String detailedText, String errorCode, Properties otherInfo) {
		// if debug is enabled ...
		if (LogLevel.debug.enabled())
			instance().output(DEBUG, text, detailedText  == null ? text : detailedText, errorCode, otherInfo);
	}

	// ----------------- Output With New Line
	
	/** Sends a normal message (with New Line)
	 * 
	 * @param text contains the message
	 */
	public final static void sendTextNl(String text) {
		if (LogLevel.info.enabled())
			instance().output(OUTPUT | AUTO_NL, text, text, "", new Properties());
	}
	
	/** Sends a normal message (with New Line)
	 * 
	 * @param text contains the message
	 * @param detailedText like text but with more details (useful for debug)
	 * @param errorCode identifies the error (or at least where the message was generated)
	 *  @param otherInfo contains others not important info 
	 */
	public final static void sendTextNl(String text, String detailedText, String errorCode, Properties otherInfo) {
		if (LogLevel.info.enabled())
			instance().output(OUTPUT | AUTO_NL, text, detailedText  == null ? text : detailedText, errorCode, otherInfo);
	}
	
	/** Sends a warning (with New Line)
	 * 
	 * @param text contains the message
	 */
	public final static void sendWarningNl(String text) {
		sendWarningNl(text, text, "", new Properties());
	}
	
	/** Sends a warning (with New Line)
	 * 
	 * @param text contains the message
	 * @param detailedText like text but with more details (useful for debug)
	 * @param errorCode identifies the error (or at least where the message was generated)
	 *  @param otherInfo contains others not important info 
	 */
	public final static void sendWarningNl(String text, String detailedText, String errorCode, Properties otherInfo) {
		Messages t = instance();
		t.wNumber++;
		if (LogLevel.warning.enabled())
			t.output(WARNING | AUTO_NL, text, detailedText == null ? text : detailedText, errorCode, otherInfo);
	}
	
	/** Sends an error (with New Line)
	 * 
	 * @param text contains the message
	 * @param detailedText like text but with more details (useful for debug)
	 * @param errorCode identifies the error (or at least where the message was generated)
	 *  @param otherInfo contains others not important info 
	 */
	public final static void sendErrorNl(String text, String detailedText, String errorCode, Properties otherInfo) {
		Messages t = instance();
		t.eNumber++;
		if (LogLevel.error.enabled())
			t.output(ERROR | AUTO_NL, text, detailedText  == null ? text : detailedText, errorCode, otherInfo);
	}

	/** Sends a debug message (with New Line)
	 * 
	 * @param text contains the message
	 */
	public final static void sendDebugNl(String text) {
		// if debug is enabled ...
		if (LogLevel.debug.enabled())
			instance().output(DEBUG | AUTO_NL, text, text, "", new Properties());
	}
	
	/** Sends a debug message (with New Line)
	 * 
	 * @param text contains the message
	 * @param detailedText like text but with more details (useful for debug)
	 * @param errorCode identifies the error (or at least where the message was generated)
	 *  @param otherInfo contains others not important info 
	 */
	public final static void sendDebugNl(String text, String detailedText, String errorCode, Properties otherInfo) {
		// if debug is enabled ...
		if (LogLevel.debug.enabled())
			instance().output(DEBUG | AUTO_NL, text, detailedText  == null ? text : detailedText, errorCode, otherInfo);
	}

	
	// ------------- ABSTRACT

	/** Sends a custom message.
	 * 
	 * @param Type is one of {@link Messages#OUTPUT OUTPUT}, {@link Messages#WARNING WARNING} and
	 *			  {@link Messages#ERROR ERROR}
	 * @param text contains the message
	 * @param detailedText like text but with more details (useful for debug)
	 * @param errorCode identifies the error (or at least where the message was generated)
	 *  @param otherInfo contains others not important info 
	 */
	protected abstract void output(int type, String text, String detailedText, String errorCode, Properties otherInfo);
	
}

//---------------------- PRIVATE CLASSES

class Console extends Messages {
	
	private final static boolean DETAILED = false;//true;
		
	/** Sends a custom message.
	 * 
	 * @param Type is one of {@link Messages#OUTPUT OUTPUT}, {@link Messages#WARNING WARNING} and
	 *			  {@link Messages#ERROR ERROR}
	 * @param text contains the message
	 * @param detailedText like text but with more details (useful for debug)
	 * @param errorCode identifies the error (or at least where the message was generated)
	 *  @param otherInfo contains others not important info 
	 */
	protected void output(int type, String text, String detailedText, String errorCode, Properties otherInfo) {
		String t;
		if (DETAILED) {
			t = detailedText + 
				( errorCode != null ? ( errorCode.length() != 0 ? "\nCode = " +errorCode : "" ) : "" ) + 
				(otherInfo != null ? (otherInfo.size() != 0 ? "\n" + otherInfo : "" ) : "");
			
		} else {
			t = text;
		}

		switch (type) {
				case OUTPUT :
							System.out.print(t);
							break;
				case OUTPUT | AUTO_NL:
							System.out.println(t);
							break;
						
				case WARNING :
							System.out.print("WARNING > " + t);
							break;
				case WARNING | AUTO_NL:
							System.out.println("WARNING > " + t);
							break;

				case DEBUG :
							System.out.print("DEBUG > " + t);
							break;
				case DEBUG | AUTO_NL:
							System.out.println("DEBUG > " + t);
							break;

				case ERROR :
							System.err.print("ERROR > " + text);
							break;
				case ERROR | AUTO_NL:
				default :
							System.err.println("ERROR > " + text);
							break;
			}
	}

}
