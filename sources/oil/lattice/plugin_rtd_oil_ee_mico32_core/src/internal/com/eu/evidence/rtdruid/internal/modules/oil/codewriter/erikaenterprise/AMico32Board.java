package com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

import com.eu.evidence.rtdruid.desk.RtdruidLog;
import com.eu.evidence.rtdruid.internal.modules.oil.exceptions.OilCodeWriterException;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.IWritersKeywords;
import com.eu.evidence.rtdruid.internal.modules.oil.mico32.constants.Mico32Constants;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilObjectList;
import com.eu.evidence.rtdruid.modules.oil.abstractions.ISimpleGenRes;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments.CommentsManager;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments.FileTypes;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments.ICommentWriter;

/**
 * Generic handler for mico32 boards
 * 
 * @author Nicola Serreli
 */
public abstract class AMico32Board {

	protected static final String  INDEX_PLACER = "#XXX#";
	protected static final String indent1 = IWritersKeywords.INDENT;
	
	protected static enum IrqType {uart, spi, timer, i2c, gpio};

	protected static class Indexes {
		/** index of used uart */
		int uart  = 0;
		/** index of used spi */
		int spi   = 0;
		/** index of used timer */
		int timer = 0;
		/** index of used i2c */
		int i2c   = 0;
		/** index of used gpio */
		int gpio   = 0;
		
		public int getIndex(IrqType type) {
			switch (type) {
			case uart:
				return uart;
			case spi:
				return spi;
			case timer:
				return timer;
			case i2c:
				return i2c;
			case gpio:
				return gpio;
			default:
				break;
			}
			return 0;
		}
		
		public void increaseIndex(IrqType type) {
			switch (type) {
			case uart:	uart++;		break;
			case spi:	spi++;		break;
			case timer:	timer++;	break;
			case i2c:	i2c++;		break;
			case gpio:	gpio++;		break;
			default:
				break;
			}
		}

	}

	protected static class IndexedOption {
		final String[] define;
		final String[] eeopt;
		final IrqType type;
		
		public IndexedOption(String[] define, IrqType type) {
			this.define = define;
			this.eeopt = new String[0];
			this.type = type;
		}
		
//		public IndexedOption(String[] define, String[] eeopt, IrqType type) {
//			this.define = define;
//			this.eeopt = eeopt;
//			this.type = type;
//		}
		
		public void updateIndexes(Indexes indexes) {
			indexes.increaseIndex(type);
		}
		
		public String[] computeEeopt(Indexes indexes) {
			int index = indexes.getIndex(type);
			
			String[] answer = new String[eeopt.length];
			for (int i=0; i<eeopt.length; i++) {
				
				if (!eeopt[i].contains(INDEX_PLACER)) {
					throw new RuntimeException();
				}
				answer[i] = eeopt[i].replaceAll(INDEX_PLACER, ""+index);
			}
			return answer;
		}
		
		public String[] computeDefine(Indexes indexes) {
			int index = indexes.getIndex(type);
			
			String[] answer = new String[define.length];
			for (int i=0; i<define.length; i++) {
				
				if (!define[i].contains(INDEX_PLACER)) {
					throw new RuntimeException();
				}
				answer[i] = define[i].replaceAll(INDEX_PLACER, ""+index);
			}
			return answer;
		}
	}
	
	protected static class UniqueIndexedOption extends IndexedOption {
		public UniqueIndexedOption(String[] define, IrqType type) {
			super(define, type);
		}
	}

	
	
	protected static class BoardOption {
		final String ID;
		
		final String[] define;
		final IndexedOption[] complexDefine;
		final String[] eeopt;
		final String warning;
		
		final int group;
		
		public BoardOption(String ID, String[] define, String[] eeopt) {
			this(ID, define, null, eeopt, null, -1);
		}
		public BoardOption(String ID, IndexedOption[] complexDefine, String[] eeopt) {
			this(ID, null, complexDefine, eeopt, null, -1);
		}
		public BoardOption(String ID, String[] define, IndexedOption[] complexDefine, String[] eeopt) {
			this(ID, define, complexDefine, eeopt, null, -1);
		}
		public BoardOption(String ID, String[] define, String[] eeopt, String warning) {
			this(ID, define, null, eeopt, warning, -1);
		}
		public BoardOption(String ID, String[] define, String[] eeopt, int group) {
			this(ID, define, null, eeopt, null, group);
		}
		public BoardOption(String ID, String[] define, IndexedOption[] complexDefine, String[] eeopt, String warning, int group) {
			this.ID = ID;
			this.define = define == null ? new String[0] : define.clone();
			this.complexDefine = complexDefine == null ? new IndexedOption[0] : complexDefine.clone();
			this.eeopt = eeopt == null ? new String[0] : eeopt.clone();
			this.warning = warning;
			this.group = group;
		}
		
