/*
 * generated by Xtext
 */
package org.osate.xtext.aadl2.ui;

import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class Aadl2ExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return org.osate.xtext.aadl2.ui.internal.Aadl2Activator.getInstance().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return org.osate.xtext.aadl2.ui.internal.Aadl2Activator.getInstance().getInjector("org.osate.xtext.aadl2.Aadl2");
	}
	
}