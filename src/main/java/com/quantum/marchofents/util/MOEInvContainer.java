package com.quantum.marchofents.util;

import com.quantum.marchofents.items.ItemNauglamir;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class MOEInvContainer extends Container {

    /** Avoid magic numbers! This will greatly reduce the chance of you making errors in 'transferStackInSlot' method */
    private static final int ARMOR_START = MOEInventory.INV_SIZE, ARMOR_END = ARMOR_START+3,
            INV_START = ARMOR_END+1, INV_END = INV_START+26, HOTBAR_START = INV_END+1,
            HOTBAR_END = HOTBAR_START+8;

    public MOEInvContainer(EntityPlayer player, InventoryPlayer inventoryPlayer, MOEInventory inventoryCustom)
    {
        int i;

        // Add CUSTOM slots - we'll just add two for now, both of the same type.
        // Make a new Slot class for each different item type you want to add
        this.addSlotToContainer(new SlotNauglamir(inventoryCustom, 0, 80, 8));
        this.addSlotToContainer(new SlotNauglamir(inventoryCustom, 1, 80, 26));

        // Add ARMOR slots; note you need to make a public version of SlotArmor
        // just copy and paste the vanilla code into a new class and change what you need
        for (i = 0; i < 4; ++i)
        {
            this.addSlotToContainer(new SlotArmor(player, inventoryPlayer, inventoryPlayer.getSizeInventory() - 1 - i, 8, 8 + i * 18,

                    i));
        }

        // Add vanilla PLAYER INVENTORY - just copied/pasted from vanilla classes
        for (i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 9; ++j)
            {
                this.addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        // Add ACTION BAR - just copied/pasted from vanilla classes
        for (i = 0; i < 9; ++i)
        {
            this.addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
        }
    }

    /**
     * This should always return true, since custom inventory can be accessed from anywhere
     */
    @Override
    public boolean canInteractWith(EntityPlayer player)
    {
        return true;
    }

    /**
     * Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
     * Basically the same as every other container I make, since I define the same constant indices for all of them
     */
    public ItemStack transferStackInSlot(EntityPlayer player, int par2)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot) this.inventorySlots.get(par2);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            // Either armor slot or custom item slot was clicked
            if (par2 < INV_START)
            {
                // try to place in player inventory / action bar
                if (!this.mergeItemStack(itemstack1, INV_START, HOTBAR_END + 1, true))
                {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            // Item is in inventory / hotbar, try to place either in custom or armor slots
            else
            {
                // if item is our custom item
                if (itemstack1.getItem() instanceof ItemNauglamir)
                {
                    if (!this.mergeItemStack(itemstack1, 0, MOEInventory.INV_SIZE, false))
                    {
                        return null;
                    }
                }
                // if item is armor
                else if (itemstack1.getItem() instanceof ItemArmor)
                {
                    int type = ((ItemArmor) itemstack1.getItem()).armorType;
                    if (!this.mergeItemStack(itemstack1, ARMOR_START + type, ARMOR_START + type + 1, false))
                    {
                        return null;
                    }
                }
                // item in player's inventory, but not in action bar
                else if (par2 >= INV_START && par2 < HOTBAR_START)
                {
                    // place in action bar
                    if (!this.mergeItemStack(itemstack1, HOTBAR_START, HOTBAR_START + 1, false))
                    {
                        return null;
                    }
                }
                // item in action bar - place in player inventory
                else if (par2 >= HOTBAR_START && par2 < HOTBAR_END + 1)
                {
                    if (!this.mergeItemStack(itemstack1, INV_START, INV_END + 1, false))
                    {
                        return null;
                    }
                }
            }

            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack) null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize)
            {
                return null;
            }

            slot.onPickupFromSlot(player, itemstack1);
        }

        return itemstack;
    }
}
