package com.nhn.board;

import java.util.Locale;

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
	public String boardList(Locale locale, Model model) throws Exception {
		
		List<BoardEntity> boardList = boardDao.selectList();		
		model.addAttribute("boardList", boardList);

		return "board";
	}

}
