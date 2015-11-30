package json;

import static org.junit.Assert.*;

import org.json.simple.JSONArray;
import org.junit.Test;

import static org.mockito.Mockito.*;
import json.JSon;

public class JSonTest {

	@Test
	public void TestWithoutMocking() {
		JSon jSon = new JSon();
		assertEquals("Ilma mockimata", 300, jSon.getData());
		assertEquals(500, jSon.getCommentsData(new JSONArray()));
		assertEquals(200, jSon.getTodosData(new JSONArray()));
	}
	
	@Test
	public void mockingCommentsSize() {
		JSon json = mock(JSon.class);
		JSONArray commentsArray = mock(JSONArray.class);
		when(commentsArray.size()).thenReturn(500);
		int commentsArraySize = commentsArray.size();
		json.getCommentsData(commentsArray);
		when(json.getCommentsData(commentsArray)).thenReturn(commentsArraySize);
		verify(commentsArray, times(1)).size();
	}
	
	@Test
	public void mockingTodosSize() {
		JSon json = mock(JSon.class);
		JSONArray todosArray = mock(JSONArray.class);
		when(todosArray.size()).thenReturn(200);
		int todosArraySize = todosArray.size();
		json.getCommentsData(todosArray);
		when(json.getCommentsData(todosArray)).thenReturn(todosArraySize);
//		when(json.getCommentsData(todosArray)).thenReturn(todosArray.size());
		verify(todosArray, times(1)).size();
	}
	
	
	@Test
	public void mockingSubstract() {
		JSon json = mock(JSon.class);
		JSONArray todosArray = mock(JSONArray.class);
		JSONArray commentsArray = mock(JSONArray.class);
		when(json.getCommentsData(commentsArray)-json.getTodosData(todosArray)).thenReturn(300);		
	}
	
}