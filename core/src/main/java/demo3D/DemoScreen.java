package demo3D;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.ModelInstance;

public class DemoScreen extends BaseScreen {

    BaseActor3D player;

    public DemoScreen(BaseGame g) {
        super(g);
    }

    @Override
    public void create() {

        BaseActor3D screen = new BaseActor3D();
        Texture screenTexture = new Texture(Gdx.files.internal("starfish-collector.png"), true);
        screenTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        ModelInstance screenInstance = ModelUtils.createBox(16, 12, 0.1f, screenTexture, null);
        screen.setModelInstance(screenInstance);
        mainStage3D.addActor(screen);

        Texture textureCrate = new Texture(Gdx.files.internal("crate.jpg"), true);

        BaseActor3D markerO = new BaseActor3D();
        ModelInstance modCrateO = ModelUtils.createBox(1 ,1, 1, textureCrate, Color.PURPLE);
        markerO.setModelInstance(modCrateO);
        markerO.setPosition(0, 0, 0);
        mainStage3D.addActor(markerO);

        BaseActor3D markerX = markerO.clone();
        markerX.setColor(Color.RED);
        markerX.setPosition(5,0,0);
        mainStage3D.addActor(markerX);

        BaseActor3D markerY = markerO.clone();
        markerY.setColor(Color.GREEN);
        markerY.setPosition(0,5,0);
        mainStage3D.addActor(markerY);

        BaseActor3D markerZ = markerO.clone();
        markerZ.setColor(Color.BLUE);
        markerZ.setPosition(0,0,5);
        mainStage3D.addActor(markerZ);

        player = new BaseActor3D();
        // alternatively to using the createCubeTexture6 method,
        // you can use crate a model instance for the player object using the code:
        // ModelInstance testModel = ModelUtils.createBox(1, 1, 1, textureCrate, Color.YELLOW);

        Texture[] textureSides = {
                new Texture(Gdx.files.internal("xneg.png")),
                new Texture(Gdx.files.internal("xpos.png")),
                new Texture(Gdx.files.internal("yneg.png")),
                new Texture(Gdx.files.internal("ypos.png")),
                new Texture(Gdx.files.internal("zneg.png")),
                new Texture(Gdx.files.internal("zpos.png"))
        };

        ModelInstance testModel = ModelUtils.createCubeTexture6(textureSides);
        player.setModelInstance(testModel);
        player.setPosition(0, 1, 8);
        mainStage3D.addActor(player);

        mainStage3D.setCameraPosition(3,4,10);
        mainStage3D.setCameraDirection(0,0,0);


    }

    @Override
    public void update(float dt) {

    }
}
