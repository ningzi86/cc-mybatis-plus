package cn.golango.mybatis.pojo;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import io.swagger.annotations.ApiModelProperty;

/**
 *   @description : Contents 实体类
 *   ---------------------------------
 * 	 @author cc
 *   @since 2018-06-14
 */
@TableName("t_contents")
public class Contents implements Serializable {

    private static final long serialVersionUID = 1L;

	@ApiModelProperty(hidden = true)
	@TableId(value="cid", type= IdType.AUTO)
	private Integer cid;
	private String title;
	private String slug;
	private Integer created;
	private Integer modified;
    /**
     * 内容文字
     */
    @ApiModelProperty("内容文字")
	private String content;
	@TableField("author_id")
	private Integer authorId;
	private String type;
	private String status;
	private String tags;
	private String categories;
	private Integer hits;
	@TableField("comments_num")
	private Integer commentsNum;
	@TableField("allow_comment")
	private Integer allowComment;
	@TableField("allow_ping")
	private Integer allowPing;
	@TableField("allow_feed")
	private Integer allowFeed;


	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public Integer getCreated() {
		return created;
	}

	public void setCreated(Integer created) {
		this.created = created;
	}

	public Integer getModified() {
		return modified;
	}

	public void setModified(Integer modified) {
		this.modified = modified;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getCategories() {
		return categories;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

	public Integer getHits() {
		return hits;
	}

	public void setHits(Integer hits) {
		this.hits = hits;
	}

	public Integer getCommentsNum() {
		return commentsNum;
	}

	public void setCommentsNum(Integer commentsNum) {
		this.commentsNum = commentsNum;
	}

	public Integer getAllowComment() {
		return allowComment;
	}

	public void setAllowComment(Integer allowComment) {
		this.allowComment = allowComment;
	}

	public Integer getAllowPing() {
		return allowPing;
	}

	public void setAllowPing(Integer allowPing) {
		this.allowPing = allowPing;
	}

	public Integer getAllowFeed() {
		return allowFeed;
	}

	public void setAllowFeed(Integer allowFeed) {
		this.allowFeed = allowFeed;
	}


	@Override
	public String toString() {
		return "Contents{" +
			", cid=" + cid +
			", title=" + title +
			", slug=" + slug +
			", created=" + created +
			", modified=" + modified +
			", content=" + content +
			", authorId=" + authorId +
			", type=" + type +
			", status=" + status +
			", tags=" + tags +
			", categories=" + categories +
			", hits=" + hits +
			", commentsNum=" + commentsNum +
			", allowComment=" + allowComment +
			", allowPing=" + allowPing +
			", allowFeed=" + allowFeed +
			"}";
	}
}
