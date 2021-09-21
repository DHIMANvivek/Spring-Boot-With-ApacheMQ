package project.com.vivek.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * Hello world!
 *
 */
public class Producer {

	public static void main( String[] args )
    {
    	ConnectionFactory factory = new ActiveMQConnectionFactory("admin","admin","tcp://localhost:61616");
    	
    	try {
			Connection connection = factory.createConnection();
			connection.start();
			
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE)	;
			Destination destination = session.createQueue("vivek");
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
