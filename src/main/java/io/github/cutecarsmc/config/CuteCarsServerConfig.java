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

package io.github.cutecarsmc.config;

import dev.isxander.yacl3.config.v2.api.ConfigClassHandler;
import dev.isxander.yacl3.config.v2.api.SerialEntry;
import dev.isxander.yacl3.config.v2.api.serializer.GsonConfigSerializerBuilder;
import dev.isxander.yacl3.platform.YACLPlatform;
import io.github.cutecarsmc.CuteCars;

public final class CuteCarsServerConfig {
	private static final ConfigClassHandler<CuteCarsServerConfig> CONFIG = ConfigClassHandler.createBuilder(CuteCarsServerConfig.class)
		.serializer((config) -> GsonConfigSerializerBuilder.create(config)
			.setPath(YACLPlatform.getConfigDir().resolve(CuteCars.MOD_ID + "_server.json"))
			.build()
		).build();

	// TODO: Add fields here (annotate with SerialEntry)
	@SerialEntry
	public boolean disableVanillaSweepMechanic = true;

	public static void load() {
		CONFIG.load();
	}

	public static void save() {
		CONFIG.save();
	}

	public static CuteCarsServerConfig instance() {
		return CONFIG.instance();
	}
}
