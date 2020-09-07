package demo3D;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.TextureAttribute;
import com.badlogic.gdx.graphics.g3d.utils.MeshPartBuilder;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.math.Vector3;

public class ModelUtils {

    public static ModelBuilder modelBuilder = new ModelBuilder();

    public static ModelInstance createBox(float xSize, float ySize, float zSize, Texture texture, Color color){
        Material boxMaterial = new Material();
        if (texture != null)
            boxMaterial.set(TextureAttribute.createDiffuse(texture));
        if (color != null)
            boxMaterial.set(ColorAttribute.createDiffuse(color));
        int usageCode = Usage.Position + Usage.ColorPacked + Usage.Normal + Usage.TextureCoordinates;
        Model boxModel = modelBuilder.createBox(xSize, ySize, zSize, boxMaterial, usageCode);
        Vector3 position = new Vector3(0, 0, 0);

        ModelInstance box = new ModelInstance(boxModel, position);
        return box;
    }

    public static ModelInstance createCubeTexture6(Texture[] textureSides) {

        Material[] materialSides = new Material[6];
        for (int i = 0; i < 6; i++)
        {
            materialSides[i] = new Material(
                    TextureAttribute.createDiffuse(textureSides[i]) );
        }

        MeshPartBuilder meshPartBuilder;
        ModelBuilder modelBuilder = new ModelBuilder();
        modelBuilder.begin();

        int usageCode = Usage.Position + Usage.Normal + Usage.TextureCoordinates + Usage.ColorPacked;

        modelBuilder.node().id = "negx";
        meshPartBuilder = modelBuilder.part("negx", GL20.GL_TRIANGLES, usageCode, materialSides[0] );
        meshPartBuilder.setColor(Color.WHITE);
        meshPartBuilder.rect( -0.5f,-0.5f,-0.5f, -0.5f,-0.5f,
                +0.5f, -0.5f,+0.5f,+0.5f, -0.5f,+0.5f,
                -0.5f, 0,0,-1 );

        modelBuilder.node().id = "posx";
        meshPartBuilder = modelBuilder.part("posx", GL20.GL_TRIANGLES, usageCode, materialSides[1] );
        meshPartBuilder.setColor(Color.WHITE);
        meshPartBuilder.rect( +0.5f,-0.5f,+0.5f, +0.5f,-0.5f,
                -0.5f, +0.5f,+0.5f,-0.5f, +0.5f,+0.5f,+0.5f,
                0,0,1 );

        modelBuilder.node().id = "negy";
        meshPartBuilder = modelBuilder.part("negy", GL20.GL_TRIANGLES, usageCode, materialSides[2] );
        meshPartBuilder.setColor(Color.WHITE);
        meshPartBuilder.rect( -0.5f,-0.5f,+0.5f, -0.5f,-0.5f,
                -0.5f, +0.5f,-0.5f,-0.5f, +0.5f,-0.5f,+0.5f,
                0,-1,0 );

        modelBuilder.node().id = "posy";
        meshPartBuilder = modelBuilder.part("posy", GL20.GL_TRIANGLES, usageCode, materialSides[3] );
        meshPartBuilder.setColor(Color.WHITE);
        meshPartBuilder.rect( +0.5f,+0.5f,+0.5f, +0.5f,+0.5f,
                -0.5f, -0.5f,+0.5f,-0.5f, -0.5f,+0.5f,+0.5f,
                0,1,0 );

        modelBuilder.node().id = "negz";
        meshPartBuilder = modelBuilder.part("negz", GL20.GL_TRIANGLES, usageCode, materialSides[4] );
        meshPartBuilder.setColor(Color.WHITE);
        meshPartBuilder.rect(  +0.5f,-0.5f,-0.5f, -0.5f,-0.5f,-0.5f,
                -0.5f,+0.5f,-0.5f, +0.5f,+0.5f,-0.5f,
                0,0,-1 );

        modelBuilder.node().id = "posz";
        meshPartBuilder = modelBuilder.part("posz", GL20.GL_TRIANGLES, usageCode, materialSides[5] );
        meshPartBuilder.setColor(Color.WHITE);
        meshPartBuilder.rect( -0.5f,-0.5f,+0.5f, +0.5f,-0.5f,+0.5f,
                +0.5f,+0.5f,+0.5f, -0.5f,+0.5f,+0.5f,
                0,0,1 );


        Model model = modelBuilder.end();

        return new ModelInstance(model);
    }
}
