package compressor;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

public class CompressorTesting {
	
	private DataCompressor compressor;
	
	@Before
	public void setUp() {
		compressor = new DataCompressor();
	}
	
	@Test
	public void returnMessageWithoutVowels() {
		String dataMessage = "Saw a huge spider!";
		String withoutVowels = compressor
				.compressMessage(dataMessage);
		assertEquals("Sw  hg spdr!", withoutVowels);
	}
	
	@Test
	public void testEstonian() {
		String dataMessage = "või nii, ütled sa";
		String withoutVowels = compressor
				.compressMessage(dataMessage);
		assertEquals("v n, tld s", withoutVowels);
	}

	@Test
	public void returnMessageWithoutVowelsComplex() {
		String dataMessage = "everything seems so green all of a sudden...";
		String withoutVowels = compressor
				.compressMessage(dataMessage);
		assertEquals("vrythng sms s grn ll f  sddn...", withoutVowels);
	}

	@Test
	public void removeAllLetters() {
		String dataMessage = "aaa";
		String withoutVowels = compressor.compressMessage(dataMessage);
		assertEquals("", withoutVowels);
	}

	@Test
	public void returnExampleString() {
		String dataMessage = "Avastasime uue "
				+ "elevandiliigi, isendid on kollased ja oskavad laulda";
		String withoutVowels = compressor
				.compressMessage(dataMessage);
		assertEquals("vstsm  lvndlg, sndd n kllsd j skvd lld",
				withoutVowels);
	}

	@Test
	public void noValidMessage() {
		String withoutVowels = compressor.compressMessage("");
		assertEquals("", withoutVowels);
	}
	
}
