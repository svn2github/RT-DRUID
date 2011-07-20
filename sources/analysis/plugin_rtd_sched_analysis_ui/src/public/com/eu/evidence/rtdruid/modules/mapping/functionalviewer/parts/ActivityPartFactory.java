/*
 * Created on Feb 21, 2005
 *
 * $Id: ActivityPartFactory.java,v 1.1 2005/09/28 15:22:30 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.mapping.functionalviewer.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;

import com.eu.evidence.rtdruid.modules.mapping.functionalviewer.model.GComponent;
import com.eu.evidence.rtdruid.modules.mapping.functionalviewer.model.GConnection;
import com.eu.evidence.rtdruid.modules.mapping.functionalviewer.model.GProvidedMethod;
import com.eu.evidence.rtdruid.modules.mapping.functionalviewer.model.GSubsystem;
import com.eu.evidence.rtdruid.modules.mapping.functionalviewer.model.GSystem;
import com.eu.evidence.rtdruid.modules.mapping.functionalviewer.model.GVar;


/**
 * 
 * TODO : Commentare && Tradurre
 * 
 * @author Nicola Serreli
 */
public class ActivityPartFactory implements EditPartFactory {

	public EditPart createEditPart(EditPart context, Object model) {
		EditPart part = null;
		if (model instanceof GSystem)
			part = new ActivityDiagramPart();
		else if (model instanceof GSubsystem)
			part = new SubSystemActivityPart();
		else if (model instanceof GVar)
			part = new VarActivityPart();
		else if (model instanceof GComponent)
			part = new SimpleActivityPart();
		else if (model instanceof GConnection)
			part = new TransitionPart();
		else if (model instanceof GProvidedMethod)
			part = new ProvidedMethodPart();
		part.setModel(model);
		return part;
	}

}