package org.rosi.crom.validation.popup.actions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.rosi.crom.validation.config.ConfigGenerator;
import org.rosi.crom.validation.validator.CROMValidator;


public class ValidateAction implements IObjectActionDelegate {

	private Shell shell;
	private ISelection selection;
	
	public ValidateAction() {
		super();
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	@Override
	public final void setActivePart(IAction action, IWorkbenchPart targetPart) {
		shell = targetPart.getSite().getShell();
		selection = targetPart.getSite().getSelectionProvider().getSelection();
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	@Override
	public final void run(IAction action) {		
		if (selection == null || shell == null || selection.isEmpty())
			return;
		IStructuredSelection i = (IStructuredSelection) selection;
		List<IPath> list = new ArrayList<IPath>();
		List<String> errors = new ArrayList<String>();
		for (Object f : i.toList()) {
			if (f != null && f instanceof IFile) {
				IPath p = ((IFile) f).getFullPath();
				if (p != null)
					list.add(p);
			}
		}
		
		// Create a resource set to hold the resources.
		//
		ResourceSet resourceSet = new ResourceSetImpl();

		// Register the appropriate resource factory to handle all file
		// extensions.
		//
		resourceSet
				.getResourceFactoryRegistry()
				.getExtensionToFactoryMap()
				.put(Resource.Factory.Registry.DEFAULT_EXTENSION,
						new XMIResourceFactoryImpl());
		
		for (IPath p : list) {			
			try {
				final Resource resourceCROM = resourceSet.getResource(
						URI.createURI(p.toString()), true);
				
				// Evaluate the given CROM model
				Job job = new WorkspaceJob("Validating CROM...") {
					public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {	
						ConfigGenerator configGenerator = new ConfigGenerator(shell, p, resourceSet, resourceCROM);
						configGenerator.generate(false);

						CROMValidator validator = new CROMValidator(shell);
						validator.validate(p, resourceCROM);
						
						return Status.OK_STATUS;
					}
				};
				job.setUser(true);
				job.schedule();				
				
			} catch (Exception exception) {
				exception.printStackTrace();
				errors.add("[Error:] " + p.toString() + " "
						+ exception.getClass().getSimpleName() + " "
						+ exception.getMessage());
			}
			finally {
				
			}
		}
		if (!errors.isEmpty()) {
			String s = "";
			for (String e : errors)
				s += e + "\n";
			MessageDialog.openError(shell,
					"Could not validate the selected CROM file", s);
		}
		
	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	@Override
	public final void selectionChanged(IAction action, ISelection selection) {
	}

}
