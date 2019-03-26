package org.rosi.crom.validation.quickfix;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.ui.IMarkerResolution;
import org.eclipse.ui.IMarkerResolutionGenerator;

public class ValidationMarkerResolution implements IMarkerResolutionGenerator {

    public IMarkerResolution[] getResolutions(IMarker arg0) {
           
            return new IMarkerResolution[0];
    }
}
