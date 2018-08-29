package io.spring.sample.initializrdashboard.stats;

public class Client {

	private String ip;
	private String hostname;

	public Client(String ip, String hostname) {
		this.ip = ip;
		this.hostname = hostname;
	}

	public String getIp() {
		return ip;
	}

	public String getHostname() {
		return hostname;
	}
}
