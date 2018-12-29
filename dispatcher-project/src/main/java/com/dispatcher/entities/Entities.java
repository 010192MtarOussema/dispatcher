package com.dispatcher.entities;

import java.util.LinkedList;
import java.util.List;

import org.springframework.social.twitter.api.HashTagEntity;
import org.springframework.social.twitter.api.MediaEntity;
import org.springframework.social.twitter.api.MentionEntity;
import org.springframework.social.twitter.api.TickerSymbolEntity;
import org.springframework.social.twitter.api.TwitterObject;
import org.springframework.social.twitter.api.UrlEntity;

public class Entities extends TwitterObject {
	private List<UrlEntity> urls = new LinkedList<UrlEntity>();

	private List<HashTagEntity> tags = new LinkedList<HashTagEntity>();

	private List<MentionEntity> mentions = new LinkedList<MentionEntity>();

	private List<MediaEntity> media = new LinkedList<MediaEntity>();

	private List<TickerSymbolEntity> tickerSymbols = new LinkedList<TickerSymbolEntity>();

	public Entities(List<UrlEntity> urls, List<HashTagEntity> tags, List<MentionEntity> mentions,
			List<MediaEntity> media, List<TickerSymbolEntity> tickerSymbols) {
		super();
		this.urls = urls;
		this.tags = tags;
		this.mentions = mentions;
		this.media = media;
		this.tickerSymbols = tickerSymbols;
	}

	public Entities() {
		super();
	}

	public List<UrlEntity> getUrls() {
		return urls;
	}

	public void setUrls(List<UrlEntity> urls) {
		this.urls = urls;
	}

	public List<HashTagEntity> getTags() {
		return tags;
	}

	public void setTags(List<HashTagEntity> tags) {
		this.tags = tags;
	}

	public List<MentionEntity> getMentions() {
		return mentions;
	}

	public void setMentions(List<MentionEntity> mentions) {
		this.mentions = mentions;
	}

	public List<MediaEntity> getMedia() {
		return media;
	}

	public void setMedia(List<MediaEntity> media) {
		this.media = media;
	}

	public List<TickerSymbolEntity> getTickerSymbols() {
		return tickerSymbols;
	}

	public void setTickerSymbols(List<TickerSymbolEntity> tickerSymbols) {
		this.tickerSymbols = tickerSymbols;
	}

}
