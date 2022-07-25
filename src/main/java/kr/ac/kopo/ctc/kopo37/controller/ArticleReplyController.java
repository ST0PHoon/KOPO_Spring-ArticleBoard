package kr.ac.kopo.ctc.kopo37.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.kopo.ctc.kopo37.domain.ArticleReply;
import kr.ac.kopo.ctc.kopo37.service.ArticleBoardService;
import kr.ac.kopo.ctc.kopo37.service.ArticleReplyService;

@Controller
@RequestMapping(value = "/articleBoard")
public class ArticleReplyController {
	@Autowired
	private ArticleReplyService articleReplyService;
	
	// 댓글
	@RequestMapping(value = "/createArticleReply")
	public String createArticleReply(ArticleReply articleReply) {
		articleReplyService.createArticleReply(articleReply);
		
		Long toGO = articleReply.getReplyId();
		return "redirect:/articleBoard/selectedArticle/" + toGO;
	}
	
	// 댓글
	@RequestMapping(value = "/createArticleReplyReply")
	public String createArticleReplyReply(ArticleReply articleReply) {
		articleReplyService.createArticleReply(articleReply);
		
		Long toGO = articleReply.getReplyId();
		return "redirect:/articleBoard/selectedArticle/" + toGO;
	}
	
	@RequestMapping(value = "/articleReplyUpdateForm/{id}")
	public String updateArticleReplyForm(Model model, @PathVariable("id") Long id) {
		model.addAttribute("updateArticleReply", articleReplyService.findById(id));
		
		return "articleReplyUpdateForm";
	}
	
	@RequestMapping(value = "/articleReplyUpdateForm/articleReplyUpdate")
	public String updateArticleReply(ArticleReply articleReply) {
		
		articleReplyService.updateArticleReply(articleReply);

		return "redirect:/articleBoard/articleListIndex";
	}
	
	@RequestMapping(value = "/deleteArticleReply/{id}")
	public String deleteArticleReply( @PathVariable("id") Long id) {
		
		articleReplyService.deleteById(id);
		
		return "redirect:/articleBoard/articleListIndex";
	}

}
