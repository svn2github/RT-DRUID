/*******************************************************************************
 * Copyright (c) 2000, 2004 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.eu.evidence.rtdruid.modules.oil.codewriter.common.xsltcodegeneration;

/**
 */
public interface IModelListener {
	String ADDED="__added"; //$NON-NLS-1$
	String REMOVED="__removed"; //$NON-NLS-1$
	String CHANGED = "__changed"; //$NON-NLS-1$
	void modelChanged(IXsltWriterTransformation[] objects, String type, String property);
}