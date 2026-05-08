# AGENTS.md

## Cursor Cloud specific instructions

### Overview

This is a Python + Java coding practice repository with no external service dependencies.

### Services

| Service | How to run |
|---------|-----------|
| Python hello-world CLI | `hello-world` (or `python3 -m hello_world.main`) |
| Java Playground | `cd "Java Playground" && javac HelloWorld.java && java HelloWorld` |

### Testing

- **pytest** (hello_world project): `pytest` from repo root (config in `pyproject.toml`)
- **unittest** (algorithm practice): `cd "Python codes" && python3 -m unittest discover`

### Notes

- `~/.local/bin` must be on `PATH` for the `hello-world` CLI and `pytest` commands (installed via `pip install --user`).
- No linter is configured in this repo; no lint step is required.
- No Docker, databases, or external services are needed.
