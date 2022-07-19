package kr.ac.kopo.ctc.kopo37.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import kr.ac.kopo.ctc.kopo37.domain.ArticleReply;

public interface ArticleReplyService {
	// C, U
	void saveBoardItem(ArticleReply articleReply);
	
	// R
	List<ArticleReply> findAllByArticleBoardId(Long id);
	
	List<ArticleReply> findAllByArticleBoardIdOrderByParentIdDescReplyIdAsc(Long id);	// 전체, 원글 아이디에 해당하는 내용만
	
	// D
	void deleteOneById(Long id);
	
	void deleteAllByParentId(Long id);
}
