package kr.ac.kopo.ctc.kopo37.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class ArticleBoard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@Column
	private String title;
	private String writer;
	private String content;
	private Long view;
	private Date registerDate;
	private Date updateDate;
	
	@JsonManagedReference
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="articleBoard")
	private List<ArticleReply> articleReplies;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getView() {
		return view;
	}

	public void setView(Long view) {
		this.view = view;
	}
	
	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public List<ArticleReply> getArticeclReplys() {
		return articleReplies;
	}

	public void setArticeclReplys(List<ArticleReply> articeclReplys) {
		this.articleReplies = articeclReplys;
	}


	
}
