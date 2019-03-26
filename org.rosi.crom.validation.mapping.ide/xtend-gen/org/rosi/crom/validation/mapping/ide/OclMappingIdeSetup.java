/**
 * generated by Xtext 2.15.0
 */
package org.rosi.crom.validation.mapping.ide;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.eclipse.xtext.util.Modules2;
import org.rosi.crom.validation.mapping.OclMappingRuntimeModule;
import org.rosi.crom.validation.mapping.OclMappingStandaloneSetup;
import org.rosi.crom.validation.mapping.ide.OclMappingIdeModule;

/**
 * Initialization support for running Xtext languages as language servers.
 */
@SuppressWarnings("all")
public class OclMappingIdeSetup extends OclMappingStandaloneSetup {
  @Override
  public Injector createInjector() {
    OclMappingRuntimeModule _oclMappingRuntimeModule = new OclMappingRuntimeModule();
    OclMappingIdeModule _oclMappingIdeModule = new OclMappingIdeModule();
    return Guice.createInjector(Modules2.mixin(_oclMappingRuntimeModule, _oclMappingIdeModule));
  }
}