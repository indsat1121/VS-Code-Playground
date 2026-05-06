from hello_world import build_message


def test_build_message_uses_default_name() -> None:
    assert build_message() == "Hello, World!"


def test_build_message_uses_provided_name() -> None:
    assert build_message("Neel") == "Hello, Neel!"


def test_build_message_falls_back_for_blank_name() -> None:
    assert build_message("   ") == "Hello, World!"
