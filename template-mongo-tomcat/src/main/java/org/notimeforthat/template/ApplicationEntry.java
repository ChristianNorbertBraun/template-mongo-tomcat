package org.notimeforthat.template;

import org.notimeforthat.template.filters.MarshallingFeature;
import org.notimeforthat.template.resources.HelloWorldResource;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by christianbraun on 06/01/17.
 */
@ApplicationPath("/api")
public class ApplicationEntry extends Application{
	@Override
	public Set<Class<?>> getClasses() {
		final Set<Class<?>> resources = new HashSet<>();
		resources.add(MarshallingFeature.class);

		resources.add(HelloWorldResource.class);

		return resources;
	}
}
