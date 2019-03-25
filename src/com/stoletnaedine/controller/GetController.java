package com.stoletnaedine.controller;

import com.stoletnaedine.model.Article;
import com.stoletnaedine.model.Storage;

import java.awt.*;

public class GetController {

	public Storage getArticle(Storage storage, Point point, Article article) {

		if (storage.getArticle(point) != null) {
			return storage.getArticle(point);
		}

		return null;
	}

}
