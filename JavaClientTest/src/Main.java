import java.net.DatagramPacket;


public class Main
{

	public static void main(String [] args)
	{
		final String clientIp = new String("127.0.0.1");
		final String serverIp = new String("127.0.0.1");
		final int clientPort = 8080;
		final int serverPort = 8081;
		
		UdpSocket sock = new UdpSocket(clientIp, clientPort, serverIp, serverPort);
		
		byte [] msg = new String("Hi!").getBytes();		
		sock.sentTo(msg);
		
		
		while(true)
		{
			byte [] servMsg = new byte [100000];
			DatagramPacket p = sock.receive(servMsg.length);
			servMsg = p.getData();
			
			System.out.println("Byte[0]: " + servMsg[0]);
		}
		

	}
}
