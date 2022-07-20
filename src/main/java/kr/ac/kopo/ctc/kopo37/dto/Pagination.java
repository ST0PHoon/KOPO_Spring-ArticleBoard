package kr.ac.kopo.ctc.kopo37.dto;

public class Pagination {
	private Integer ppPage;	//<<: 첫 페이지로
	private Integer pPage;	//< : 이전 숫자 그룹의 첫 페이지로
	
	private Integer nPage;	//> : 다음 숫자 그룹의 첫 숫자
	private Integer nnPage;	//>> : 마지막 페이지로
	
	private Integer cPage;	// 현재 페이지
	private Integer startPage;	// 현재 그룹의 시작 페이지 번호
	private Integer lastPage;	// 현재 그룹의 마지막 페이지 번호
	
	private Integer countPerpage;	// 한 페이지에 나올 숫자 목록
	private Integer pageSize;	//한 페이지 목록 수
	private Integer totalCount;	//전체 목록 수
	private Integer totalPage;	//전체 페이지 수
	
	public int getPpPage() {
		return ppPage;
	}
	public void setPpPage(int ppPage) {
		this.ppPage = ppPage;
	}
	public int getpPage() {
		return pPage;
	}
	public void setpPage(int pPage) {
		this.pPage = pPage;
	}
	public int getnPage() {
		return nPage;
	}
	public void setnPage(int nPage) {
		this.nPage = nPage;
	}
	public int getNnPage() {
		return nnPage;
	}
	public void setNnPage(int nnPage) {
		this.nnPage = nnPage;
	}
	public int getcPage() {
		return cPage;
	}
	public void setcPage(int cPage) {
		this.cPage = cPage;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getLastPage() {
		return lastPage;
	}
	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
	public int getCountPerpage() {
		return countPerpage;
	}
	public void setCountPerpage(int countPerpage) {
		this.countPerpage = countPerpage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
}
