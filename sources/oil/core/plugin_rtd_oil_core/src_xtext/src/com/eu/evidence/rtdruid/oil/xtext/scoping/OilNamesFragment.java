package com.eu.evidence.rtdruid.oil.xtext.scoping;

import java.util.Set;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.generator.DefaultGeneratorFragment;
import org.eclipse.xtext.naming.IQualifiedNameProvider;

/**
 */
public class OilNamesFragment extends DefaultGeneratorFragment {

	@Override
	public Set<Binding> getGuiceBindingsRt(Grammar grammar) {
		return new BindFactory()
			.addfinalTypeToType(IQualifiedNameProvider.class.getName(), OilNamesProvider.class.getName())
			.getBindings();
	}

	@Override
	public Set<Binding> getGuiceBindingsUi(Grammar grammar) {
		return new BindFactory()
		.addTypeToType("org.eclipse.xtext.ui.refactoring.IDependentElementsCalculator",
				"org.eclipse.xtext.ui.refactoring.impl.DefaultDependentElementsCalculator")
		.getBindings();
	}
}
