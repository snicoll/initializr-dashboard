package io.spring.sample.initializrdashboard;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("dashboard")
public class DashboardProperties {

	private ReverseLookup reverseLookup = new ReverseLookup();

	public ReverseLookup getReverseLookup() {
		return reverseLookup;
	}

	public static class ReverseLookup {

		/**
		 * Read timeout for the IP resolver API in ms
		 */
		private int timeout = 4_000;

		public int getTimeout() {
			return timeout;
		}

		public void setTimeout(int timeout) {
			this.timeout = timeout;
		}
	}
}
