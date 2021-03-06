package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img, lemon;
	TextureAtlas atlas;
	ShapeRenderer shape;
	Sprite cherries;
	float xPos;
	float yPos;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		//img = new Texture("Characters/badlogic.jpg");
		lemon = new Texture("lemon.png");
		atlas = new TextureAtlas("sprites/sprites.txt");
		cherries = atlas.createSprite("cherries");
		xPos = 20;
		yPos = 20;
	}

	@Override
	public void render () {
		//tick();
		Gdx.gl.glClearColor(1, 1, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		//batch.draw(img, 60, 50, 64, 64);
		batch.draw(lemon, 50, 50);
		cherries.setPosition(xPos,yPos);
		cherries.draw(batch);
		batch.end();
		spriteControl();
	}

	/*public void tick(){
		y += 1;
	}*/

	private void spriteControl(){
		
		if(Gdx.input.isKeyPressed(Input.Keys.UP)){
			yPos += 10;
		}
		else if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
			yPos -=10;
		}
		else if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
			xPos += 10;
		}
		else if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
			xPos -= 10;
		}
		/*
		final boolean up = Gdx.input.isKeyPressed(Input.Keys.UP);
		final boolean down = Gdx.input.isKeyPressed(Input.Keys.DOWN);
		final boolean right = Gdx.input.isKeyPressed(Input.Keys.RIGHT);
		final boolean left = Gdx.input.isKeyPressed(Input.Keys.LEFT);

		float moveY = 10f;
		float moveX = 10f;
		moveY *= (down ? -1f : up ? 1f : 0f);
		moveX *= (left ? -1f : right ? 1f : 0f);

		//cherries.translate(moveX, moveY);
		xPos += moveX;
		yPos += moveY;

		final Rectangle bounds = cherries.getBoundingRectangle();
		final Rectangle screenBounds = new Rectangle(0,0 Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		//Screen
		float l = bounds.getX();
		float b = bounds.getY();
		float t = b + bounds.getHeight();
		float r = l + bounds.getWidth();

		float screenLeft = screenBounds.getX();
		float screenBottom = screenBounds.getY();
		float screenTop = screenBottom + screenBounds.getHeight();
		float screenRight = screenLeft + screenBounds.getWidth();

		float newX = cherries.getX();
		float newY = cherries.getY();
		*/

	}
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
		atlas.dispose();
	}
}