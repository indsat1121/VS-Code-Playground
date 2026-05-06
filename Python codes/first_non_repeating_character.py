"""Find the first non-repeating character in a string.

Problem:
    Given a string, return the first character that appears exactly once.
    If every character repeats, return None.

How the solution works:
    The solution uses two passes over the string. In the first pass, it counts
    how often each character appears. In the second pass, it returns the first
    character whose count is one.

Why the time complexity is O(n):
    The input string is scanned twice. Two linear scans still simplify to O(n),
    where n is the number of characters in the string. Dictionary lookups and
    updates are O(1) on average.

Space complexity:
    The dictionary stores one entry per distinct character. In the worst case,
    every character is unique, so the space complexity is O(n).
"""

from typing import Optional


def first_non_repeating_character(text: str) -> Optional[str]:
    """Return the first character in text that appears once.

    Time complexity: O(n)
    Space complexity: O(n)
    """
    character_counts: dict[str, int] = {}

    for character in text:
        character_counts[character] = character_counts.get(character, 0) + 1

    for character in text:
        if character_counts[character] == 1:
            return character

    return None


if __name__ == "__main__":
    sample_text = "swiss"
    print(first_non_repeating_character(sample_text))
