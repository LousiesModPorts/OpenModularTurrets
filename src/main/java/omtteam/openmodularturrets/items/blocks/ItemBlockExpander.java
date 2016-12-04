package omtteam.openmodularturrets.items.blocks;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import omtteam.openmodularturrets.handler.ConfigHandler;
import omtteam.openmodularturrets.init.ModItems;
import omtteam.openmodularturrets.reference.Names;
import omtteam.openmodularturrets.reference.Reference;

import java.util.List;

/**
 * Created by Keridos on 22/07/16.
 * This Class
 */
public class ItemBlockExpander extends ItemBlock {
    public ItemBlockExpander(Block block) {
        super(block);
        setHasSubtypes(true);
        this.setRegistryName(Reference.MOD_ID, Names.Blocks.expander);
    }

    public final static String[] subNames = {
            Names.Blocks.expanderInvTierOne, Names.Blocks.expanderInvTierTwo, Names.Blocks.expanderInvTierThree,
            Names.Blocks.expanderInvTierFour, Names.Blocks.expanderInvTierFive, Names.Blocks.expanderPowerTierOne,
            Names.Blocks.expanderPowerTierTwo, Names.Blocks.expanderPowerTierThree, Names.Blocks.expanderPowerTierFour,
            Names.Blocks.expanderPowerTierFive,
    };

    @Override
    public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems) {
        for (int i = 0; i < 15; i++) {
            subItems.add(new ItemStack(ModItems.intermediateProductTiered, 1, i));
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        return "tile." + subNames[itemStack.getItemDamage()];
    }

    @Override
    public int getMetadata(int damage) {
        return damage;
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
        switch (stack.getMetadata()) {
            case 0:
                tooltip.add("");
                tooltip.add(TextFormatting.GOLD + I18n.translateToLocal("tooltip.expander.inv1"));
                tooltip.add("");
                tooltip.add(TextFormatting.WHITE + I18n.translateToLocal("tooltip.expander.inv2"));
                tooltip.add(TextFormatting.WHITE + I18n.translateToLocal("tooltip.expander.inv3") + " 4.");
                tooltip.add("");
                tooltip.add(TextFormatting.DARK_GRAY + I18n.translateToLocal("flavour.expander.inv.1"));
                return;
            case 1:
                tooltip.add("");
                tooltip.add(TextFormatting.GOLD + I18n.translateToLocal("tooltip.expander.inv1"));
                tooltip.add("");
                tooltip.add(TextFormatting.WHITE + I18n.translateToLocal("tooltip.expander.inv2"));
                tooltip.add(TextFormatting.WHITE + I18n.translateToLocal("tooltip.expander.inv3") + " 8.");
                tooltip.add("");
                tooltip.add(TextFormatting.DARK_GRAY + I18n.translateToLocal("flavour.expander.inv.2"));
                return;
            case 2:
                tooltip.add("");
                tooltip.add(TextFormatting.GOLD + I18n.translateToLocal("tooltip.expander.inv1"));
                tooltip.add("");
                tooltip.add(TextFormatting.WHITE + I18n.translateToLocal("tooltip.expander.inv2"));
                tooltip.add(TextFormatting.WHITE + I18n.translateToLocal("tooltip.expander.inv3") + " 16.");
                tooltip.add("");
                tooltip.add(TextFormatting.DARK_GRAY + I18n.translateToLocal("flavour.expander.inv.3"));
                return;
            case 3:
                tooltip.add("");
                tooltip.add(TextFormatting.GOLD + I18n.translateToLocal("tooltip.expander.inv1"));
                tooltip.add("");
                tooltip.add(TextFormatting.WHITE + I18n.translateToLocal("tooltip.expander.inv2"));
                tooltip.add(TextFormatting.WHITE + I18n.translateToLocal("tooltip.expander.inv3") + " 32.");
                tooltip.add("");
                tooltip.add(TextFormatting.DARK_GRAY + I18n.translateToLocal("flavour.expander.inv.4"));
                return;
            case 4:
                tooltip.add("");
                tooltip.add(TextFormatting.GOLD + I18n.translateToLocal("tooltip.expander.inv1"));
                tooltip.add("");
                tooltip.add(TextFormatting.WHITE + I18n.translateToLocal("tooltip.expander.inv2"));
                tooltip.add(TextFormatting.WHITE + I18n.translateToLocal("tooltip.expander.inv3") + " 64.");
                tooltip.add("");
                tooltip.add(TextFormatting.DARK_GRAY + I18n.translateToLocal("flavour.expander.inv.5"));
                return;
            case 5:
                tooltip.add("");
                tooltip.add(TextFormatting.GOLD + I18n.translateToLocal("tooltip.expander.power1"));
                tooltip.add("");
                tooltip.add(TextFormatting.WHITE + I18n.translateToLocal(
                        "tooltip.expander.power2") + " " + ConfigHandler.getExpanderPowerTierOneCapacity() + " " + I18n.translateToLocal(
                        "tooltip.expander.power3"));
                tooltip.add("");
                tooltip.add(TextFormatting.DARK_GRAY + I18n.translateToLocal("flavour.expander.power.1"));
                return;
            case 6:
                tooltip.add("");
                tooltip.add(TextFormatting.GOLD + I18n.translateToLocal("tooltip.expander.power1"));
                tooltip.add("");
                tooltip.add(TextFormatting.WHITE + I18n.translateToLocal(
                        "tooltip.expander.power2") + " " + ConfigHandler.getExpanderPowerTierTwoCapacity() + " " + I18n.translateToLocal(
                        "tooltip.expander.power3"));
                tooltip.add("");
                tooltip.add(TextFormatting.DARK_GRAY + I18n.translateToLocal("flavour.expander.power.2"));
                return;
            case 7:
                tooltip.add("");
                tooltip.add(TextFormatting.GOLD + I18n.translateToLocal("tooltip.expander.power1"));
                tooltip.add("");
                tooltip.add(TextFormatting.WHITE + I18n.translateToLocal(
                        "tooltip.expander.power2") + " " + ConfigHandler.getExpanderPowerTierThreeCapacity() + " " + I18n.translateToLocal(
                        "tooltip.expander.power3"));
                tooltip.add("");
                tooltip.add(TextFormatting.DARK_GRAY + I18n.translateToLocal("flavour.expander.power.3"));
                return;
            case 8:
                tooltip.add("");
                tooltip.add(TextFormatting.GOLD + I18n.translateToLocal("tooltip.expander.power1"));
                tooltip.add("");
                tooltip.add(TextFormatting.WHITE + I18n.translateToLocal(
                        "tooltip.expander.power2") + " " + ConfigHandler.getExpanderPowerTierFourCapacity() + " " + I18n.translateToLocal(
                        "tooltip.expander.power3"));
                tooltip.add("");
                tooltip.add(TextFormatting.DARK_GRAY + I18n.translateToLocal("flavour.expander.power.4"));
                return;
            case 9:
                tooltip.add("");
                tooltip.add(TextFormatting.GOLD + I18n.translateToLocal("tooltip.expander.power1"));
                tooltip.add("");
                tooltip.add(TextFormatting.WHITE + I18n.translateToLocal(
                        "tooltip.expander.power2") + " " + ConfigHandler.getExpanderPowerTierFiveCapacity() + " " + I18n.translateToLocal(
                        "tooltip.expander.power3"));
                tooltip.add("");
                tooltip.add(TextFormatting.DARK_GRAY + I18n.translateToLocal("flavour.expander.power.5"));
        }
    }
}