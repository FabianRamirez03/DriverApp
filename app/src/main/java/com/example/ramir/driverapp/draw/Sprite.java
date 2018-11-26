package com.example.ramir.driverapp.draw;

import android.graphics.Bitmap;

import com.example.ramir.driverapp.map.Node;

public class Sprite {

    private int x;
    private int y;
    private int width;
    private int height;
    private boolean focus = false;
    private Bitmap bitmap;
    private Node<String> node;

    public Sprite() {
    }

    public Sprite(int x, int y, int width, int height, Node<String> node) {
        this.x = x - width / 2;
        this.y = y - height / 2;
        this.width = width;
        this.height = height;
        this.node = node;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isFocus() {
        return focus;
    }

    public void setFocus(boolean focus) {
        this.focus = focus;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public Node<String> getNode() {
        return node;
    }

    public void setNode(Node<String> node) {
        this.node = node;
    }
}
