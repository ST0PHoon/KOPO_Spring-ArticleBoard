package kr.ac.kopo.ctc.kopo37.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.kopo.ctc.kopo37.domain.ArticleReply;

public interface ArticleReplyService {
	// C, U
	void createArticleReply(ArticleReply articleReply);
	
	void updateArticleReply(ArticleReply articleReply);
	
	// R
	ArticleReply findById(Long id);
	
	List<ArticleReply> findAllByArticleBoardId(Long id);
	
	List<ArticleReply> findAllByArticleBoardIdOrderByParentIdAscIdAsc(Long id);	// 전체, 원글 아이디에 해당하는 내용만
	
	// D
	@Transactional 
	void deleteById(Long id);

}
