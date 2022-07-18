package kr.ac.kopo.ctc.kopo37.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.kopo.ctc.kopo37.service.ArticleBoardService;
import kr.ac.kopo.ctc.kopo37.service.ArticleReplyService;

@Controller
@RequestMapping(value = "/boardItem")
public class ArticleBoardController {
	
	@Autowired
	private ArticleReplyService articleReplyService;
	
	@Autowired
	private ArticleBoardService articleBoardService;
	
	@RequestMapping(value = "/list")
	public String boardlist(Model model) {
		
//		model.addAttribute("AllItems", articleBoardService.findAll());
		return "list";
	}
	
	@RequestMapping(value = "/oneView/{id}")
	public String boardView(Model model, @PathVariable("id") Long id) {
		
//		model.addAttribute("oneViewItem", articleBoardService.findAllById(id));
//		model.addAttribute("oneViewItem", articleReplyService.findAllById(id));
		
		return "oneView";
	}
}
