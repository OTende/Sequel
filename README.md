# Sequel

This is an SQL quiz app that focuses on testing your knowledge of SQL concepts. It utilizes various Android components and libraries to provide a rich user experience.

<img title="" src="https://github.com/OTende/Sequel/blob/main/screenshots/6.png?raw=true" alt="Screenshot" width="220">  <img title="" src="https://github.com/OTende/Sequel/blob/main/screenshots/5.png?raw=true" alt="Screenshot" width="222">    

## Features

- Get from server: Allows users to get all the data from remote server.
- Store locally: Keep the data via Room library.
- Update: Allows users to update values in database.
- Interact: Allows users to take quizzes.
  
  <img title="" src="https://github.com/OTende/Sequel/blob/main/screenshots/2.png?raw=true" alt="Screenshot" width="205"><img title="" src="https://github.com/OTende/Sequel/blob/main/screenshots/3.png?raw=true" alt="Screenshot" width="205">

---

## Libraries Used

- [Retrofit](https://square.github.io/retrofit/): A type-safe HTTP client for Android to used to retrieve values from remote server
- [Hilt](https://developer.android.com/training/dependency-injection/hilt-android): A dependency injection framework developed specifically for Android that helps manage dependencies in your app by providing a way to define and inject them.
- [Room](https://developer.android.com/training/data-storage/room): The Room persistence library provides an abstraction layer over SQLite to allow fluent database access while harnessing the full power of SQLite.
- [Coroutines](https://kotlinlang.org/docs/coroutines-overview.html): Light-weight threads that are used to write asynchronous code for Room and Retrofit. 

--- 

## Android Components

- [Navigation Component](https://developer.android.com/guide/navigation) - For handling navigation between screens.
- [RecyclerView](https://developer.android.com/guide/topics/ui/layout/recyclerview) - For displaying the list of lectures and practices in fragments.
- [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - For observing and updating UI in real-time.
- [View Binding](https://developer.android.com/topic/libraries/view-binding) - For efficient view binding.
- [View Model](https://developer.android.com/topic/libraries/architecture/viewmodel) - For keeping and exposing values to UI.

---

### TODO:

- [x]  Add basic functionality

- [ ]  Migrate to MVI

- [ ]  Save user score

- [ ]  Add user authorization
