package kr.ac.kopo.ctc.kopo37.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import kr.ac.kopo.ctc.kopo37.domain.ArticleBoard;
import kr.ac.kopo.ctc.kopo37.dto.Pagination;

public interface ArticleBoardService {
	// C, U
	void saveBoardItem(ArticleBoard articleBoard);
	
	void updateArticleBoardView(Long id);
	// R
	List<ArticleBoard> findOneById(Long id);	// 하나
	
	List<ArticleBoard> findAll();	// 전체
	
	List<ArticleBoard> findByIdGreaterThanOrderByIdDesc(Integer currentPage);	// 페이징
	
	Pagination getPagination(Integer currentPage);
	
	// D
	void deleteById(Long id);
}