		@Override
		public int hashCode() {
			return ID.hashCode();
		}
	}

	// --------------------------
	
	protected final static int GROUP_ZIGBEE = 1;
	protected final static int GROUP_ETHERNET = 2;
	protected static int GROUP_GENERIC = GROUP_ETHERNET | GROUP_ZIGBEE;
	
	protected static BoardOption addOptions(ArrayList<BoardOption> options,
			String ID, String[] define, String[] eeopt) {
		return addOptions(options, ID, define, null, eeopt, null, GROUP_GENERIC);
	}
	protected static BoardOption addOptions(ArrayList<BoardOption> options,
			String ID, IndexedOption[] complexDefine, String[] eeopt) {
		return addOptions(options, ID, null, complexDefine, eeopt, null, GROUP_GENERIC);
	}
	protected static BoardOption addOptions(ArrayList<BoardOption> options,
			String ID, String[] define, IndexedOption[] complexDefine, String[] eeopt) {
		return addOptions(options, ID, define, complexDefine, eeopt, null, GROUP_GENERIC);
	}
	protected static BoardOption addOptions(ArrayList<BoardOption> options,
			String ID, String[] define, IndexedOption[] complexDefine, String[] eeopt, int group) {
		return addOptions(options, ID, define, complexDefine, eeopt, null, group);
	}
	protected static BoardOption addOptions(ArrayList<BoardOption> options,
			String ID, String[] define, String[] eeopt, String warning) {
		return addOptions(options, ID, define, null, eeopt, warning, GROUP_GENERIC);
	}
	protected static BoardOption addOptions(ArrayList<BoardOption> options,
			String ID, String[] define, IndexedOption[] complexDefine, String[] eeopt, String warning, int group) {

		BoardOption tmp = null;

		if (!options.contains(ID)) {
//			System.out.println("ID -> " + ID + " = " + ID.hashCode());
			options.add(tmp = new BoardOption(ID, define, complexDefine, eeopt, warning, group));
//			System.out.println("\t" + tmp.hashCode());
		} else {
			RtdruidLog.showDebug("Found more than one option with the same ID: " + ID);
		}
		return tmp;
	}

	
	protected abstract String getBoardName(); 
	

	
	protected void parseOptions(int all, Indexes indexes,
			StringBuffer definitions, List<BoardOption> availableOptions,
			HashSet<String> foundOptions, ArrayList<String> eeoptions,
			CommentsManager commentManager) throws OilCodeWriterException {
		 
		String space = "";
		int found_group = all;
		
		final ICommentWriter commentWriter = commentManager.getCommentWriter(FileTypes.H);
//		ArrayList<UniqueIndexedOption> unique = new ArrayList<UniqueIndexedOption>();
		

		// first identify shared options
		LinkedHashMap<UniqueIndexedOption, ArrayList<String>> sharedUniqueOptions = new LinkedHashMap<AMico32Board.UniqueIndexedOption, ArrayList<String>>();
		for (BoardOption option : availableOptions) {
			
			// store this option only if it is enabled by the user or if it is compatible
			// with the "all" category
			if (foundOptions.contains(option.ID) || (option.group & all) > 0) {
				for (IndexedOption complexDefine: option.complexDefine) {
					if (complexDefine instanceof UniqueIndexedOption) {
						ArrayList<String> optionIds;
						if (sharedUniqueOptions.containsKey(complexDefine)) {
							optionIds = sharedUniqueOptions.get(complexDefine);
						} else {
							optionIds = new ArrayList<String>();
							sharedUniqueOptions.put((UniqueIndexedOption) complexDefine, optionIds);
						}
						optionIds.add(option.ID);
					}
				}
			}
		}
		
		
		
		
		for (BoardOption option : availableOptions) {
			
			// store this option only if it is enabled by the user or if it is compatible
			// with the "all" category
			if (foundOptions.contains(option.ID) || (option.group & all) > 0) {
				
				// check if the group is compatible with the current group
				if (found_group == 0) {
					// init the group
					found_group = option.group == GROUP_GENERIC ? 0 : option.group; 
				} else {
					if ( (option.group & found_group) == 0 ) {
						throw new OilCodeWriterException (getBoardName() + ": it is illegal to required both ETHERNET and ZIGBEE options");
					}
				}
				
				
				for (String eeopt: option.eeopt) {
					eeoptions.add(eeopt);
				}
				
				if (option.define.length > 0 || option.complexDefine.length > 0) {
					
					StringBuffer tempDefinition = new StringBuffer();
					for (String define: option.define) {
						tempDefinition.append(indent1 + "#define "+ define + "\n");
						
						Mico32McuLattice.addIfDefIrqWithCheck(define, tempDefinition);
					}
					

					for (IndexedOption complexDefine: option.complexDefine) {
						
						if (complexDefine instanceof UniqueIndexedOption) {
							
							if (sharedUniqueOptions.containsKey((UniqueIndexedOption)complexDefine) 
									&& sharedUniqueOptions.get((UniqueIndexedOption)complexDefine).size()>1) {
								continue;
							}
						}
						
						complexDefine.updateIndexes(indexes);
						String[] eeopts = complexDefine.computeEeopt(indexes);
						for (String eeopt: eeopts) {
							eeoptions.add(eeopt);
						}

						String[] defines = complexDefine.computeDefine(indexes);
						for (String define : defines) {
							tempDefinition.append(indent1 + "#define "+ define + "\n");
						
							Mico32McuLattice.addIfDefIrqWithCheck(define, tempDefinition);
						}
					}
					
					
					if (tempDefinition.length() > 0) {
						definitions.append(space +
								indent1 + commentWriter.writerSingleLineComment(getBoardName() + " option " + option.ID)
								+ tempDefinition);

					}
					
				}
				
				space = "\n";

			}
		}

		
		for (Entry<UniqueIndexedOption, ArrayList<String>> sharedUniqueOption : sharedUniqueOptions.entrySet()) {
		
			UniqueIndexedOption complexDefine = sharedUniqueOption.getKey();
			ArrayList<String> optionIDs = sharedUniqueOption.getValue();
			
			if (optionIDs.size() > 1) {

					
				StringBuffer tempDefinition = new StringBuffer();
					
				
				complexDefine.updateIndexes(indexes);
				String[] eeopts = complexDefine.computeEeopt(indexes);
				for (String eeopt: eeopts) {
					eeoptions.add(eeopt);
				}

				String[] defines = complexDefine.computeDefine(indexes);
				for (String define : defines) {
					tempDefinition.append(indent1 + "#define "+ define + "\n");
				
					Mico32McuLattice.addIfDefIrqWithCheck(define, tempDefinition);
				}
				if (tempDefinition.length() > 0) {
					StringBuffer comment = new StringBuffer(getBoardName() + " shared option for");
					for (String optionID : optionIDs) 
						comment.append(" " + optionID);
					
					definitions.append(space +
							indent1 + commentWriter.writerSingleLineComment(comment.toString())
							+ tempDefinition);

				}
				
				space = "\n";

			}
		}

	}
	
	
	protected void updateOs(ISimpleGenRes os, StringBuffer definitions, Indexes indexes) {

		String base = "";

		if (os.containsProperty(Mico32Constants.SGRK__MICO32_BOARD_EEC_DEFINES__)) {
			base = os.getString(Mico32Constants.SGRK__MICO32_BOARD_EEC_DEFINES__) + "\n";
		}
		os.setProperty(Mico32Constants.SGRK__MICO32_BOARD_EEC_DEFINES__,
				base + definitions.toString());
		
		
		os.setObject(Mico32Constants.SGRK__MICO32_LAST_USED_UART__Integer, new Integer(indexes.uart));
		os.setObject(Mico32Constants.SGRK__MICO32_LAST_USED_SPI__Integer, new Integer(indexes.spi));
		os.setObject(Mico32Constants.SGRK__MICO32_LAST_USED_TIMER__Integer, new Integer(indexes.timer));
		os.setObject(Mico32Constants.SGRK__MICO32_LAST_USED_I2C__Integer, new Integer(indexes.i2c));
		os.setObject(Mico32Constants.SGRK__MICO32_LAST_USED_GPIO__Integer, new Integer(indexes.gpio));
	}
	
	public abstract void updateObjects(final IOilObjectList[] oilObjects, ArrayList<String> eeoptions) throws OilCodeWriterException;
	
	public abstract void check(String path);
}
