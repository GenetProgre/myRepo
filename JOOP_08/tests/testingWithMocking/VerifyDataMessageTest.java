package testingWithMocking;

import org.junit.Before;
import org.junit.Test;

import org.mockito.Mock;

import compressor.DataCompressor;
import dataCommunication.DataCommunicator;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class VerifyDataMessageTest {
	
	
	@Mock
	private DataCompressor compressor;
	
	private DataCommunicator dataCommunicator;
	
	@Before
	public void setUp() {
		compressor = mock(DataCompressor.class);
		dataCommunicator = new DataCommunicator(compressor);
	}
	
	@Test
	public void verifyMessageTest() {
		DataCommunicator.messageToSend = "";
		dataCommunicator.buildMessage("I saw a rabbit!");
		dataCommunicator.sendMessage();
		verify(compressor).compressMessage("I saw a rabbit!;");
	}
	
	@Test
	public void verifyMessageAddTest() {
		DataCommunicator.messageToSend = "";
		dataCommunicator.buildMessage("I saw a rabbit!;I saw it too!");
		dataCommunicator.sendMessage();
		verify(compressor).compressMessage("I saw a rabbit!;I saw it too!;");
	}
	
	@Test
	public void verifyMessageAddMultipleTest() {
		DataCommunicator.messageToSend = "";
		dataCommunicator.buildMessage("This is another test");
		dataCommunicator.buildMessage("Did you get all that?");
		dataCommunicator.buildMessage("I sure hope you did.");
		dataCommunicator.sendMessage();
		verify(compressor).compressMessage("This is another test;Did you get all that?;I sure hope you did.;");
	}
	
	@Test
	public void noMessage() {
		DataCommunicator.messageToSend = "";
		dataCommunicator.sendMessage();
		verify(compressor).compressMessage("");
	}

}
