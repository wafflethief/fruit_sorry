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

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	TextureAtlas atlas;
	ShapeRenderer shape;
	Sprite cherries;
	float xPos = 10;
	float yPos = 10;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		//img = new Texture("Characters/badlogic.jpg");
		atlas = new TextureAtlas("sprites/sprites.txt");
		cherries = atlas.createSprite("cherries");
		//y=0;
	}

	@Override
	public void render () {
		//tick();
		Gdx.gl.glClearColor(1, 1, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		//batch.draw(img, 60, 50, 64, 64);
		cherries.setPosition(xPos,yPos);
		cherries.draw(batch);
		batch.end();
		spriteControl();

	}

	/*public void tick(){
		y += 1;
	}*/

	public void spriteControl(){
		if(Gdx.input.isKeyPressed(Input.Keys.UP)){
			yPos += 20;
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){
			yPos -=20;
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)){
			xPos += 20;
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.LEFT)){
			xPos -= 20;
		}

	}
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
		atlas.dispose();
	}
}
