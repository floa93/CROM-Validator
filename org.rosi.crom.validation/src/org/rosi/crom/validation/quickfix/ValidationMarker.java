package org.rosi.crom.validation.quickfix;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.core.IJavaModelMarker;

import crom_l1_composed.Model;

public class ValidationMarker {
	
	public final static int VALIDATION_JDT_PROBLEM_ID = 1234;
	
	public void mark(IPath path, Resource resource) {
		// Must match the "id" attribute from plugin.xml
		String MY_MARKER_ID = "org.rosi.crom.validation.validationmarker";
		// Must not be -1 or any of the values in org.eclipse.jdt.core.compiler.IProblem

		// ....
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot root = workspace.getRoot();
		IResource coreResource = root.findMember(path);

		Model cromModel2 = (Model)resource.getContents().get(0);		
		
		IMarker marker;
		try {
			coreResource.deleteMarkers(MY_MARKER_ID, true, 1);

			marker = coreResource.createMarker(MY_MARKER_ID);	
			marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
			marker.setAttribute(IMarker.MESSAGE, "TEST");
			marker.setAttribute(IMarker.CHAR_START,0);
			marker.setAttribute(IMarker.CHAR_END, 50);
		    marker.setAttribute(IMarker.LINE_NUMBER, 1);
		    //???
			marker.setAttribute(IJavaModelMarker.ID, VALIDATION_JDT_PROBLEM_ID);
			
			
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
