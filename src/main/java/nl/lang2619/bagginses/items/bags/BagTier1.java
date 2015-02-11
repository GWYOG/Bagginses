package nl.lang2619.bagginses.items.bags;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import nl.lang2619.bagginses.Bagginses;
import nl.lang2619.bagginses.proxy.GuiInfo;

import java.util.List;

/**
 * Created by Tim on 8/24/2014.
 */
public class BagTier1 extends Bag{
    String color;

    public BagTier1(String color) {
        super();
        maxStackSize = 1;
        setCreativeTab(Bagginses.BagTab);
        this.color = color;
        size = 15;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister register) {
        this.itemIcon = register.registerIcon("bagginses:" + "backpack_" + color);
    }

    public String getColor() {
        return color;
    }

    public String getUnlocalizedName(ItemStack itemStack) {
        return "backpack_" + color;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        if (!world.isRemote) {

            player.openGui(Bagginses.instance, GuiInfo.GUI_BACKPACK, world, 0, 0, 0);

        }
        return stack;
    }

    @Override
    public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List list, boolean p_77624_4_) {
        super.addInformation(p_77624_1_, p_77624_2_, list, p_77624_4_);
        list.add("Tier 1");
    }
}