# Minima Social 📱

Minima Social is a modern, offline-first social media Android application designed to showcase high-quality, production-grade native development standards. It enables users to create, edit, view, and like posts with dynamic image attachments, backed by a resilient synchronization engine.

---

## 🛠️ Tech Stack & Architecture

This project is built using the latest modern Android development tools and practices:

- **Architecture:** MVVM (Model-View-ViewModel) with Unidirectional Data Flow (UDF)
- **UI Framework:** 100% Jetpack Compose with Material 3 styling
- **Navigation:** Navigation 3
- **Asynchronous Flow:** Kotlin Coroutines & Flow
- **Dependency Injection:** Hilt
- **Local Database (Caching):** Room
- **Synchronization Engine:** WorkManager (ensuring robust background operations)
- **Networking:** Retrofit + OkHttp
- **Database/Backend-as-a-Service (BaaS):** Supabase
- **Pagination:** Paging 3
- **Image Loading:** Coil
- **Preferences:** Jetpack DataStore

---

## 🚀 Key Architectural Features

### 📡 Offline-First Synchronization
Designed to handle unstable network environments seamlessly:
*   **Local-First writes:** Creating, editing, and liking posts are instantly written to the local **Room** database to ensure zero-latency UI updates.
*   **Background sync:** **WorkManager** orchestrates reliable background synchronization workers that queue, retry, and execute API calls to **Supabase** once internet connectivity is established, surviving app processes and system restarts.

### 📄 Memory-Efficient Feed Pagination
*   Leverages **Paging 3** to lazily stream social feed data.
*   Minimizes memory footprint and guarantees smooth scrolling experiences, even with dense, media-heavy layouts.

### 🎨 Modern Declarative UI & Navigation
*   Built entirely on **Jetpack Compose** with **Material 3** guidelines, supporting responsive custom layouts and clean state hoisting.
*   Utilizes **Coil** for high-performance, asynchronous image loading, memory caching, and disk caching.
*   Screen destinations are decoupled and managed cleanly using **Navigation 3**.

---

## 🏗️ Project Structure

The codebase is organized using a highly scalable, multi-module architecture separating core infrastructure from feature-specific implementations:

```text
minimasocial/
│
├── build-logic/          # Custom Gradle convention plugins for build configuration
├── app/                  # Main application module (Hilt application setup, global entry point)
│
├── core/                 # Shared infrastructure and low-level system modules
│   ├── common/           # Domain/UI helper extensions, dispatchers, and core utilities
│   ├── data/             # Repository implementations coordinating network & local caching
│   ├── database/         # Room database configuration, Entities, and DAOs
│   ├── datastore/        # Jetpack DataStore preferences (User sessions, local configs)
│   ├── designsystem/     # Reusable design components, theme assets, and style tokens
│   ├── domain/           # Use cases, business logic boundaries, and interfaces
│   ├── model/            # Shared pure Kotlin domain models
│   ├── navigation/       # Global navigation contracts and route definitions
│   ├── network/          # Retrofit interface, OkHttp configuration, and Supabase client
│   └── ui/               # Generic UI state wrappers, modifiers, and shared views
│
└── feature/              # Isolated, self-contained functional feature modules
    ├── auth/             # Authentication onboarding flows
    │   ├── login/        # User sign-in screen and validation
    │   ├── register/     # New account registration flows
    │   └── splash/       # Initial application cold-start landing screen
    ├── home/             # Main social feed displaying user posts and activity
    ├── post/             # Content publishing lifecycle
    │   ├── create/       # Post composer with dynamic media uploading
    │   ├── edit/         # Editing controls for existing user posts
    │   └── view/         # Dedicated single-post details view
    ├── profile/          # User profiles, bios, and historical user-specific posts
    └── search/           # Global user discovery and post query search
