package kr.ac.kopo.ctc.kopo37.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.kopo.ctc.kopo37.service.ArticleBoardService;
import kr.ac.kopo.ctc.kopo37.service.ArticleReplyService;

@Controller
@RequestMapping(value = "/articleBoard")
public class ArticleBoardController {
	@Autowired
	private ArticleBoardService articleBoardService;
	@Autowired
	private ArticleReplyService articleReplyService;
	
	@RequestMapping(value = "/{page}")
	public String boardlist(Model model, @PathVariable("page") Integer currentArticlteListPage) {
		final Integer articleNumber = 10;
		
		model.addAttribute("ArticleItems", articleBoardService.findByIdGreaterThanOrderByIdDesc(currentArticlteListPage - 1, articleNumber));
		return "articleList";
	}
	// 이름 수정
	@RequestMapping(value = "/selectedArticle/{id}")
	public String boardView(Model model, @PathVariable("id") Long id) {
		
		model.addAttribute("selectedArticleItem", articleBoardService.findOneById(id));
		model.addAttribute("selectedArticleReplies", articleReplyService.findAllByArticleBoardIdOrderByParentIdDescReplyIdAsc(id));
		
		return "selectedArticle";
	}
}
