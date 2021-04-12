package com.spring.boot.lab.actuator.health;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 *
 * @author manueljordan
 *
 */
@Component
@Profile("actuator")
public class SpringHostEndpoint implements HealthIndicator {

	@Override
	public Health health() {
		String host = "https://spring.io";
		if(checkHost(host)) {
			return Health.up().withDetail("Host", host)
					          .withDetail("Message", "Hostavailable")
					          .build();
		}
		else {
			return Health.down().withDetail("Host", host)
								.withDetail(host, "Host NOT available")
								.build();
		}
	}

	private static boolean checkHost(String url) {
		try {
			URL host = new URL(url);
			URLConnection urlConnection = host.openConnection();
			urlConnection.connect();
			return true;
		}
		catch (IOException ex) {
			return false;
		}
	}

}