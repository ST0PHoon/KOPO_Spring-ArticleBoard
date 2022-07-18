package kr.ac.kopo.ctc.kopo37.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.ctc.kopo37.domain.ArticleReply;

@Repository
public interface ArticleReplyRepository extends JpaRepository<ArticleReply, Long> {
	List<ArticleReply> findAllByArticleId(Long id);
	
	List<ArticleReply> findAllByArticleIdOrderByParentIdReplyIdAsc(Long id);
	
	void deleteByReplyId(Long id);
	
	void deleteByParentId(Long id);
}