FitnessApp
FitnessApp is an Android application built with Kotlin and Android Jetpack that helps users calculate their daily calorie needs and provides structured workout programs. It includes bodyweight, dumbbell (home) and gym-based training routines. Each exercise features an in-app video tutorial with play/pause controls.
Features
- User profile form to capture name, age, gender, height, weight and activity level
- Daily calorie requirement calculated via Harris-Benedict formula
- Home screen displaying user’s name and daily calorie target
- Bodyweight programs with three progressive levels
- Dumbbell-only home workouts across five intensity levels
- Gym split routines covering full-body, upper/lower and bodypart-focused days
- Embedded videos for each exercise with start/pause controls
- Persistent user data storage using Room database
- Modern UI built with ConstraintLayout and CardView


Prerequisites
- Android Studio Arctic Fox (or later)
- JDK 8 or higher
- Android device or emulator running API 21+

Getting Started
- Clone this repository
git clone https://github.com/your-username/FitnessApp.git
cd FitnessApp
- Open the project in Android Studio
- Build and run on a connected device or emulator
- If running on a real device, enable USB debugging and “Install via USB” in Developer Options

Usage
- On first launch, fill out your personal details in the form
- View your calculated daily calorie needs on the main screen
- Tap the Evde (home), Dumbell or Gym cards to select a workout program
- Scroll through the exercise list, then use ▶ and ⏸ buttons to control tutorial videos

Project Structure
- app/src/main/java/com/lotus/fitnessapp – Activities and Kotlin code
- app/src/main/java/com/lotus/fitnessapp/data – Room entities and DAOs
- app/src/main/res/layout – XML layouts
- app/src/main/res/drawable – Icons and image assets
- app/src/main/res/raw – Local exercise video files

Contributing
- Fork the repository
- Create a feature branch (git checkout -b feature/YourFeature)
- Commit your changes (git commit -m "Add feature")
- Push to your fork (git push origin feature/YourFeature)
- Open a pull request

License
This project is licensed under the MIT License.
