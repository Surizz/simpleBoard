package com.nhn.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nhn.board.dao.BoardDao;
import com.nhn.board.vo.BoardEntity;

import java.util.List;

@Controller
public class MainController {
		
	@Autowired
	BoardDao boardDao;
	
	@RequestMapping(value = "/", method=RequestMethod.GET)
	public String boardList(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {		
		List<BoardEntity> boardList = boardDao.selectList();		
		model.addAttribute("boardList", boardList);
		
		if(request.getParameter("bno") != null) // 방명록 수정
		{
			BoardEntity boardEntity = boardDao.selectOne(
					Integer.parseInt(request.getParameter("bno")));	
			model.addAttribute("boardEntity", boardEntity);
			model.addAttribute("boardCond", "update");
			return "board";
		}					
		model.addAttribute("boardCond", "add");
		return "board";
	}

	@RequestMapping(value = "/add", method=RequestMethod.POST)
	public String addBoardEntity(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardEntity boardEntity = new BoardEntity();

		boardEntity.setEmail(request.getParameter("email"))
			.setPassword(request.getParameter("password"))
			.setContent(request.getParameter("content"));
		
		boardDao.insert(boardEntity);
		
		response.sendRedirect("/board");
		
		return null;
	}

	@RequestMapping(value = "/update", method=RequestMethod.POST)
	public String updateBoardEntity(HttpServletRequest request, HttpServletResponse response) throws Exception {

		boardDao.update(new BoardEntity().
				setBno(Integer.parseInt(request.getParameter("bno"))).
				setContent(request.getParameter("content"))	
				);
		response.sendRedirect("/board/");
				
		return null;
	}
}
