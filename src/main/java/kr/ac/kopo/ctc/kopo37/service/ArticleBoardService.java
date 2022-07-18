package kr.ac.kopo.ctc.kopo37.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import kr.ac.kopo.ctc.kopo37.domain.ArticleBoard;

public interface ArticleBoardService {
	// C, U
	void saveBoardItem(ArticleBoard articleBoard);
	// R
	ArticleBoard findOneById(Long id);	// 하나
	
	List<ArticleBoard> findAll();	// 전체
	
	Page<ArticleBoard> findAllByOrderByRootidDescRecntAsc(Integer currentPage, Integer itemNumber);	// 페이징
	
	// D
	void deleteById(Long id);
}