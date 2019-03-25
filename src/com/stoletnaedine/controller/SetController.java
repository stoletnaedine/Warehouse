package com.stoletnaedine.controller;

import com.stoletnaedine.model.Article;
import com.stoletnaedine.model.Storage;
import com.stoletnaedine.model.exceptions.OccupiedException;

import java.awt.*;

public class SetController {

	public void setArticle(final Storage storage,
						   final Point point,
						   final Article article) throws OccupiedException {

		if (storage.getArticle(point) != null) {
			//throw OccupiedException;
		}

		storage.setArticle(point, article);

	}

}
