package com.dispatcher.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dispatcher.entities.Entities;
import com.dispatcher.entities.HashTag;
import com.dispatcher.entities.HashTagProfile;
import com.dispatcher.repository.HashTagReposotory;

@RestController
public class HashTagController {

	@Autowired
	private HashTagReposotory hashTagRepository;

	/*
	 * @RequestMapping(value = "/findAll", method = RequestMethod.GET) public
	 * List<HashTag> show() { return hashTagRepository.findAll(); }
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/getHashagById/{id}", method = RequestMethod.GET)
	public HashTag getAllDataStar(@PathVariable String id) {
		List<HashTag> listbyId = hashTagRepository.findAll().stream().filter(e -> e.getId().equalsIgnoreCase(id))
				.collect(Collectors.toList());
		HashTag hashtag = new HashTag();
		listbyId.forEach(localList -> {
			hashtag.setId(localList.getId());
			hashtag.setText(localList.getText());

			hashtag.setCreatedAt(localList.getCreatedAt());
			hashtag.setFromUser(localList.getFromUser());
			hashtag.setProfileImageUrl(localList.getProfileImageUrl());
			hashtag.setToUserId(localList.getToUserId());
			hashtag.setLanguageCode(localList.getLanguageCode());
			hashtag.setSource(localList.getSource());

			Entities entities = new Entities();
			entities.setUrls(localList.getEntities().getUrls());
			entities.setMedia(localList.getEntities().getMedia());
			entities.setMentions(localList.getEntities().getMentions());
			entities.setTags(localList.getEntities().getTags());
			entities.setTickerSymbols(localList.getEntities().getTickerSymbols());
			hashtag.setEntities(entities);

			HashTagProfile user = new HashTagProfile();
			user.setId(localList.getUser().getId());
			user.setScreenName(localList.getUser().getScreenName());
			user.setName(localList.getUser().getName());
			user.setUrl(localList.getUser().getUrl());
			user.setProfileImageUrl(localList.getUser().getProfileImageUrl());
			user.setDescription(localList.getUser().getDescription());
			user.setLocation(localList.getUser().getLocation());
			user.setCreatedDate(localList.getUser().getCreatedDate());

			user.setLinkColor(localList.getUser().getLinkColor());
			user.setTextColor(localList.getUser().getTextColor());
			user.setBackgroundColor(localList.getUser().getBackgroundColor());
			hashtag.setUser(user);
		});

		return hashtag;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/getHashTagByText/{tag}", method = RequestMethod.GET)
	public List<HashTag> getAllDataStartWithTag(@PathVariable String tag) {

		// récupération des Hashtag
		// filtre des Hashtags where Text contient le pramétre tag
		List<HashTag> list = hashTagRepository.findAll().stream().filter(e -> e.getText().contains(tag))
				.collect(Collectors.toList());

		// récupération des Hashtag from twitter si notre database ne contient pas le le
		// tag a rechercher
		if (list.isEmpty()) {
			// The application's consumer key
			String consumerKey = "vBLrPZsP1jQahbqRJKdy6oAtu";
			// The application's consumer secret
			String consumerSecret = "yMc81PYsTqHLwd2RGfJ75Jm78wkmNejokdXOwTJFG9qJQDV2zl";
			// The access token granted after OAuth authorization
			String accessToken = "1073579717771579394-yycB5tuOcocxUkDrn5CrWnyBzdO7qy";
			// The access token secret granted after OAuth authorization
			String accessTokenSecret = "e3KCXcbh0xrOePNWCjhmUWBspmJ6JDmSDCwv6f6hNQcNQ";
			Twitter twitter = new TwitterTemplate(consumerKey, consumerSecret, accessToken, accessTokenSecret);

			List<Tweet> tweets = twitter.searchOperations().search(tag).getTweets();
			// parcourir notre list des Hashtag dans twitter et ajouter dans ntre local
			// database
			tweets.forEach(tweet -> {
				HashTag hashtag = new HashTag();
				hashtag.setId(Long.toString(tweet.getId()).substring(0, 16));

				hashtag.setText(tweet.getText());
				hashtag.setCreatedAt(tweet.getCreatedAt());
				hashtag.setFromUser(tweet.getFromUser());
				hashtag.setProfileImageUrl(tweet.getProfileImageUrl());
				hashtag.setToUserId(tweet.getToUserId());
				hashtag.setLanguageCode(tweet.getLanguageCode());
				hashtag.setSource(tweet.getSource());

				Entities entities = new Entities();
				entities.setUrls(tweet.getEntities().getUrls());
				entities.setMedia(tweet.getEntities().getMedia());
				entities.setMentions(tweet.getEntities().getMentions());
				entities.setTags(tweet.getEntities().getHashTags());
				entities.setTickerSymbols(tweet.getEntities().getTickerSymbols());
				hashtag.setEntities(entities);

				HashTagProfile user = new HashTagProfile();
				user.setId(tweet.getUser().getId());
				user.setScreenName(tweet.getUser().getScreenName());
				user.setName(tweet.getUser().getName());
				user.setUrl(tweet.getUser().getUrl());
				user.setProfileImageUrl(tweet.getUser().getProfileImageUrl());
				user.setDescription(tweet.getUser().getDescription());
				user.setLocation(tweet.getUser().getLocation());
				user.setCreatedDate(tweet.getUser().getCreatedDate());

				user.setLinkColor(tweet.getUser().getLinkColor());
				user.setTextColor(tweet.getUser().getTextColor());
				user.setBackgroundColor(tweet.getUser().getBackgroundColor());
				hashtag.setUser(user);

				list.add(hashtag);
				hashTagRepository.saveAll(list);
			});

		}

		return list;
	}

}
