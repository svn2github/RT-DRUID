package com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise;

import com.eu.evidence.rtdruid.internal.modules.oil.keywords.IWritersKeywords;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IMacrosForSharedData;

public class MacrosForSharedData implements IMacrosForSharedData {

	final String indent1 = IWritersKeywords.INDENT;

	private class SharedDataWithPragma implements IPragma {
		
//		private LinkedHashMap<String, StringBuffer> pragmaBuffers = new LinkedHashMap<String, StringBuffer>();
		
		@Override
		public String getPragmaSections() {
			StringBuffer answer = new StringBuffer();
//			for (StringBuffer buff: pragmaBuffers.values()) {
//				answer.append(buff);
//				answer.append("\n\n");
//			}
			return answer.toString();
		}
		
		@Override
		public IPragma getPragma() {
			return new SharedDataWithPragma();
		}
		
		private void addElement(String section, String section_name, String name) {
//	    	StringBuffer buff;
//	    	String sep;
//	    	if (pragmaBuffers.containsKey(section)) {
//	    		buff = pragmaBuffers.get(section);
//	    		sep = ", ";
//	    	} else {
//	    		buff = new StringBuffer();
//	    		pragmaBuffers.put(section, buff);
//	    		buff.append("#pragma section "+section.toUpperCase()+" \"."+section_name+"\" \"."+section_name+"\"\n" +
//	    					"#pragma use_section "+section.toUpperCase());
//	    		sep = " ";
//	    	}
//	    	
//	    	buff.append(sep + name);

		}
		
		
		@Override
		public String vectorRamUnitialized(String type, String vectorName, String array, String body) {
			return vectorRam(type, vectorName, array, body);
		}

		
		@Override
		public String vectorRam(String type, String vectorName, String array, String body) {
//			addElement("EE_SHARED_IDATA", "mcglobald", vectorName);
//			return type + vectorName+array +body;
			return "#pragma section EE_SHARED_BEGIN /* allocate into initialized shared data section */\n" +
					"#pragma section EE_SHARED_FAST_BEGIN /* allocate into initialized shared fast data section */\n" +
					type +vectorName+array+body+
					"#pragma section EE_SHARED_FAST_END /* pragma tail */\n" +
					"#pragma section EE_SHARED_END /* pragma tail */\n";
		}

		@Override
		public String vectorRom(String type, String vectorName, String array, String body) {
//			addElement("EE_SHARED_IDATA", "mcglobald", vectorName);
//			return type + vectorName+array+body;
			return "#pragma section EE_SHARED_BEGIN /* allocate into initialized shared data section */\n" +
					"#pragma section EE_SHARED_FAST_BEGIN /* allocate into initialized shared fast data section */\n" +
					type +vectorName+array+body+
					"#pragma section EE_SHARED_FAST_END /* pragma tail */\n" +
					"#pragma section EE_SHARED_END /* pragma tail */\n";
		}

		@Override
		public String constVectorRam(String type, String vectorName, String array, String body) {
			//addElement("EE_SHARED_CDATA", "mcglobalc", vectorName);
			//return vectorName+array;
			return "#pragma section EE_SHARED_CONST_BEGIN /* allocate into shared const data section */\n" +
//					"#pragma section EE_SHARED_SCONST_BEGIN /* allocate into shared sconst data section */\n" +
					type + vectorName+array+body+
//					"#pragma section EE_SHARED_SCONST_END /* pragma tail */\n" +
					"#pragma section EE_SHARED_CONST_END /* pragma tail */\n";
		}

		@Override
		public String constVectorRom(String type, String vectorName, String array, String body) {
//			addElement("EE_SHARED_CDATA", "mcglobalc", vectorName);
//			return vectorName+array;
			return "#pragma section EE_SHARED_CONST_BEGIN /* allocate into shared const data section */\n" +
					"#pragma section EE_SHARED_SCONST_BEGIN /* allocate into shared sconst data section */\n" +
					type +vectorName+array+body+
					"#pragma section EE_SHARED_SCONST_END /* pragma tail */\n" +
					"#pragma section EE_SHARED_CONST_END /* pragma tail */\n";
		}

