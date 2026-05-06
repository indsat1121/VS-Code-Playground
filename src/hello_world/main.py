"""Command-line entry point for the hello world project."""


def build_message(name: str = "World") -> str:
    """Return a friendly greeting."""
    cleaned_name = name.strip()
    if not cleaned_name:
        cleaned_name = "World"

    return f"Hello, {cleaned_name}!"


def main() -> None:
    """Print the default greeting."""
    print(build_message())


if __name__ == "__main__":
    main()
