package com.mygdx.game;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

public class LoadingScreen extends InvadersScreen {


    public LoadingScreen(MyGdxGame game) {
        super(game);
    }

    @Override
    public void render(float delta){
        if (game.assets.update()){
            game.setScreen(new MenuScreen(game));
        }else {
            System.out.println(game.assets.getProgress());
        }


    }
}
