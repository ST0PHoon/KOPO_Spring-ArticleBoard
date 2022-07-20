package kr.ac.kopo.ctc.kopo37.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import kr.ac.kopo.ctc.kopo37.domain.ArticleBoard;
import kr.ac.kopo.ctc.kopo37.dto.Pagination;
import kr.ac.kopo.ctc.kopo37.repository.ArticleBoardRepository;

@Service
public class ArticleBoardServiceImpl implements ArticleBoardService {
	@Autowired
	ArticleBoardRepository articleBoardRepository;
	
	// C, U
	@Override
	public void createArticle(ArticleBoard articleBoard) {	// 저장 & 업데이트
		// 받아오는 정보, title, writer, content
		Date date = new Date();		
		
		articleBoard.setView(0L);
		articleBoard.setRegisterDate(date);
		articleBoard.setUpdateDate(date);
			
		articleBoardRepository.save(articleBoard);
	}
	
	@Override
	public void updateArticle(ArticleBoard articleBoard) {
		
		Date date = new Date();	
		
		ArticleBoard updatedArticle = articleBoardRepository.findById(articleBoard.getId()).get();
		
		updatedArticle.setTitle(articleBoard.getTitle());
		updatedArticle.setWriter(articleBoard.getWriter());
		updatedArticle.setContent(articleBoard.getContent());
		updatedArticle.setUpdateDate(date);
		
		articleBoardRepository.save(updatedArticle);
	}
	
	@Override
	public void updateArticleBoardView(Long id) {	// 조회수 증가
		ArticleBoard articleboard = articleBoardRepository.findById(id).get();
		
		Long plusView = articleboard.getView() + 1;
		
		articleboard.setView(plusView);
		
		articleBoardRepository.save(articleboard);
	}
	
	// R
	@Override
	public ArticleBoard findOneById(Long id) {
		ArticleBoard articleList = articleBoardRepository.findAllById(id).get(0);
		return articleList;
	}

	@Override
	public List<ArticleBoard> findAll() {
		List<ArticleBoard> articleList = articleBoardRepository.findAll();
		return articleList;
	}

	@Override
	public List<ArticleBoard> findByIdGreaterThanOrderByIdDesc(Integer currentPage) {
		final Long minId = 0L;	//id 가 0 이상인 값 호출
		final Integer articleNumber = 10;
		
	   // 첫페이지, 기준 id
	   org.springframework.data.domain.Pageable pageableCondition = PageRequest.of(currentPage, articleNumber);
	   
	   List<ArticleBoard> articleItemsPage = articleBoardRepository.findByIdGreaterThanOrderByIdDesc(minId , pageableCondition).toList();
	   
	   return  articleItemsPage;
	}
	
	@Override
	public Pagination getPagination(Integer currentPage) {
		final Integer countPerPage = 10;
		final Integer pageSize = 10;
		Integer totalCount = (int) articleBoardRepository.count();

		Pagination pagination = new Pagination();

		// 총페이지 계산
		int totalPage = (int) Math.ceil(totalCount / (double) countPerPage);
		if (totalPage != Math.ceil(totalCount / (double) countPerPage)) {
			totalPage++;
		}

		// 현재페이지에 불가능한 값을 넣었을 경우 처리
		if (currentPage > totalPage) {
			currentPage = totalPage;
		}
		if (currentPage < 1) {
			currentPage = 1;
		}

		// 페이지 묶음의 시작과 끝 페이지
		int startPage;

		if (currentPage % pageSize == 0) {
			startPage = ((currentPage - 1) / pageSize) * pageSize + 1;
		} else {
			startPage = (currentPage / pageSize) * pageSize + 1;
		}
		int lastPage = startPage + pageSize - 1;

		// 만약 끝 값이 총 페이지보다 크다면 총페이지만 나오도록

		if (lastPage > totalPage) {
			lastPage = totalPage;
		}

		// 이전 페이지열 계산
		int pPage;
		if (startPage == 1) {
			pPage = 1;
		} else {
			pPage = startPage - 1;
		}

		// 다음 페이지열 계산
		int nPage;
		if (lastPage == totalPage) {
			nPage = totalPage;
		} else {
			nPage = lastPage + 1;
		}

		// ppPage : 제일 처음 페이지
		int ppPage = 0;

		// nnPage : 제일 마지막 페이지
		int nnPage = (int) Math.ceil((double) totalCount / pageSize);

		pagination.setPpPage(ppPage);
		pagination.setpPage(pPage - 1);
		pagination.setnPage(nPage - 1);
		pagination.setNnPage(nnPage - 1);
		pagination.setcPage(currentPage);
		pagination.setStartPage(startPage);
		pagination.setLastPage(lastPage);
		pagination.setTotalPage(totalPage);
		pagination.setCountPerpage(countPerPage);
		pagination.setTotalCount(totalCount);
		pagination.setPageSize(pageSize);

		return pagination;
	}
	
	// D
	@Override
	public void deleteById(Long id) {
		articleBoardRepository.deleteById(id);;
	}



}
