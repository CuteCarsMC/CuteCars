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

import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

public final class Uwuifier {
	private static final List<String> PHRASES = List.of(
		"UwU",
		"owo",
		"OwO",
		"uwu",
		">w<",
		"^w^",
		":3",
		"^-^",
		"^_^",
		"^w^",
		":3"
	);

	public static String uwuify(final String original) {
		final int stringLength = original.length();

		// Replace 'r' and 'l' with 'w', and 'R' and 'L' with 'W'
		// Replace 'ove' with 'uv' and 'OVE' with 'UV'
		// Replace 'o' with 'owo' and 'O' with 'OwO'
		// Replace repeated exclamation marks and question marks
		String uwuified = original
			.replaceAll("[rl]", "w").replaceAll("[RL]", "W")
			.replaceAll("ove", "uv").replaceAll("OVE", "UV")
			.replaceAll("o", "owo").replaceAll("O", "OwO")
			.replaceAll("!", "!!!").replaceAll("\\?", "???");

		// Convert to uppercase
		if (stringLength % 3 == 0) {
			uwuified = uwuified.toUpperCase(Locale.ROOT);
		}

		uwuified = Pattern.compile("%(\\p{L})").matcher(uwuified).replaceAll(m -> "%" + m.group(1).toLowerCase(Locale.ROOT));
		uwuified = Pattern.compile("\\$(\\p{L})").matcher(uwuified).replaceAll(m -> "%" + m.group(1).toLowerCase(Locale.ROOT));
		if (stringLength % 2 == 0) {
			// Add more letters to the end of words (Not numbers!)
			uwuified = uwuified.replaceAll("(\\p{L})(\\b)", "$1$1$1$1$2");
		} else {
			// 50% chance to duplicate the first letter and add '-'
			uwuified = uwuified.replaceAll("\\b(\\p{L})(\\p{L}*)\\b", "$1-$1$2");
		}

		return uwuified + " " + PHRASES.get(stringLength % PHRASES.size());
	}

	public static String uwuify(final FormattedCharSequence sequence) {
		return uwuify(charSequenceToString(sequence));
	}

	public static String charSequenceToString(final FormattedCharSequence sequence) {
		final StringBuilder builder = new StringBuilder();
		sequence.accept((position, style, codepoint) -> {
			builder.appendCodePoint(codepoint);
			return true;
		});
		return builder.toString();
	}
}
