package openmodularturrets.handler;

import openmodularturrets.ModularTurrets;
import openmodularturrets.entity.projectiles.BulletProjectile;
import openmodularturrets.entity.projectiles.GrenadeProjectile;
import openmodularturrets.entity.projectiles.LaserProjectile;
import openmodularturrets.entity.projectiles.RocketProjectile;
import cpw.mods.fml.common.registry.EntityRegistry;

public class ProjectileEntityHandler {
	
	public static void registerProjectiles(ModularTurrets turrets)
	{
		EntityRegistry.registerModEntity(RocketProjectile.class,
				"rocketProjectile", 1, turrets, 16, 1, true);
		EntityRegistry.registerModEntity(GrenadeProjectile.class,
				"grenadeProjectile", 2, turrets, 16, 1, true);
		EntityRegistry.registerModEntity(BulletProjectile.class,
				"bulletProjectile", 3, turrets, 16, 1, true);
		EntityRegistry.registerModEntity(LaserProjectile.class,
				"laserProjectile", 4, turrets, 16, 1, true);
	}		
}
