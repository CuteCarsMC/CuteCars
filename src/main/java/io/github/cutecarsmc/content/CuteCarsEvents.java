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

package io.github.cutecarsmc.content;

import io.github.cutecarsmc.content.items.CuteCarsItems;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public final class CuteCarsEvents {
	public static void initialize() {
		// lowercasebtw
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register(output -> output.insertAfter(Items.MACE, CuteCarsItems.BLOCKING_UPGRADE));
		LootTableEvents.MODIFY.register((key, builder, source, provider) -> {
			if (source.isBuiltin() && (BuiltInLootTables.SIMPLE_DUNGEON.equals(key) || BuiltInLootTables.TRIAL_CHAMBERS_REWARD_OMINOUS_UNIQUE.equals(key) || BuiltInLootTables.SHIPWRECK_TREASURE.equals(key) || BuiltInLootTables.VILLAGE_WEAPONSMITH.equals(key))) {
				builder.pool(LootPool.lootPool()
					.setRolls(UniformGenerator.between(0, 1.0F))
					.add(LootItem.lootTableItem(CuteCarsItems.BLOCKING_UPGRADE))
					.build());
			}
		});
	}
}
