package com.sg.serverMonitoring.jschLib;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class JschLib {
	String host = "106.10.34.176";
	String user = "root";
	String password = "Gni1234!";
	int port = 8080;
	String command = "free";

	public void run() {
		Session session = null;
		ChannelExec channel = null;
		try {
			JSch jsch = new JSch();
			session = jsch.getSession(user, host, port);
			// 패스워드 설정
			session.setPassword(password);

			Properties config = new Properties();
			config.put("StrictHostKeyChecking", "no");
			session.setConfig(config);

			session.connect();

			channel = (ChannelExec) session.openChannel("exec");
			channel.setCommand(command);

			InputStream in = channel.getInputStream();
			channel.connect();

			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			System.out.println("성공");

		} catch (JSchException e) {
			e.printStackTrace();
			System.out.println("실패");
		} catch (IOException ioe) {
			ioe.printStackTrace();
			System.out.println("실패");
		} finally {
			if (channel != null) {
				channel.disconnect();
			}
			if (session != null) {
				session.disconnect();
			}
		}

	}
}
