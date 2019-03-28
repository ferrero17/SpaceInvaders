package com.mygdx.game;

import com.badlogic.gdx.Screen;

public class MenuScreen extends InvadersScreen {

    MenuScreen(MyGdxGame game){
        super(game);
    }


    @Override
    public void render(float delta) {

        game.setScreen(new PlayScreen(game));

    }


}
