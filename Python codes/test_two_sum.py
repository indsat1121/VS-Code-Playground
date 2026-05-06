import unittest

from two_sum import two_sum


class TestTwoSum(unittest.TestCase):
    def test_returns_indices_for_basic_case(self) -> None:
        self.assertEqual(two_sum([2, 7, 11, 15], 9), [0, 1])

    def test_returns_indices_with_negative_numbers(self) -> None:
        self.assertEqual(two_sum([-3, 4, 3, 90], 0), [0, 2])

    def test_returns_indices_with_duplicate_values(self) -> None:
        self.assertEqual(two_sum([3, 3], 6), [0, 1])

    def test_raises_error_when_no_solution_exists(self) -> None:
        with self.assertRaises(ValueError):
            two_sum([1, 2, 3], 10)


if __name__ == "__main__":
    unittest.main()
