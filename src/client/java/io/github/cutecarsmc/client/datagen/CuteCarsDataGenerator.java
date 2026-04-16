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

package io.github.cutecarsmc.client.datagen;

import dev.kikugie.fletching_table.annotation.fabric.Entrypoint;
import io.github.cutecarsmc.client.datagen.assets.CuteCarsModelProvider;
import io.github.cutecarsmc.client.datagen.data.CuteCarsBlockLootTableProvider;
import io.github.cutecarsmc.client.datagen.data.CuteCarsRecipeProvider;
import io.github.cutecarsmc.client.datagen.data.tags.CuteCarsBlockTagProvider;
import io.github.cutecarsmc.client.datagen.data.tags.CuteCarsItemTagProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

@SuppressWarnings("unused")
@Entrypoint("fabric-datagen")
public final class CuteCarsDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(final FabricDataGenerator fabricDataGenerator) {
        final var pack = fabricDataGenerator.createPack();
        pack.addProvider(CuteCarsItemTagProvider::new);
        pack.addProvider(CuteCarsBlockTagProvider::new);
        pack.addProvider(CuteCarsRecipeProvider::new);
        pack.addProvider(CuteCarsBlockLootTableProvider::new);
        pack.addProvider(CuteCarsModelProvider::new);
    }
}
