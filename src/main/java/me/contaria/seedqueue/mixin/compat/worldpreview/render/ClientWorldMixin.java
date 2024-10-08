package me.contaria.seedqueue.mixin.compat.worldpreview.render;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import me.contaria.seedqueue.SeedQueue;
import me.voidxwalker.worldpreview.WorldPreview;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.world.ClientWorld;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ClientWorld.class)
public abstract class ClientWorldMixin {

    // WorldPreview worlds always get created with the original WorldPreview#worldRenderer,
    // but on the Wall Screen a different WorldRenderer is used,
    // so we redirect to the currently used WorldRenderer instead
    @ModifyExpressionValue(
            method = "*",
            at = @At(
                    value = "FIELD",
                    target = "Lnet/minecraft/client/world/ClientWorld;worldRenderer:Lnet/minecraft/client/render/WorldRenderer;",
                    opcode = Opcodes.GETFIELD
            )
    )
    private WorldRenderer modifyWorldRenderer(WorldRenderer worldRenderer) {
        if (SeedQueue.isOnWall()) {
            return WorldPreview.worldRenderer;
        }
        return worldRenderer;
    }
}
