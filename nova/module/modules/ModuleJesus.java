package nova.module.modules;

import net.minecraft.block.BlockLiquid;
import net.minecraft.util.math.AxisAlignedBB;
import nova.event.EventHandler;
import nova.event.events.BlockCollisionEvent;
import nova.event.events.LivingUpdateEvent;
import nova.module.ModuleBase;

/**
 * @author Kurt Dee
 * @since 12/9/2016
 */

public class ModuleJesus extends ModuleBase {
    public ModuleJesus() {
        super();

        this.description = ("Walks on water");
    }

    @EventHandler
    public void onBlockCollision(BlockCollisionEvent e) {
        if (this.isEnabled &&
                mc.world.getBlockState(e.pos).getBlock() instanceof BlockLiquid &&
                !(mc.player.isInWater() || mc.player.isSneaking() || mc.player.fallDistance > 3)) {

            e.aabb = new AxisAlignedBB(0, 0, 0, 1, 0.99, 1);

        }
    }

    @EventHandler
    public void onLivingUpdate(LivingUpdateEvent e) {

    }
}
