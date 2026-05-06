import unittest

from first_non_repeating_character import first_non_repeating_character


class TestFirstNonRepeatingCharacter(unittest.TestCase):
    def test_returns_first_non_repeating_character(self) -> None:
        self.assertEqual(first_non_repeating_character("swiss"), "w")

    def test_returns_first_unique_character_when_it_is_first(self) -> None:
        self.assertEqual(first_non_repeating_character("leetcode"), "l")

    def test_returns_none_when_all_characters_repeat(self) -> None:
        self.assertIsNone(first_non_repeating_character("aabbcc"))

    def test_returns_none_for_empty_string(self) -> None:
        self.assertIsNone(first_non_repeating_character(""))

    def test_is_case_sensitive(self) -> None:
        self.assertEqual(first_non_repeating_character("aA"), "a")


if __name__ == "__main__":
    unittest.main()
