package com.stoletnaedine.model;


import java.awt.*;

public class Storage {

	private int sizeX;

	private int sizeY;

	private final Storage[][] storage;

	public Storage(int sizeX, int sizeY, Storage[][] storage) {
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.storage = storage;
	}

	public int getSize() {

		return sizeX * sizeY;
	}

	public Article getArticle(Storage storage, Point point) {

		return storage[point.x][point.y];

	}

	public void setArticle(Storage storage, Point point, Article article) {

		storage[point.x][point.y] = article;

	}



}
