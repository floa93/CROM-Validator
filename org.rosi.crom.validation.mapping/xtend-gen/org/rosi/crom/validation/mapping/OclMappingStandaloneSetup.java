/**
 * generated by Xtext 2.15.0
 */
package org.rosi.crom.validation.mapping;

import org.rosi.crom.validation.mapping.OclMappingStandaloneSetupGenerated;

/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
@SuppressWarnings("all")
public class OclMappingStandaloneSetup extends OclMappingStandaloneSetupGenerated {
  public static void doSetup() {
    new OclMappingStandaloneSetup().createInjectorAndDoEMFRegistration();
  }
}