package servlet;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import car.tp4.servlet.AddServlet;

public class servletTest {
	
	private HttpServletRequest mockRequest;
	private HttpServletResponse mockResponse;

	@Before
	public void setUp() {
		

		mockRequest = EasyMock.createMock(HttpServletRequest.class); // 加载
		mockResponse = EasyMock.createMock(HttpServletResponse.class);
	}

	@After
	public void tearDown() {
		EasyMock.verify(mockRequest); // 验证
		EasyMock.verify(mockResponse);
	}

	@Test

	public void testAddTitreHttpServletRequestHttpServletResponse() throws ServletException, IOException {
		mockRequest.getParameter("titre");
		EasyMock.expectLastCall().andReturn("allen");// 传入参数
		EasyMock.replay(mockRequest); // 回放
		EasyMock.replay(mockResponse);
		assertEquals(mockRequest.getParameter("titre"), "allen");
	

	}
	@Test

	public void testAddAuteurHttpServletRequestHttpServletResponse() throws ServletException, IOException {
		mockRequest.getParameter("auteur");
		EasyMock.expectLastCall().andReturn("allen");// 传入参数
		EasyMock.replay(mockRequest); // 回放
		EasyMock.replay(mockResponse);
		assertEquals(mockRequest.getParameter("auteur"), "allen");

	}
	@Test

	public void testYearAuteurHttpServletRequestHttpServletResponse() throws ServletException, IOException {
		mockRequest.getParameter("year");
		EasyMock.expectLastCall().andReturn("1998");// 传入参数
		EasyMock.replay(mockRequest); // 回放
		EasyMock.replay(mockResponse);
		assertEquals(mockRequest.getParameter("year"), "1998");

	}
	
	@Test

	public void testQuantiteAuteurHttpServletRequestHttpServletResponse() throws ServletException, IOException {
		mockRequest.getParameter("quantite");
		EasyMock.expectLastCall().andReturn("1998");// 传入参数
		EasyMock.replay(mockRequest); // 回放
		EasyMock.replay(mockResponse);
		assertEquals(mockRequest.getParameter("quantite"), "1998");

	}
}
