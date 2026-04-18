package io.github.cutecarsmc.utils.uwuify;

import net.minecraft.util.FormattedCharSequence;

import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

public class Uwuifier {
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
		int stringLength = original.length();

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
		var builder = new StringBuilder();
		sequence.accept((position, style, codepoint) -> {
			builder.appendCodePoint(codepoint);
			return true;
		});
		return builder.toString();
	}
}
