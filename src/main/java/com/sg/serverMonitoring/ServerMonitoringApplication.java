package com.sg.serverMonitoring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import com.sg.serverMonitoring.jschLib.JschLib;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class ServerMonitoringApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerMonitoringApplication.class, args);
		JschLib test = new JschLib();

		test.run();
	}

}
