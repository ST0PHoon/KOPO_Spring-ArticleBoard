package kr.ac.kopo.ctc.kopo37.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping(value = "/articleListIndex")
	public String articleList1(Model model,  @RequestParam(value = "title", required = false) String searchWord) {
		Integer currentArticlteListPage = 0;
		
		if (searchWord != null) {	// 검색어가 있는 경우
			model.addAttribute("ArticleItems", articleBoardService.findByTitleContainingOrderByIdDesc(searchWord, currentArticlteListPage));
			model.addAttribute("SearchWord", searchWord);
			model.addAttribute("ArticlePagination", articleBoardService.getPagination(searchWord, currentArticlteListPage));
		}
		
		if (searchWord == null) {	// 검색어가 없는 경우
			model.addAttribute("ArticleItems", articleBoardService.findByIdGreaterThanOrderByIdDesc(currentArticlteListPage));
			model.addAttribute("SearchWord", "");
			model.addAttribute("ArticlePagination", articleBoardService.getPagination(searchWord, currentArticlteListPage));
		}
		
		return "articleList";
	}
	// 검색방식
	@RequestMapping(value = "/articleList/{page}/{searchWord}")
	public String articleList(Model model, ArticleBoard articleboard, @PathVariable("page") Integer currentArticlteListPage,  @PathVariable("searchWord") String searchWord) {

		model.addAttribute("ArticleItems", articleBoardService.findByTitleContainingOrderByIdDesc(searchWord, currentArticlteListPage));
		model.addAttribute("SearchWord", searchWord);
		model.addAttribute("ArticlePagination", articleBoardService.getPagination(searchWord, currentArticlteListPage));

		// 뷰
		return "articleList";
	}
	
	@RequestMapping(value = "/articleList/{page}")
	public String articleListDefault(Model model, ArticleBoard articleboard, @PathVariable("page") Integer currentArticlteListPage) {

		model.addAttribute("ArticleItems", articleBoardService.findByIdGreaterThanOrderByIdDesc(currentArticlteListPage));
		model.addAttribute("SearchWord", "");
		model.addAttribute("ArticlePagination", articleBoardService.getPagination("", currentArticlteListPage));

		return "articleList";
	}
	
	
	@RequestMapping(value = "/selectedArticle/{id}")
	public String oneArticleView(Model model, @PathVariable("id") Long id) {
		
		articleBoardService.updateArticleBoardView(id);
		
		model.addAttribute("selectedArticleItem", articleBoardService.findOneById(id));
		model.addAttribute("selectedArticleReplies", articleReplyService.findAllByArticleBoardIdOrderByParentIdAscIdAsc(id));
		
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
	
}
