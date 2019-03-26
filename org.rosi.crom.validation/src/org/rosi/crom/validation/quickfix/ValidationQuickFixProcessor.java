package org.rosi.crom.validation.quickfix;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.ui.text.java.IInvocationContext;
import org.eclipse.jdt.ui.text.java.IJavaCompletionProposal;
import org.eclipse.jdt.ui.text.java.IProblemLocation;
import org.eclipse.jdt.ui.text.java.IQuickFixProcessor;

public class ValidationQuickFixProcessor implements IQuickFixProcessor {

	  @Override
	  public IJavaCompletionProposal[] getCorrections(IInvocationContext context, IProblemLocation[] locations) throws CoreException {
	    if (locations == null || locations.length == 0) {
	      // https://bugs.eclipse.org/444120 Eclipse can call this method without
	      // any locations, if a quick fix is requested without any problems.
	      return null;
	    }

	    IJavaCompletionProposal[] proposals = null;
	    
	   // IJavaCompletionProposal prop = new IJavaCompletionProposal();
	    //...
	    return proposals;
	  }

	  @Override
	  public boolean hasCorrections(ICompilationUnit unit, int problemId) {
		System.out.println(problemId);
	    return problemId == ValidationMarker.VALIDATION_JDT_PROBLEM_ID;
	  }
	}