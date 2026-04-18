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

package io.github.cutecarsmc.utils.uwuify;

import net.minecraft.util.FormattedCharSequence;
import net.minecraft.util.FormattedCharSink;
import org.jspecify.annotations.NonNull;

public final class UwuifiedCharSequence implements FormattedCharSequence {
	private final FormattedCharSequence original;
	private final String uwuified;

	public UwuifiedCharSequence(final FormattedCharSequence original) {
		this.original = original;
		this.uwuified = Uwuifier.uwuify(this.original);
	}

	@Override
	public boolean accept(final @NonNull FormattedCharSink output) {
		return original.accept((position, style, codepoint) -> {
			// thanks jab lol
			for (final int newCodepoint : (Iterable<Integer>) uwuified.chars()::iterator) {
				output.accept(position, style, newCodepoint);
			}

			return false;
		});
	}
}
