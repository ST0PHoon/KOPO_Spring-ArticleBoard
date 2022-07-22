package kr.ac.kopo.ctc.kopo37.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.ctc.kopo37.domain.ArticleBoard;

@Repository
public interface ArticleBoardRepository extends JpaRepository<ArticleBoard, Long>, JpaSpecificationExecutor<ArticleBoard> {
 
	Optional<ArticleBoard> findOneById(Long id);

	List<ArticleBoard> findAllById(Long id);
	
	Integer countByTitleContaining(String searchWord);
	
	Page<ArticleBoard> findByIdGreaterThanOrderByIdDesc(Long minId , Pageable pageableCondition);
	
	Page<ArticleBoard> findByTitleContainingOrderByIdDesc(String containedWord , Pageable pageableCondition);
	
}
