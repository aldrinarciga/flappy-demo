package cf.aldrinarciga.flappydemo.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import cf.aldrinarciga.flappydemo.FlappyDemo;

/**
 * Created by perpetualwave on 11/04/16.
 */
public class MenuState extends State {

    private Texture background;
    private Texture playBtn;

    public MenuState(GameStateManager gameStateManager) {
        super(gameStateManager);
        background = new Texture("bg.png");
        playBtn = new Texture("playbtn.png");
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            gameStateManager.set(new PlayState(gameStateManager));
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.begin();
        spriteBatch.draw(background, 0, 0, FlappyDemo.WIDTH, FlappyDemo.HEIGHT);
        spriteBatch.draw(playBtn, getCenterX(playBtn), getCenterY(playBtn));
        spriteBatch.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playBtn.dispose();
    }

    private float getCenterX(Texture texture){
        return (FlappyDemo.WIDTH / 2) - (texture.getWidth() / 2);
    }

    private float getCenterY(Texture texture){
        return (FlappyDemo.HEIGHT / 2) - (texture.getHeight() / 2);
    }

}
