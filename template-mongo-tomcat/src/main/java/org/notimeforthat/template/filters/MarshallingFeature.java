package org.notimeforthat.template.filters;

import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;

/**
 * Created by christianbraun on 06/01/17.
 */
public class MarshallingFeature implements Feature {

	@Override
	public boolean configure(FeatureContext featureContext) {
		featureContext.register(CustomJsonProvider.class);
		return true;
	}
}
