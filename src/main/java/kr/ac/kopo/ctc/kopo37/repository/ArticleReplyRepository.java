package kr.ac.kopo.ctc.kopo37.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.ctc.kopo37.domain.ArticleReply;

@Repository
public interface ArticleReplyRepository extends JpaRepository<ArticleReply, Long> {
	List<ArticleReply> findAllByArticleBoardId(Long id);
	
	List<ArticleReply> findAllByArticleBoardIdOrderByParentIdDescReplyIdAsc(Long id);
	
	void deleteByReplyId(Long id);
	
	void deleteAllByParentId(Long id);
}