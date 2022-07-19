package kr.ac.kopo.ctc.kopo37.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import kr.ac.kopo.ctc.kopo37.domain.ArticleBoard;

public interface ArticleBoardService {
	// C, U
	void saveBoardItem(ArticleBoard articleBoard);
	// R
	List<ArticleBoard> findOneById(Long id);	// 하나
	
	List<ArticleBoard> findAll();	// 전체
	
	List<ArticleBoard> findByIdGreaterThanOrderByIdDesc(Integer currentPage, Integer itemNumber);	// 페이징
	
	// D
	void deleteById(Long id);
}
