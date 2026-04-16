/**
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

package io.github.cutecarsmc.client;

import dev.kikugie.fletching_table.annotation.fabric.Entrypoint;
import io.github.cutecarsmc.CuteCars;
import net.fabricmc.api.ClientModInitializer;

@Entrypoint
public final class CuteCarsClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		System.out.println("Mod ID" + CuteCars.MOD_ID);
		System.out.println("Version" + CuteCars.VERSION);
		System.out.println("Commit hash" + CuteCars.COMMIT_HASH);
	}
}