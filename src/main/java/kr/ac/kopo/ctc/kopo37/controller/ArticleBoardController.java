package kr.ac.kopo.ctc.kopo37.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.kopo.ctc.kopo37.domain.ArticleBoard;
import kr.ac.kopo.ctc.kopo37.domain.ArticleReply;
import kr.ac.kopo.ctc.kopo37.service.ArticleBoardService;
import kr.ac.kopo.ctc.kopo37.service.ArticleReplyService;

@Controller
@RequestMapping(value = "/articleBoard")
public class ArticleBoardController {
	@Autowired
	private ArticleBoardService articleBoardService;
	@Autowired
	private ArticleReplyService articleReplyService;
	
	@RequestMapping(value = "/articleListIndex")
	public String articleList(Model model) {
		model.addAttribute("ArticleItems", articleBoardService.findByIdGreaterThanOrderByIdDesc(0));
		model.addAttribute("ArticlePagination", articleBoardService.getPagination(null, 0));
		return "articleList";
	}
	// 검색방식
	@RequestMapping(value = "/articleList/{page}")
	public String articleList(Model model, ArticleBoard articleboard , @PathVariable("page") Integer currentArticlteListPage) {
			String searchWord = articleboard.getTitle();

			if (searchWord == null) {	// 검색어가 없는 경우
				model.addAttribute("ArticleItems", articleBoardService.findByIdGreaterThanOrderByIdDesc(currentArticlteListPage));
				model.addAttribute("ArticlePagination", articleBoardService.getPagination(searchWord, currentArticlteListPage));
			}
			
			if (searchWord != null) {	// 검색어가 있는 경우
				model.addAttribute("ArticleItems", articleBoardService.findByTitleContainingOrderByIdDesc(searchWord, currentArticlteListPage));
				model.addAttribute("SearchWord", searchWord);
				model.addAttribute("ArticlePagination", articleBoardService.getPagination(searchWord, currentArticlteListPage));
			}

		// 뷰
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
	
	@RequestMapping(value = "/createArticle")
	public String createArticle(ArticleBoard articleboard) {
		articleBoardService.createArticle(articleboard);
		// 뷰ㅇ를 안거침
		return "redirect:/articleBoard/articleListIndex";
	}
	
	@RequestMapping(value = "/updateArticle")
	public String updateArticle(ArticleBoard articleboard) {
		articleBoardService.updateArticle(articleboard);
		return "redirect:/articleBoard/articleListIndex";
	}
	
	@RequestMapping(value = "/deleteArticle")
	public String deleteArticle( @RequestParam(value = "id") Long articleId) {
		articleBoardService.deleteById(articleId);
		
		return "redirect:/articleBoard/articleListIndex";
	}
	
	//      댓글
	@RequestMapping(value = "/createArticleReply")
	public String createArticleReply(ArticleReply articleReply) {
		articleReplyService.createArticleReply(articleReply);
		Long toGO = articleReply.getReplyId();
		return "redirect:/articleBoard/selectedArticle/" + toGO;
	}
	
	@RequestMapping(value = "/updateArticleReplyForm/{id}")
	public String updateArticleReplyForm(Model model, @PathVariable("id") Long id) {
		model.addAttribute("updateArticleReply", articleReplyService.findById(id));
		
		return "updateArticleReplyForm";
	}
	
	@RequestMapping(value = "/deleteArticleReply/{id}")
	public String deleteArticleReply( @PathVariable("id") Long id) {
		
		articleReplyService.deleteOneById(id);
		
		return "redirect:/articleBoard/articleListIndex";
	}
	
	
	
}
