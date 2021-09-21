package project.com.vivek.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.json.JSONObject;

public class JsonMessage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ConnectionFactory factory = new ActiveMQConnectionFactory("admin", "admin", "tcp://localhost:61616");

		try {
			Connection connection = factory.createConnection();

			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

			Destination destination = session.createQueue("vivek");

			JSONObject json = new JSONObject();

			json.put("Start_Date", "01-7-2021");
			json.put("name", "vivek dhiman");
			json.put("query", "select * from date");
			json.put("Finish_Date", "31-10-2022");

			TextMessage text = session.createTextMessage(json.toString());

			MessageProducer messageProducer = session.createProducer(destination);

			messageProducer.send(text);

			session.close();
			connection.close();

		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
