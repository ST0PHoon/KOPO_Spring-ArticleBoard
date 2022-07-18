package kr.ac.kopo.ctc.kopo37.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import kr.ac.kopo.ctc.kopo37.domain.ArticleReply;
import kr.ac.kopo.ctc.kopo37.repository.ArticleReplyRepository;

@Service
public class ArticleReplyServiceImpl implements ArticleReplyService {
	@Autowired
	ArticleReplyRepository articleReplyRepository;

	@Override
	public void saveBoardItem(ArticleReply articleReply) {
		articleReplyRepository.save(articleReply);	
	}

	@Override
	public List<ArticleReply> findAllByArticleIdOrderByParentIdReplyIdAsc(Long boardId) {
		List<ArticleReply> articleListByArticleId = articleReplyRepository.findAllByArticleIdOrderByParentIdReplyIdAsc(boardId);
		return articleListByArticleId;
	}

	@Override
	public void deleteOneById(Long id) {	// 대댓글 삭제
		articleReplyRepository.deleteByReplyId(id);
	}

	@Override
	public void deleteAllByParentId(Long id) {	// 댓글 삭제
		articleReplyRepository.deleteByParentId(id);
	}

}