		@Override
		public String valueRamUnitialized(String type, String valueName, String body) {
			return valueRam(type, valueName, body);
		}

		@Override
		public String valueRam(String type, String valueName, String body) {
//			addElement("EE_SHARED_IDATA", "mcglobald", valueName);
//			return type + valueName+body;
			return "#pragma section EE_SHARED_BEGIN /* allocate into initialized shared data section */\n" +
					"#pragma section EE_SHARED_FAST_BEGIN /* allocate into initialized shared fast data section */\n" +
					type +valueName+body+
					"#pragma section EE_SHARED_FAST_END /* pragma tail */\n" +
					"#pragma section EE_SHARED_END /* pragma tail */\n";
		}

		@Override
		public String valueRom(String type, String valueName, String body) {
//			addElement("EE_SHARED_IDATA", "mcglobald", valueName);
//			return type + valueName+body;
			return "#pragma section EE_SHARED_BEGIN /* allocate into initialized shared data section */\n" +
					"#pragma section EE_SHARED_FAST_BEGIN /* allocate into initialized shared fast data section */\n" +
					type +valueName+body+
					"#pragma section EE_SHARED_FAST_END /* pragma tail */\n" +
					"#pragma section EE_SHARED_END /* pragma tail */\n";
		}

		@Override
		public String constValueRam(String type, String valueName, String body) {
//			addElement("EE_SHARED_CDATA", "mcglobalc", valueName);
//			return type + valueName+body;
			return "#pragma section EE_SHARED_CONST_BEGIN /* allocate into shared const data section */\n" +
					"#pragma section EE_SHARED_SCONST_BEGIN /* allocate into shared sconst data section */\n" +
					type +valueName+body+
					"#pragma section EE_SHARED_SCONST_END /* pragma tail */\n" +
					"#pragma section EE_SHARED_CONST_END /* pragma tail */\n";
		}

		@Override
		public String constValueRom(String type, String valueName, String body) {
//			addElement("EE_SHARED_CDATA", "mcglobalc", valueName);
//			return type + valueName+body;
			return "#pragma section EE_SHARED_CONST_BEGIN /* allocate into shared const data section */\n" +
					"#pragma section EE_SHARED_SCONST_BEGIN /* allocate into shared sconst data section */\n" +
					type +valueName+body+
					"#pragma section EE_SHARED_SCONST_END /* pragma tail */\n" +
					"#pragma section EE_SHARED_CONST_END /* pragma tail */\n";
		}

	}
	
	@Override
	public IPragma getPragma() {
		return new SharedDataWithPragma();
	}
	
	@Override
	public String vectorRamUnitialized(String type, String vectorName, String array, String body) {
		return type + "EE_SHARED_UDATA "+vectorName+array + body;
	}
	
	@Override
	public String vectorRam(String type, String vectorName, String array, String body) {
		return type + "EE_SHARED_IDATA "+vectorName+array + body;
	}

	@Override
	public String vectorRom(String type, String vectorName, String array, String body) {
		return type + "EE_SHARED_IDATA "+vectorName+array + body;
	}

	@Override
	public String constVectorRam(String type, String vectorName, String array, String body) {
		return type + "EE_SHARED_CDATA "+vectorName+array + body;
	}

	@Override
	public String constVectorRom(String type, String vectorName, String array, String body) {
		return type + "EE_SHARED_CDATA "+vectorName+array + body;
	}

	@Override
	public String valueRamUnitialized(String type, String valueName, String body) {
		return type + "EE_SHARED_UDATA "+valueName + body;
	}
	
	@Override
	public String valueRam(String type, String valueName, String body) {
		return type + "EE_SHARED_IDATA "+valueName + body;
	}

	@Override
	public String valueRom(String type, String valueName, String body) {
		return type + "EE_SHARED_IDATA "+valueName + body;
	}

	@Override
	public String constValueRam(String type, String valueName, String body) {
		return type + "EE_SHARED_CDATA "+valueName + body;
	}

	@Override
	public String constValueRom(String type, String valueName, String body) {
		return type + "EE_SHARED_CDATA "+valueName + body;
	}
	
}
