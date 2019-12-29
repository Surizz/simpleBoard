package com.nhn.board;

import java.util.Locale;

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
	public String boardList(Model model) throws Exception {
		
		List<BoardEntity> boardList = boardDao.selectList();		
		model.addAttribute("boardList", boardList);

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
}
