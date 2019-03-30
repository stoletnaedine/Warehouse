package com.stoletnaedine.model;


import java.awt.*;

public class Storage {

	private int sizeX;

	private int sizeY;

	private final Article[][] storage;

	public Storage(int sizeX, int sizeY) {
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		storage = new Article[sizeX][sizeY];
	}

	public int getSize() {
		return sizeX * sizeY;
	}

	public Article getArticle(final Point point) {
		return storage[point.x - 1][point.y - 1];
	}

	public void setArticle(Point point, Article article) {
		storage[point.x - 1][point.y - 1] = article;
	}

	public int getX() {
		return sizeX;
	}

	public int getY() {
		return sizeY;
	}
}
