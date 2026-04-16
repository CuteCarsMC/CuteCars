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

package io.github.cutecarsmc;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;

public class CuteCarsBlocks {
    private static Block register(final String id, final Function<BlockBehaviour.Properties, Block> factory, final BlockBehaviour.Properties properties) {
        final var resourceKey = ResourceKey.create(Registries.BLOCK, CuteCars.withPath(id));
        final var block = factory.apply(properties.setId(resourceKey));
        return Registry.register(BuiltInRegistries.BLOCK, resourceKey, block);
    }

    private static Block register(final String id, final BlockBehaviour.Properties properties) {
        return register(id, Block::new, properties);
    }

    static void initialise() {
    }
}
