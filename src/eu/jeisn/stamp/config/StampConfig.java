package eu.jeisn.stamp.config;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class StampConfig extends ResourceConfig {
	public StampConfig() {
		packages("eu.jeisn.stamp.controllers", "org.postgresql");	
		register(JacksonFeature.class);
	}
}
