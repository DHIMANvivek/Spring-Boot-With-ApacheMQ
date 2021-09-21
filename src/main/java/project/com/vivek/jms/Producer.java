package project.com.vivek.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * Hello world!
 *
 */
public class Producer {

	public static void main(String[] args) {

		// we first have to create connection factory that is used to create an
		// connection between our activeMQ

		ConnectionFactory factory = new ActiveMQConnectionFactory("admin", "admin", "tcp://localhost:61616");

		try {

			// Connection here is the java messaging service ..... where we want to send the
			// message & after that the server start

			Connection connection = factory.createConnection();
			connection.start();

			// here we have to create a session to create a queue , remember :- queue name
			// is any of your choice

			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

			// destination is the place where we have to send data in the form of message

			Destination destination = session.createQueue("vivek");

			// message producer is the user who used to send the messages

			MessageProducer messageproducer = session.createProducer(destination);

			TextMessage textmessage = session.createTextMessage("hi , this is first message ");

			messageproducer.send(textmessage);

			session.close();

		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
