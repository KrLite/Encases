package net.krlite.encases.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.krlite.encases.Encases;
import net.krlite.encases.EncasesAllBlocks;
import net.krlite.encases.EncasesAllSpriteShifts;
import net.krlite.encases.EncasesAllTileEntities;
import com.simibubi.create.Create;

@Mixin(Create.class)
public class CreateMixin {
    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void init(CallbackInfo ci) {
        EncasesAllBlocks.register();
        EncasesAllTileEntities.register();
        EncasesAllSpriteShifts.register();

        Encases.REGISTRATE.register();

        Encases.LOGGER.info("Splendid Mechanic Aesthetics! ⚙️");
    }
}
