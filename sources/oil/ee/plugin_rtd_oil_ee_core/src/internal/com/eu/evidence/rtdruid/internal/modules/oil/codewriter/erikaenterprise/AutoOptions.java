/**
 * Created on 30/set/2008
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise;

import java.util.List;

import org.eclipse.core.runtime.Assert;

import com.eu.evidence.rtdruid.modules.oil.codewriter.common.CommonUtils;
import com.eu.evidence.rtdruid.vartree.IVarTree;

/**
 * This class can be used to add a keyword every time a specific option inside
 * the tree.
 * 
 * UPDRTD finire di commentare
 * 
 * @author Nicola Serreli
 */
public class AutoOptions {

	/**
	 * This parameter is used to check immediately if a key already exist in the
	 * keyset.
	 * 
	 * <b> IMPORTANT if defaultKeyword and writerKeyword can be different, this
	 * option MUST be disabled !!</b>
	 */
	private static final boolean FAST_CHECK = true;

	protected final String vtPath;
	protected final String oilWord;
	protected final String writerKeyword;
	protected final String enableValue;
	protected final String defaultKeyword;

	
	/**
	 * 
	 * @param vtPath
	 *            the base path inside the tree
	 * @param oilWord
	 *            the oil word that identify this option
	 * @param enableValue
	 *            the value that enable this option
	 * @param keyword
	 *            the keyword that is added if this option is enabled
	 * @param defaultKeyword
	 *            if true, this option is enable by default
	 * 
	 * @throws NullPointerException
	 *             if one parameter, except defaultKeyword, is null
	 */
	public AutoOptions(String vtPath, String oilWord, String enableValue,
			String keyword, boolean defaultEnabled) {
		this(vtPath, oilWord, enableValue, keyword, defaultEnabled == true ? keyword : null);
	}
	
	/**
	 * 
	 * @param vtPath
	 *            the base path inside the tree
	 * @param oilWord
	 *            the oil word that identify this option
	 * @param enableValue
	 *            the value that enable this option
	 * @param keyword
	 *            the keyword that is added if this option is enabled
	 * @param defaultKeyword
	 *            default value. Can be null, if there isn't a default Value
	 * 
	 * @throws NullPointerException
	 *             if one parameter, except defaultKeyword, is null
	 */
	private AutoOptions(String vtPath, String oilWord, String enableValue,
			String keyword, String defaultKeyword) {
		Assert.isNotNull(vtPath);
		Assert.isNotNull(oilWord);
		Assert.isNotNull(keyword);
		Assert.isNotNull(enableValue);

		this.vtPath = vtPath;
		this.oilWord = oilWord;
		this.writerKeyword = keyword;
		this.enableValue = enableValue;
		this.defaultKeyword = defaultKeyword;
	}

	/**
	 * @return the defaultKeyword
	 */
	public String getDefaultKeyword() {
		return defaultKeyword;
	}

	/**
	 * @return the enableValue
	 */
	public String getEnableValue() {
		return enableValue;
	}

	/**
	 * @return the oilWord
	 */
	public String getOilWord() {
		return oilWord;
	}

	/**
	 * @return the vtPath
	 */
	public String getVtPath() {
		return vtPath;
	}

	/**
	 * @return the writerKeyword
	 */
	public String getWriterKeyword() {
		return writerKeyword;
	}

	/*
	 * 
	 * 
	 * 
	 */

	/**
	 * This method checks if required options are enabled or not and it updates
	 * the keyword list
	 */
	public static void updateKeywords(List<AutoOptions> options,
			List<String> keywords, IVarTree vt) {

		for (AutoOptions opt : options) {
			updateKeywords(opt, keywords, vt);
		}
	}

	/**
	 * This method updates the keyword list if a required option is present
	 * inside the tree.
	 */
	public static void updateKeywords(AutoOptions opt, List<String> keywords,
			IVarTree vt) {
		
		if (FAST_CHECK) {
			if (keywords.contains(opt.getWriterKeyword())) {
				return;
			}
		}
		
		String value = CommonUtils.getFirstChildEnumType(vt, opt.getVtPath()
				+ opt.getOilWord());

		String key = null;
		if (value == null) {
			// use default value
			key = opt.getDefaultKeyword();
		} else if (opt.getEnableValue().equals(value)) {
			key = opt.getWriterKeyword();
		}

		if (key != null) {

			if (!FAST_CHECK) {
				if (keywords.contains(key)) {
					return;
				}
			}
			
			keywords.add(key);
		}
	}

}
