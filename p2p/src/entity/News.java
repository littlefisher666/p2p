package entity;

import java.util.Date;

/**
 * News entity. @author MyEclipse Persistence Tools
 */

public class News implements java.io.Serializable {
	
	/**
	 * The current news ; Default
	 */
	public static final String STATUS_CURRENT = "C";
	/**
	 * The finished news
	 */
	public static final String STATUS_FINISHED = "F";
	/**
	 * Deleted
	 */
	public static final String STATUS_DELETED = "D";
	/**
	 * 新闻id
	 */
	private Integer newsId;
	/**
	 * 新闻题目
	 */
	private String newsTitle;
	/**
	 * 新闻内容
	 */
	private String content;
	/**
	 * 新闻创建时间
	 */
	private Date createAt;
	/**
	 * 新闻图片
	 * 默认存储在images/news/下
	 */
	private String image;
	/**
	 * 新闻的状态
	 */
	private String status;

	// Constructors

	/** default constructor */
	public News() {
	}

	/** minimal constructor */
	public News(String newsTitle, String content) {
		this.newsTitle = newsTitle;
		this.content = content;
	}

	/** full constructor */
	public News(String newsTitle, String content, Date createAt, String image,String status) {
		this.newsTitle = newsTitle;
		this.content = content;
		this.createAt = createAt;
		this.image = image;
		this.status = status;
	}

	// Property accessors

	public Integer getNewsId() {
		return this.newsId;
	}

	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}

	public String getNewsTitle() {
		return this.newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateAt() {
		return this.createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}