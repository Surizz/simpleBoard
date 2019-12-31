package com.nhn.board;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.nhn.board.dao.BoardDao;
import com.nhn.board.vo.BoardEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/test/resources/root-context.xml",
				"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@WebAppConfiguration
public class MainControllerTest {	
	@Autowired
	WebApplicationContext applicationContext;
	
	@Autowired
	BoardDao boardDao;
	
	MockMvc mockMvc;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(applicationContext).build();
	    }

	@Test // 이메일, 비밀번호, 본문을 입력받아 디비에 추가
	public void testAddEntity() throws Exception {
		mockMvc.perform(post("/add")
				.param("email", "testAddEntity@email.com")
				.param("password", "password")
				.param("content", "content")
				).andExpect(status().is(302)); // redirect
		
		List<BoardEntity> list = boardDao.selectList();
		try {			
			assertThat(list.get(0).getEmail(), is("testAddEntity@email.com"));
		} finally {
			boardDao.delete(list.get(0).getBno());
		}
	}
	
	@Test // 글 등록 시 현재 시간도 기록
	public void testSetCurrentTime() throws Exception {
		mockMvc.perform(post("/add")
				.param("email", "testSetCurrentTime@email.com")
				.param("password", "password")
				.param("content", "content")
				)
			.andExpect(status().is(302));
		
		List<BoardEntity> list = boardDao.selectList();
		try {
			assertNotNull(list.get(0).getCreatedDate());
		} finally {
			boardDao.delete(list.get(0).getBno());
		}
	}
	
	@Test //DB에 있는 내용을 최신 글이 맨 위에 오도록 페이징 없이 출력
	public void testSortingBoard() throws Exception {

		int first = boardDao.insert(new BoardEntity().
				setEmail("testSortingBoard_bottom@email.com").
				setPassword("password1").
				setContent("content1"));
		
		Thread.sleep(1000);
		
		int second = boardDao.insert(new BoardEntity().
				setEmail("testSortingBoard_top@email.com").
				setPassword("password2").
				setContent("content2"));

		Thread.sleep(1000);

		try {
			List<BoardEntity> tempList = boardDao.selectList();		
			assertThat(tempList.get(0).getEmail(), is("testSortingBoard_top@email.com"));
			assertThat(tempList.get(1).getEmail(), is("testSortingBoard_bottom@email.com"));
		}finally {
			boardDao.delete(first);
			boardDao.delete(second);
		}
	}
	
	@Test // 비밀번호를 입력 받아 방명록 글 수정 가능
	public void testUpdateBoardEntity() throws Exception {
		BoardEntity boardEntity = new BoardEntity()
				.setEmail("testUpdateBoardEntity@email.com").
				setPassword("password").
				setContent("content");
		
		int no = boardDao.insert(boardEntity);
		
		try {
			mockMvc.perform(post("/update")
						.param("bno", Integer.toString(no))
						.param("password", "password")
						.param("content", "contentChanged")
					).andExpect(status().is(302));
			
			List<BoardEntity> list = boardDao.selectList();
			assertThat(list.get(0).getContent(), is("contentChanged"));
			
		} finally {
			boardDao.delete(no);
		}
	}
	
	@Test // 수정 시 별도 테이블 컬럼에 수정 시각 기록
	public void testEditTime() throws Exception {
		BoardEntity boardEntity = new BoardEntity()
				.setEmail("testEditTime@email.com").
				setPassword("password").
				setContent("content");
		
		int no = boardDao.insert(boardEntity);		
		boardEntity = boardDao.selectOne(no);
		
		Thread.sleep(1000);

		try {
			mockMvc.perform(post("/update")
						.param("bno", Integer.toString(no))
						.param("password", "password")
						.param("content", "contentChanged")
					).andExpect(status().is(302));
			
			Thread.sleep(1000);

			List<BoardEntity> list = boardDao.selectList();
			assertNotNull(list.get(0).getModifiedDate());
			assertNotEquals(list.get(0).getModifiedDate(), boardEntity.getModifiedDate());
			
		} finally {
			boardDao.delete(no);
		}
	}
	
	@Test // 이메일이 올바른지 서버 쪽, 클라이언트 쪽 모두에서 체크
	public void testInvalidEmail() throws Exception {
		mockMvc.perform(post("/add")
				.param("email", "test.invalidEmail.com")
				.param("password", "password")
				.param("content", "content")
				).andExpect(view().name("invalidFormatError"));		
	}
}
