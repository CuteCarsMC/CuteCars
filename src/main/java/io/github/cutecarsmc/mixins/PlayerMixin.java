/*
 * CuteCars
 * meow moew mod
 *
 * Copyright (c) 2026 CuteCars Authors
 *
 * This program is free software: you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public License
 * as published by the Free Software Foundation, either version 3 of
 * the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program. If not, see
 * <https://www.gnu.org/licenses/>.
 */

package io.github.cutecarsmc.mixins;

import io.github.cutecarsmc.config.CuteCarsServerConfig;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.Avatar;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.NonNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Player.class)
abstract class PlayerMixin extends Avatar {
	@Shadow
	public abstract @NonNull ItemStack getWeaponItem();

	protected PlayerMixin(final EntityType<? extends LivingEntity> type, final Level level) {
		super(type, level);
	}

	@Inject(method = "isSweepAttack", at = @At("HEAD"), cancellable = true)
	private void cutecars$disableVanillaSweepMechanic(final boolean fullStrengthAttack, final boolean criticalAttack, final boolean knockbackAttack, final CallbackInfoReturnable<Boolean> cir) {
		final ItemEnchantments enchantments = this.getWeaponItem().get(DataComponents.ENCHANTMENTS);
		final int sweepingEdgeLevel = enchantments == null ? 0 : enchantments.getLevel(this.level().registryAccess().getOrThrow(Enchantments.SWEEPING_EDGE));
		if (CuteCarsServerConfig.instance().disableVanillaSweepMechanic && sweepingEdgeLevel == 0) {
			cir.setReturnValue(false);
		}
	}
}
