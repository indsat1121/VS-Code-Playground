"""Solution for the Two Sum problem.

Problem:
    Given a list of numbers and a target, return the indices of two numbers
    that add up to the target.

How the solution works:
    The brute-force approach checks every pair, which takes O(n^2) time.
    This solution avoids nested loops by storing each number we have already
    seen in a dictionary.

    For each number, we calculate the value needed to reach the target:

        complement = target - current_number

    If that complement is already in the dictionary, we found the answer.
    If not, we store the current number and continue.

Why the time complexity is O(n):
    We loop through the list once, so there are n iterations. Each dictionary
    lookup and insert is O(1) on average. That makes the total time complexity
    O(n).

Space complexity:
    In the worst case, we may store every number in the dictionary before
    finding a match, so the space complexity is O(n).
"""


def two_sum(numbers: list[int], target: int) -> list[int]:
    """Return indices of two values whose sum equals target.

    Time complexity: O(n)
    Space complexity: O(n)
    """
    value_to_index: dict[int, int] = {}

    for index, value in enumerate(numbers):
        # The complement is the number needed to pair with the current value.
        complement = target - value

        # Dictionary lookup is O(1) on average, so this avoids a nested loop.
        if complement in value_to_index:
            return [value_to_index[complement], index]

        # Store the current value so a later number can pair with it.
        value_to_index[value] = index

    raise ValueError("No two numbers add up to the target.")


if __name__ == "__main__":
    sample_numbers = [2, 7, 11, 15]
    sample_target = 9
    print(two_sum(sample_numbers, sample_target))
