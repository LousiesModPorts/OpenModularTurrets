package openmodularturrets.tileentity.turrets;

import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import openmodularturrets.misc.ConfigHandler;
import openmodularturrets.projectiles.DisposableTurretProjectile;
import openmodularturrets.projectiles.TurretProjectile;

public class DisposableItemTurretTileEntity extends TurretHead {
    public DisposableItemTurretTileEntity() {
        super();
        this.turretTier = 0;
    }

    @Override
    public int getTurretRange() {
        return ConfigHandler.getDisposableTurretSettings().getRange();
    }

    @Override
    public int getTurretPowerUsage() {
        return ConfigHandler.getDisposableTurretSettings().getPowerUsage();
    }

    @Override
    public int getTurretFireRate() {
        return ConfigHandler.getDisposableTurretSettings().getFireRate();
    }

    @Override
    public double getTurretAccuracy() {
        return ConfigHandler.getDisposableTurretSettings().getAccuracy();
    }

    @Override
    public boolean requiresAmmo() {
        return true;
    }

    @Override
    public boolean requiresSpecificAmmo() {
        return false;
    }

    @Override
    public Item getAmmo() {
        return null;
    }

    @Override
    public TurretProjectile createProjectile(World world, Entity target, ItemStack ammo) {
        return new DisposableTurretProjectile(world, ammo);
    }

    @Override
    public String getLaunchSoundEffect() {
        return "disposable";
    }
}
