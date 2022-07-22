package kr.ac.kopo.ctc.kopo37.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.ctc.kopo37.domain.ArticleBoard;
import kr.ac.kopo.ctc.kopo37.domain.ArticleReply;
import kr.ac.kopo.ctc.kopo37.repository.ArticleReplyRepository;

@Service
public class ArticleReplyServiceImpl implements ArticleReplyService {
	@Autowired
	ArticleReplyRepository articleReplyRepository;
	
	@Override
	public void createArticleReply(ArticleReply articleReply) {	// depth, replyWriter, replyContent, replyId
//		ArticleReply createArticleReply = new ArticleReply();
		ArticleBoard articleBoard = new ArticleBoard();
		articleBoard.setId(articleReply.getReplyId());
		
		Date date = new Date();
		// ArticleBoardId , 날짜 두개, 입력
		articleReply.setArticleBoard(articleBoard);
		articleReply.setReplyRegisterDate(date);
		articleReply.setReplyUpdateDate(date);
		
		articleReplyRepository.save(articleReply);
		
		if (articleReply.getDepth() == 1) {
			articleReply.setParentId(articleReply.getId());
		}
		
		if (articleReply.getDepth() == 2) {
			
		}
		
		articleReplyRepository.save(articleReply);
	}

	@Override
	public void updateArticleReply(ArticleReply articleReply) {
		// TODO Auto-generated method stub
		
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
	public ArticleReply findById(Long id) {
		return articleReplyRepository.findById(id).get();
	}

	@Override
	public void deleteOneById(Long id) {	// 대댓글 삭제
		articleReplyRepository.deleteById(id);
		System.out.println("전장조아~");
	}

	@Override
	public void deleteAllByParentId(Long id) {	// 댓글 삭제
		articleReplyRepository.deleteAllByParentId(id);
	}

}
