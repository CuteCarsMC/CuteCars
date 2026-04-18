package io.github.cutecarsmc.client.mixins;

import io.github.cutecarsmc.client.config.CuteCarsClientConfig;
import io.github.cutecarsmc.utils.uwuify.UwuifiedCharSequence;
import net.minecraft.client.renderer.state.gui.GuiTextRenderState;
import net.minecraft.client.renderer.state.gui.ScreenArea;
import net.minecraft.util.FormattedCharSequence;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(GuiTextRenderState.class)
abstract class GuiTextRenderStateMixin implements ScreenArea {
	@ModifyVariable(method = "<init>", at = @At("LOAD"), argsOnly = true)
	private static FormattedCharSequence cutecars$uwuify(final FormattedCharSequence original) {
		return CuteCarsClientConfig.instance().enableUwuification ? new UwuifiedCharSequence(original) : original;
	}
}
