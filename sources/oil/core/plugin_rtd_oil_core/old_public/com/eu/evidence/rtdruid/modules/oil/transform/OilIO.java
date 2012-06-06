package com.eu.evidence.rtdruid.modules.oil.transform;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.eu.evidence.rtdruid.internal.modules.oil.reader.OilReader;
import com.eu.evidence.rtdruid.io.IRTDExporter;
import com.eu.evidence.rtdruid.io.IRTDImporter;
import com.eu.evidence.rtdruid.modules.oil.implementation.IOilImplID;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.VarTreeUtil;
import com.eu.evidence.rtdruid.vartree.tools.Search;

public class OilIO implements IRTDImporter, IRTDExporter {
	

	@Override
	public EObject load(InputStream input, Map<?, ?> options) throws IOException {
		return load(input, null, options);
	}

	public EObject load(InputStream input, IVarTree vt, Map<?, ?> options) throws IOException {
		if (input == null) {
			throw new NullPointerException("Null input");
		}
		
		if (vt == null) {
			vt = VarTreeUtil.newVarTree();
		}
		
		String fileName = null;
		String filePath = null;
		if (options != null && options.containsKey(OPT_FILE_FULLNAME)) {
			IPath path = new Path((String) options.get(OPT_FILE_FULLNAME));
			fileName = path.lastSegment();
			filePath = path.removeLastSegments(1).toOSString();
		}

		(new OilReader()).load(input, vt, fileName, filePath);
		
		EList<Resource> resList = vt.getResourceSet().getResources();
		EList<EObject> objList = resList!=null && resList.size()>0 ? resList.get(0).getContents() : null;
		return objList!=null && objList.size()>0 ? objList.get(0) : null;
	}

	@Override
	public void export(OutputStream output, EObject data, Map<?, ?> options)
			throws IOException {
		if (output == null) {
			throw new NullPointerException("Null output");
		}
		
		IVarTree vt = VarTreeUtil.newVarTree();
		vt.setRoot(data);
		
		OilTransformFactory otf = OilTransformFactory.INSTANCE;
		final String EE_ID = "ee"; 
		IOilImplID id = otf.getOilId(EE_ID);
		String answer = otf.getTransform(EE_ID).write(vt, id, Search.allRtos(vt.newTreeInterface()));

		if (answer != null) {
			output.write(answer.getBytes());
		}
		
	}
}
