package omtteam.openmodularturrets.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import omtteam.omlib.compatibility.minecraft.CompatItem;
import omtteam.omlib.reference.OMLibNames;
import omtteam.omlib.tileentity.EnumMachineMode;
import omtteam.openmodularturrets.OpenModularTurrets;
import omtteam.openmodularturrets.init.ModItems;
import omtteam.openmodularturrets.reference.OMTNames;
import omtteam.openmodularturrets.reference.Reference;
import omtteam.openmodularturrets.tileentity.TurretBase;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.Set;

import static omtteam.omlib.util.GeneralUtil.getColoredBooleanLocalizationYesNo;
import static omtteam.omlib.util.GeneralUtil.safeLocalize;


public class UsableMetaItem extends CompatItem {
    public UsableMetaItem() {
        super();

        this.setHasSubtypes(true);
        this.setCreativeTab(OpenModularTurrets.modularTurretsTab);
        this.setRegistryName(Reference.MOD_ID, OMTNames.Items.usableMetaItem);
        this.setUnlocalizedName(OMTNames.Items.usableMetaItem);
    }

    public final static String[] subNames = {
            OMTNames.Items.bulletThrowableItem, OMTNames.Items.grenadeThrowableItem, OMTNames.Items.memoryCard
    };

    @Override
    @ParametersAreNonnullByDefault
    public boolean doesSneakBypassUse(ItemStack stack, IBlockAccess world, BlockPos pos, EntityPlayer player) {
        return stack.getItemDamage() == 2 && world.getTileEntity(pos) instanceof TurretBase || super.doesSneakBypassUse(stack, world, pos, player);
    }

    @Override
    @Nonnull
    public EnumActionResult clOnItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        ItemStack stack = player.getHeldItem(hand);
        if (stack != null && stack.getItemDamage() == 2 && player.isSneaking() && stack.hasTagCompound()) {
            //noinspection ConstantConditions
            Set<String> keySet = stack.getTagCompound().getKeySet();
            keySet.clear();
        }
        return super.clOnItemUse(player, world, pos, hand, facing, hitX, hitY, hitZ);
    }

    @Override
    protected ActionResult<ItemStack> clOnItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand hand) {
        ItemStack itemStackIn = playerIn.getHeldItem(hand);
        if (itemStackIn != null && itemStackIn.getItemDamage() == 2 && playerIn.isSneaking() && itemStackIn.hasTagCompound()) {
            //noinspection ConstantConditions
            Set<String> keySet = itemStackIn.getTagCompound().getKeySet();
            keySet.clear();
        }
        return super.clOnItemRightClick(worldIn, playerIn, hand);
    }

    @Override
    @ParametersAreNonnullByDefault
    public void clGetSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems) {
        for (int i = 0; i < 3; i++) {
            subItems.add(new ItemStack(ModItems.usableMetaItem, 1, i));
        }
    }

    @Override
    @Nonnull
    @ParametersAreNonnullByDefault
    public String getUnlocalizedName(ItemStack itemStack) {
        return "item." + subNames[itemStack.getItemDamage()];
    }

    @Override
    public int getMetadata(int damage) {
        return damage;
    }

    @SuppressWarnings("ConstantConditions")
    public boolean hasDataStored(ItemStack stack) {
        return stack.hasTagCompound() && stack.getTagCompound().hasKey("data");
    }

    @SuppressWarnings("ConstantConditions")
    public NBTTagCompound getDataStored(ItemStack stack) {
        return stack.hasTagCompound() ? stack.getTagCompound().getCompoundTag("data") : null;
    }

    @SuppressWarnings("ConstantConditions")
    public void setDataStored(ItemStack stack, NBTTagCompound nbtTagCompound) {
        if (stack.hasTagCompound()) {
            stack.getTagCompound().setTag("data", nbtTagCompound);
        } else {
            NBTTagCompound tagCompound = new NBTTagCompound();
            tagCompound.setTag("data", nbtTagCompound);
            stack.setTagCompound(tagCompound);
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean isAdvanced) {
        if (stack.getItemDamage() == 2) {
            if (hasDataStored(stack)) {
                NBTTagCompound nbtTagCompound = getDataStored(stack);
                tooltip.add(safeLocalize("tooltip.openmodularturrets.memory_card.desc1"));
                tooltip.add(safeLocalize("tooltip.openmodularturrets.memory_card.desc2"));
                tooltip.add(safeLocalize("tooltip.openmodularturrets.memory_card.desc3"));
                tooltip.add("\u00A76: \u00A7b" + nbtTagCompound.getInteger("currentMaxRange"));
                tooltip.add("\u00A76" + safeLocalize(OMLibNames.Localizations.GUI.MODE) + ": " + TurretBase.getModeAsLocString(EnumMachineMode.values()[nbtTagCompound.getInteger("mode")]));
                tooltip.add("\u00A76" + safeLocalize(OMTNames.Localizations.GUI.MULTI_TARGETING) + ": " + getColoredBooleanLocalizationYesNo(nbtTagCompound.getBoolean("multiTargeting")));
                tooltip.add("\u00A76" + safeLocalize(OMTNames.Localizations.GUI.ATTACK_MOBS) + ": " + getColoredBooleanLocalizationYesNo(nbtTagCompound.getBoolean("attacksMobs")));
                tooltip.add("\u00A76" + safeLocalize(OMTNames.Localizations.GUI.ATTACK_NEUTRALS) + ": " + getColoredBooleanLocalizationYesNo(nbtTagCompound.getBoolean("attacksNeutrals")));
                tooltip.add("\u00A76" + safeLocalize(OMTNames.Localizations.GUI.ATTACK_PLAYERS) + ": " + getColoredBooleanLocalizationYesNo(nbtTagCompound.getBoolean("attacksPlayers")));
            } else // If the stack does not have valid tag data, a default message
            {
                tooltip.add(safeLocalize("tooltip.openmodularturrets.memory_card.desc1"));
                tooltip.add(safeLocalize("tooltip.openmodularturrets.memory_card.desc2"));
                tooltip.add(safeLocalize("tooltip.openmodularturrets.memory_card.desc3"));
            }
        }
    }
}
