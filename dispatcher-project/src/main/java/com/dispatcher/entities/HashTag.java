package com.dispatcher.entities;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//nome de la  collection = HASHTAG
@Document(collection = "HASHTAG")
public class HashTag {

	@Id
	private String id;

	private String text;
	private Date createdAt;
	private String fromUser;
	private String profileImageUrl;
	private Long toUserId;
	private Long inReplyToStatusId;
	private Long inReplyToUserId;
	private String inReplyToScreenName;
	private long fromUserId;
	private String languageCode;
	private String source;
	private Integer retweetCount;
	private boolean retweeted;
	private HashTag retweetedStatus;
	private boolean favorited;
	private Integer favoriteCount;

	private Entities entities;
	private HashTagProfile user;

	public HashTag(String id, String text, Date createdAt, String fromUser, String profileImageUrl, Long toUserId,
			long fromUserId, String languageCode, String source) {
		this.id = id;
		this.text = text;
		this.createdAt = createdAt;
		this.fromUser = fromUser;
		this.profileImageUrl = profileImageUrl;
		this.toUserId = toUserId;
		this.fromUserId = fromUserId;
		this.languageCode = languageCode;
		this.source = source;
	}

	public HashTag(String id, String text, Date createdAt, String fromUser, String profileImageUrl, Long toUserId,
			Long inReplyToStatusId, Long inReplyToUserId, String inReplyToScreenName, long fromUserId,
			String languageCode, String source, Integer retweetCount, boolean retweeted, HashTag retweetedStatus,
			boolean favorited, Integer favoriteCount, Entities entities, HashTagProfile user) {
		super();
		this.id = id;
		this.text = text;
		this.createdAt = createdAt;
		this.fromUser = fromUser;
		this.profileImageUrl = profileImageUrl;
		this.toUserId = toUserId;
		this.inReplyToStatusId = inReplyToStatusId;
		this.inReplyToUserId = inReplyToUserId;
		this.inReplyToScreenName = inReplyToScreenName;
		this.fromUserId = fromUserId;
		this.languageCode = languageCode;
		this.source = source;
		this.retweetCount = retweetCount;
		this.retweeted = retweeted;
		this.retweetedStatus = retweetedStatus;
		this.favorited = favorited;
		this.favoriteCount = favoriteCount;
		this.entities = entities;
		this.user = user;
	}

	public HashTag getRetweetedStatus() {
		return retweetedStatus;
	}

	public void setRetweetedStatus(HashTag retweetedStatus) {
		this.retweetedStatus = retweetedStatus;
	}

	public Entities getEntities() {
		return entities;
	}

	public void setEntities(Entities entities) {
		this.entities = entities;
	}

	public HashTagProfile getUser() {
		return user;
	}

	public void setUser(HashTagProfile user) {
		this.user = user;
	}

	public HashTag(String id, String text) {
		super();
		this.id = id;
		this.text = text;
	}

	public HashTag() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getFromUser() {
		return fromUser;
	}

	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}

	public String getProfileImageUrl() {
		return profileImageUrl;
	}

	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}

	public Long getToUserId() {
		return toUserId;
	}

	public void setToUserId(Long toUserId) {
		this.toUserId = toUserId;
	}

	public Long getInReplyToStatusId() {
		return inReplyToStatusId;
	}

	public void setInReplyToStatusId(Long inReplyToStatusId) {
		this.inReplyToStatusId = inReplyToStatusId;
	}

	public Long getInReplyToUserId() {
		return inReplyToUserId;
	}

	public void setInReplyToUserId(Long inReplyToUserId) {
		this.inReplyToUserId = inReplyToUserId;
	}

	public String getInReplyToScreenName() {
		return inReplyToScreenName;
	}

	public void setInReplyToScreenName(String inReplyToScreenName) {
		this.inReplyToScreenName = inReplyToScreenName;
	}

	public long getFromUserId() {
		return fromUserId;
	}

	public void setFromUserId(long fromUserId) {
		this.fromUserId = fromUserId;
	}

	public String getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Integer getRetweetCount() {
		return retweetCount;
	}

	public void setRetweetCount(Integer retweetCount) {
		this.retweetCount = retweetCount;
	}

	public boolean isRetweeted() {
		return retweeted;
	}

	public void setRetweeted(boolean retweeted) {
		this.retweeted = retweeted;
	}

	public boolean isFavorited() {
		return favorited;
	}

	public void setFavorited(boolean favorited) {
		this.favorited = favorited;
	}

	public Integer getFavoriteCount() {
		return favoriteCount;
	}

	public void setFavoriteCount(Integer favoriteCount) {
		this.favoriteCount = favoriteCount;
	}

	@Override
	public String toString() {
		return "HashTag [id=" + id + ", text=" + text + ", createdAt=" + createdAt + ", fromUser=" + fromUser
				+ ", profileImageUrl=" + profileImageUrl + ", toUserId=" + toUserId + ", inReplyToStatusId="
				+ inReplyToStatusId + ", inReplyToUserId=" + inReplyToUserId + ", inReplyToScreenName="
				+ inReplyToScreenName + ", fromUserId=" + fromUserId + ", languageCode=" + languageCode + ", source="
				+ source + ", retweetCount=" + retweetCount + ", retweeted=" + retweeted + ", favorited=" + favorited
				+ ", favoriteCount=" + favoriteCount + "]";
	}

}
