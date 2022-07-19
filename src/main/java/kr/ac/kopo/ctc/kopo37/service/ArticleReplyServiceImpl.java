package kr.ac.kopo.ctc.kopo37.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<ArticleReply> findAllByArticleBoardId(Long id) {
		List<ArticleReply> replyList = articleReplyRepository.findAllByArticleBoardId(id);
		return replyList;
	}

	@Override
	public List<ArticleReply> findAllByArticleBoardIdOrderByParentIdDescReplyIdAsc(Long boardId) {
		List<ArticleReply> replyList = articleReplyRepository.findAllByArticleBoardIdOrderByParentIdDescReplyIdAsc(boardId);
		return replyList;
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
