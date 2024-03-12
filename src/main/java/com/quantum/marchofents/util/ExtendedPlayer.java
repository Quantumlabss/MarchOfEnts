package com.quantum.marchofents.util;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class ExtendedPlayer implements IExtendedEntityProperties {



    public final static String EXT_PROP_NAME = "ExtendedPlayer";

    // I always include the entity to which the properties belong for easy access
    // It's final because we won't be changing which player it is
    private final EntityPlayer player;



    public ExtendedPlayer(EntityPlayer player) {
        this.player = player;
    }


    public static final void register(EntityPlayer player)
    {
        player.registerExtendedProperties(ExtendedPlayer.EXT_PROP_NAME, new ExtendedPlayer(player));
    }

    /**
     * Returns ExtendedPlayer properties for player
     * This method is for convenience only; it will make your code look nicer
     */
    public static final ExtendedPlayer get(EntityPlayer player)
    {
        return (ExtendedPlayer) player.getExtendedProperties(EXT_PROP_NAME);
    }

    // Save any custom data that needs saving here
    @Override
    public void saveNBTData(NBTTagCompound compound)
    {
        // We need to create a new tag compound that will save everything for our Extended Properties
        NBTTagCompound properties = new NBTTagCompound();

        // We only have 2 variables currently; save them both to the new tag


        // Now add our custom tag to the player's tag with a unique name (our property's name)
        // This will allow you to save multiple types of properties and distinguish between them
        // If you only have one type, it isn't as important, but it will still avoid conflicts between
        // your tag names and vanilla tag names. For instance, if you add some "Items" tag,
        // that will conflict with vanilla. Not good. So just use a unique tag name.
        compound.setTag(EXT_PROP_NAME, properties);

    }

    // Load whatever data you saved
    @Override
    public void loadNBTData(NBTTagCompound compound)
    {
        // Here we fetch the unique tag compound we set for this class of Extended Properties
        NBTTagCompound properties = (NBTTagCompound) compound.getTag(EXT_PROP_NAME);
        // Get our data from the custom tag compound

        // Just so you know it's working, add this line:

    }

    /*
    I personally have yet to find a use for this method. If you know of any,
    please let me know and I'll add it in!
    */
    @Override
    public void init(Entity entity, World world)
    {
    }
}
