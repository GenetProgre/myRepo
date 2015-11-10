package dataCommunication;


import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import compressor.DataCompressor;

public class DataCommunicator {
	
	public static String messageToSend = "";
	private DataCompressor compressor;

	public DataCommunicator(DataCompressor compressor) {
		this.compressor = compressor;
	}
	
	public void buildMessage(String dataMessage) {
		messageToSend += dataMessage + ";";
	}
	
	public void sendMessage() {
		try {
			String compressedMessage = compressor.compressMessage(messageToSend);
			FileOutputStream fileOut = new FileOutputStream("dataLog.log");
			PrintStream printOut = new PrintStream(fileOut);
			printOut.print(compressedMessage);
			messageToSend = "";
		} catch (FileNotFoundException e) {
			System.err.println("Error with file: " + e.getMessage());
		}

	}
}
