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

package io.github.cutecarsmc.content.items;

import io.github.cutecarsmc.CuteCars;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SmithingTemplateItem;
import net.minecraft.world.item.component.ItemLore;
import net.minecraft.world.level.block.Block;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public final class CuteCarsItems {
	// lowercasebtw
	public static Item BLOCKING_UPGRADE = registerItem(
		"blocking_upgrade",
		properties -> new SmithingTemplateItem(
			CuteCars.createItemDescription("smithing_template.blocking_upgrade.applies_to"),
			CuteCars.createItemDescription("smithing_template.blocking_upgrade.ingredients"),
			Component.empty(),
			Component.empty(),
			List.of(Identifier.withDefaultNamespace("container/slot/sword")),
			List.of(Identifier.withDefaultNamespace("container/slot/ingot"), CuteCars.withPath("container/slot/block")),
			properties
				.component(DataComponents.MAX_STACK_SIZE, 1)
				.component(DataComponents.RARITY, Rarity.UNCOMMON)
				.component(DataComponents.LORE, new ItemLore(List.of(CuteCars.createItemDescription("smithing_template.blocking_upgrade.description").copy().withStyle(ChatFormatting.WHITE))))
		)
	);

	private static Item registerBlock(final Block block) {
		return registerBlock(block, BlockItem::new);
	}

	private static Item registerBlock(final Block block, final Item.Properties properties) {
		return registerBlock(block, BlockItem::new, properties);
	}

	private static Item registerBlock(final Block block, final BiFunction<Block, Item.Properties, Item> itemFactory) {
		return registerBlock(block, itemFactory, new Item.Properties());
	}

	private static Item registerBlock(final Block block, final BiFunction<Block, Item.Properties, Item> itemFactory, final Item.Properties properties) {
		return registerItem(
			ResourceKey.create(Registries.ITEM, block.builtInRegistryHolder().key().identifier()),
			p -> itemFactory.apply(block, p),
			properties.useBlockDescriptionPrefix().requiredFeatures(block.requiredFeatures())
		);
	}

	private static Item registerItem(final String name, final Function<Item.Properties, Item> itemFactory) {
		return registerItem(name, itemFactory, new Item.Properties());
	}

	private static Item registerItem(final String name, final Item.Properties properties) {
		return registerItem(name, Item::new, properties);
	}

	private static Item registerItem(final String name) {
		return registerItem(name, Item::new, new Item.Properties());
	}

	private static Item registerItem(final String name, final Function<Item.Properties, Item> itemFactory, final Item.Properties properties) {
		return registerItem(ResourceKey.create(Registries.ITEM, CuteCars.withPath(name)), itemFactory, properties);
	}

	private static Item registerItem(final ResourceKey<Item> key, final Function<Item.Properties, Item> itemFactory, final Item.Properties properties) {
		final var item = itemFactory.apply(properties.setId(key));
		if (item instanceof BlockItem blockItem) {
			blockItem.registerBlocks(Item.BY_BLOCK, item);
		}

		return Registry.register(BuiltInRegistries.ITEM, key, item);
	}

	public static void initialize() {
	}
}
