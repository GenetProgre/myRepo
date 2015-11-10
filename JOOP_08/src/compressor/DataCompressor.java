package compressor;


public class DataCompressor {
	
	public String compressMessage(String dataMessage) {
		return dataMessage.replaceAll("[AEIOUÕÄÖÜaeiouõäöü]", "");
	}
}
