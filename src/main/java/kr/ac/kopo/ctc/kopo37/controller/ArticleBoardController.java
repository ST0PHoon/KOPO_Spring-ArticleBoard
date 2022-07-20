package kr.ac.kopo.ctc.kopo37.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.kopo.ctc.kopo37.domain.ArticleBoard;
import kr.ac.kopo.ctc.kopo37.service.ArticleBoardService;
import kr.ac.kopo.ctc.kopo37.service.ArticleReplyService;

@Controller
@RequestMapping(value = "/articleBoard")
public class ArticleBoardController {
	@Autowired
	private ArticleBoardService articleBoardService;
	@Autowired
	private ArticleReplyService articleReplyService;
	
	@RequestMapping(value = "/articleList")
	public String articleList(Model model) {
		model.addAttribute("ArticleItems", articleBoardService.findByIdGreaterThanOrderByIdDesc(0));
		model.addAttribute("ArticlePagination", articleBoardService.getPagination(0));
		return "articleList";
	}
	
	@RequestMapping(value = "/articleList/{page}")
	public String articleList(Model model, @PathVariable("page") Integer currentArticlteListPage) {
		model.addAttribute("ArticleItems", articleBoardService.findByIdGreaterThanOrderByIdDesc(currentArticlteListPage));
		model.addAttribute("ArticlePagination", articleBoardService.getPagination(currentArticlteListPage));
		return "articleList";
	}
	
	@RequestMapping(value = "/selectedArticle/{id}")
	public String oneArticleView(Model model, @PathVariable("id") Long id) {
		
		articleBoardService.updateArticleBoardView(id);
		
		model.addAttribute("selectedArticleItem", articleBoardService.findOneById(id));
		model.addAttribute("selectedArticleReplies", articleReplyService.findAllByArticleBoardIdOrderByParentIdDescReplyIdAsc(id));
		
		return "selectedArticle";
	}
	
	@RequestMapping(value = "/articleSubmitForm")
	public String goArticleSubmitForm() {
		
		return "articleSubmitForm";
	}
	
	@RequestMapping(value = "/articleUpdateForm")
	public String goArticleUpdateForm(Model model, @RequestParam(value = "id") Long articleId) {
		
		model.addAttribute("selectedArticle", articleBoardService.findOneById(articleId));
		
		return "articleUpdateForm";
	}
	
	@RequestMapping(value = "/saveArticle")
	public String saveArticle(ArticleBoard articleboard) {
		articleBoardService.saveArticle(articleboard);
		return "redirect:/articleBoard/articleList";
	}
	
	@RequestMapping(value = "/deleteArticle")
	public String deleteArticle( @RequestParam(value = "id") Long articleId) {
		articleBoardService.deleteById(articleId);
		
		return "redirect:/articleBoard/articleList";
	}
}
