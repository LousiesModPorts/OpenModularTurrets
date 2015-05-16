package openmodularturrets;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.creativetab.CreativeTabs;
import openmodularturrets.blocks.Blocks;
import openmodularturrets.client.gui.ModularTurretsTab;
import openmodularturrets.compatability.ModCompatibility;
import openmodularturrets.entity.projectiles.BulletProjectile;
import openmodularturrets.entity.projectiles.GrenadeProjectile;
import openmodularturrets.entity.projectiles.LaserProjectile;
import openmodularturrets.entity.projectiles.RocketProjectile;
import openmodularturrets.handler.ConfigHandler;
import openmodularturrets.handler.GuiHandler;
import openmodularturrets.handler.NetworkingHandler;
import openmodularturrets.handler.ProjectileEntityHandler;
import openmodularturrets.handler.RecipeHandler;
import openmodularturrets.handler.TileEntityHandler;
import openmodularturrets.items.Items;
import openmodularturrets.network.*;
import openmodularturrets.proxy.CommonProxy;
import openmodularturrets.reference.ModInfo;

@Mod(modid = ModInfo.ID, name = ModInfo.NAME, version = ModInfo.VERSION, acceptedMinecraftVersions = "1.7.10", dependencies = "required-after:ThermalFoundation;after:OpenComputers")
public class ModularTurrets {

	@SidedProxy(clientSide = "openmodularturrets.proxy.ClientProxy", serverSide = "openmodularturrets.proxy"
			+ "" + ".CommonProxy")
	public static CommonProxy proxy;

	@Instance(ModInfo.ID)
	public static ModularTurrets instance;
	public static SimpleNetworkWrapper networking;
	public GuiHandler gui = new GuiHandler();
	public static CreativeTabs modularTurretsTab = new ModularTurretsTab(
			ModInfo.ID);

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
	
		ConfigHandler.init(event.getSuggestedConfigurationFile());
		Items.init();
		Blocks.init();
		networking = NetworkingHandler.initNetworking();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		
		ModCompatibility.checkForMods();
		NetworkRegistry.INSTANCE.registerGuiHandler(this, gui);
		TileEntityHandler.init();
		proxy.initRenderers();
		proxy.initHandlers();
		RecipeHandler.initRecipes();
		ProjectileEntityHandler.registerProjectiles(this);		
	}
}