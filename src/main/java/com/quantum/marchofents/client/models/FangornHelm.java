import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports


public class FangornHelm extends ModelBase {
	private final ModelRenderer head;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;

	public FangornHelm() {
		textureWidth = 64;
		textureHeight = 32;

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.cubeList.add(new ModelBox(head, 0, 0, -4.0F, -7.0F, -4.0F, 8, 8, 8, 0.75F));
		head.cubeList.add(new ModelBox(head, 32, 0, -4.0F, -7.0F, -4.0F, 8, 8, 8, 1.0F));

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(-5.0F, 0.0F, 0.0F);
		head.addChild(cube_r1);
		setRotationAngle(cube_r1, -0.3927F, 0.7418F, 0.0F);
		cube_r1.cubeList.add(new ModelBox(cube_r1, 1, 1, 5.0F, -13.0F, 3.0F, 1, 5, 1, 0.0F));

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(-5.0F, 0.0F, 0.0F);
		head.addChild(cube_r2);
		setRotationAngle(cube_r2, -0.48F, 0.7418F, 0.0F);
		cube_r2.cubeList.add(new ModelBox(cube_r2, 17, 0, 4.5F, -14.25F, 1.5F, 2, 2, 2, 0.0F));

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(1.0F, 0.0F, 3.0F);
		head.addChild(cube_r3);
		setRotationAngle(cube_r3, -0.3927F, -1.0472F, 0.0F);
		cube_r3.cubeList.add(new ModelBox(cube_r3, 1, 1, -4.0F, -13.0F, 0.0F, 1, 5, 1, 0.0F));

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(1.0F, 0.0F, 3.0F);
		head.addChild(cube_r4);
		setRotationAngle(cube_r4, -0.48F, -1.0472F, 0.0F);
		cube_r4.cubeList.add(new ModelBox(cube_r4, 17, 0, -4.5F, -14.25F, -1.5F, 2, 2, 2, 0.0F));

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addChild(cube_r5);
		setRotationAngle(cube_r5, -0.48F, 0.0F, 0.0F);
		cube_r5.cubeList.add(new ModelBox(cube_r5, 17, 0, -0.5F, -14.25F, -1.5F, 2, 2, 2, 0.0F));

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addChild(cube_r6);
		setRotationAngle(cube_r6, -0.3927F, 0.0F, 0.0F);
		cube_r6.cubeList.add(new ModelBox(cube_r6, 1, 1, 0.0F, -13.0F, 0.0F, 1, 5, 1, 0.0F));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		head.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}