# NetSwitch — Portfolio Showcase

> **This file is the source of truth for portfolio descriptions.** When updating
> the portfolio site's project entry for NetSwitch, copy from here. The README
> intentionally stays short (single-commit project).

## One-liner

One-tap Android quick-settings tile + home-screen widget that deep-links to the
SIM network mode settings — built as a **zero-permission workaround** for
ColorOS devices that block `pm grant`, `appops set`, and `settings put` for the
`WRITE_SECURE_SETTINGS` permission.

## What stands out (interview pitch)

1. **Real OS-level constraint, real workaround** — the device (Realme GT Neo 3
   / ColorOS 13) refuses every standard Android permission grant route.
   Solved by `CLEAR_TASK` deep-linking to `Settings$MobileNetworkActivity` —
   the user toggles in 2 taps, no permissions needed.
3. **Two surfaces, one intent** — both the QS tile and the home-screen widget
   trigger the same deep-link (`com.android.settings.MobileNetworkActivity`).
4. **Production-grade output** — uses Android's Quick Settings Tile Service
   API (API 24+) properly, with `isListening()` and `setListening()` lifecycle.
5. **Tiny, focused, ships** — single-commit project, no bloat.

## Tech

| Layer | Tech |
|---|---|
| Language | Kotlin |
| Build | Gradle (Kotlin DSL) |
| Min/Target SDK | 24 / 34 |
| Surfaces | `TileService` + `AppWidgetProvider` |
| Permissions | **Zero** |

## Stats

- **1 APK**, **0 permissions declared** in manifest
- **2 user taps** from tile → SIM network mode changed
- **Works** on stock AOSP, ColorOS, MIUI, OneUI

## For the portfolio site

- **Slug:** `netswitch`
- **Role:** Android Developer (Side Project)
- **Description:** One-tap Android QS tile + widget deep-link that flips your
  SIM's network mode on Realme devices without root or permissions — a
  zero-permission workaround for ColorOS that blocks standard permission grant
  routes.
- **Standout:** Zero-permission deep-link to SIM network settings, works on
  ColorOS where `pm grant` and `appops set` are blocked.
- **Highlights:**
  - `TileService` API for system-level integration
  - `AppWidgetProvider` for home-screen access
  - `CLEAR_TASK` deep-link to `Settings$MobileNetworkActivity`
  - Zero permissions declared — privacy-first by design
  - Single Kotlin module, <100 LOC of meaningful code

## Repo

`https://github.com/vsriaravindan/netswitch`