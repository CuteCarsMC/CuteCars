package io.github.cutecarsmc.client.mixins;

import io.github.cutecarsmc.client.config.CuteCarsClientConfig;
import io.github.cutecarsmc.utils.uwuify.UwuifiedCharSequence;
import io.github.cutecarsmc.utils.uwuify.Uwuifier;
import net.minecraft.client.gui.Font;
import net.minecraft.util.FormattedCharSequence;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(Font.class)
abstract class FontMixin {
	@ModifyVariable(method = "width(Ljava/lang/String;)I", at = @At("LOAD"), argsOnly = true)
	private static String cutecars$uwuify(final String original) {
		return CuteCarsClientConfig.instance().enableUwuification ? Uwuifier.uwuify(original) : original;
	}

	@ModifyVariable(method = "width(Lnet/minecraft/util/FormattedCharSequence;)I", at = @At("LOAD"), argsOnly = true)
	private static FormattedCharSequence cutecars$uwuify(final FormattedCharSequence original) {
		return CuteCarsClientConfig.instance().enableUwuification ? new UwuifiedCharSequence(original) : original;
	}
}
