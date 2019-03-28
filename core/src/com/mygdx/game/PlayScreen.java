package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class PlayScreen extends InvadersScreen {

    float timer = 0;

    OrthographicCamera camera;
    FitViewport viewport;

    int SCREEN_WIDTH = 100;
    int SCREEN_HEIGHT = 100;

    World world;

    public PlayScreen(MyGdxGame game) {

        super(game);
    }

    @Override
    public void show(){
        camera = new OrthographicCamera();
        camera.position.set(SCREEN_WIDTH/2, SCREEN_HEIGHT/2,0);
        camera.update();
        viewport = new FitViewport(SCREEN_WIDTH, SCREEN_HEIGHT, camera);
        viewport.apply();

        world = new World();
        world.init(this);


    }


    @Override
    public void render(float delta){
        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        timer+=delta;
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();

        world.render(game.batch);

        game.batch.draw(game.assets.alien.getKeyFrame(timer, true),0,0, 100, 100);
        game.batch.draw(game.assets.alien2.getKeyFrame(timer, true),100,100, 100, 100);

        game.batch.end();


        //Uso de camaras para cambiar tamaños y posiciones de la misma
        if (Gdx.input.isKeyPressed(Input.Keys.A)){
            camera.zoom *= 1.1f;
        }else if (Gdx.input.isKeyPressed(Input.Keys.Z)){
            camera.zoom*= 0.9f;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.Q)){
            camera.position.x *= 1.1f;
        }else if (Gdx.input.isKeyPressed(Input.Keys.W)){

            camera.position.x *= 0.9f;
        }


        camera.update();
    }

    @Override
    public void resize(int width, int height){
        super.resize(width,height);
            viewport.update(width,height);
    }

}
