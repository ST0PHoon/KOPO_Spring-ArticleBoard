package kr.ac.kopo.ctc.kopo37.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class ArticleReply {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	private Long replyId;
	private Long parentId;
	private Integer depth;
	private String replyWriter;
	private String replyContent;
	private Date replyRegisterDate;
	private Date replyUpdateDate;

	@JsonBackReference
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="articleBoard_id", referencedColumnName = "id")
	private ArticleBoard articleBoard ;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getReplyId() {
		return replyId;
	}

	public void setReplyId(Long replyId) {
		this.replyId = replyId;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}	

	public Integer getDepth() {
		return depth;
	}

	public void setDepth(Integer depth) {
		this.depth = depth;
	}

	public String getReplyWriter() {
		return replyWriter;
	}

	public void setReplyWriter(String replyWriter) {
		this.replyWriter = replyWriter;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public Date getReplyRegisterDate() {
		return replyRegisterDate;
	}

	public void setReplyRegisterDate(Date replyRegisterDate) {
		this.replyRegisterDate = replyRegisterDate;
	}

	public Date getReplyUpdateDate() {
		return replyUpdateDate;
	}

	public void setReplyUpdateDate(Date replyUpdateDate) {
		this.replyUpdateDate = replyUpdateDate;
	}

	public ArticleBoard getArticleBoard() {
		return articleBoard;
	}

	public void setArticleBoard(ArticleBoard articleBoard) {
		this.articleBoard = articleBoard;
	}


	
}
