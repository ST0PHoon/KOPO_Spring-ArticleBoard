package kr.ac.kopo.ctc.kopo37.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import kr.ac.kopo.ctc.kopo37.domain.ArticleBoard;
import kr.ac.kopo.ctc.kopo37.repository.ArticleBoardRepository;

@Service
public class ArticleBoardServiceImpl implements ArticleBoardService {
	@Autowired
	ArticleBoardRepository articleBoardRepository;
	
	@Override
	public void saveBoardItem(ArticleBoard articleBoard) {
		articleBoardRepository.save(articleBoard);
	}

	@Override
	public List<ArticleBoard> findOneById(Long id) {
		List<ArticleBoard> articleList = articleBoardRepository.findAllById(id);
		return articleList;
	}

	@Override
	public List<ArticleBoard> findAll() {
		List<ArticleBoard> articleList = articleBoardRepository.findAll();
		return articleList;
	}

	@Override
	public Page<ArticleBoard> findByIdGreaterThanOrderByIdDesc(Integer currentPage, Integer itemNumber) {
		final Long minId = 0L;
		
	   // 첫페이지, 2개씩, 내림차순, 기준 id
	   org.springframework.data.domain.Pageable pageableCondition = PageRequest.of(currentPage, itemNumber);
	   
	   Page<ArticleBoard> articleItemsPage = articleBoardRepository.findByIdGreaterThanOrderByIdDesc(minId , pageableCondition);
		
		return articleItemsPage;
	}

	@Override
	public void deleteById(Long id) {
		articleBoardRepository.deleteById(id);;
	}

}
