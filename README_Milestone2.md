# AND101 Milestone 2 - **Team/App Name**

Submitted by:
- **Francisco Burgos**
- **Afaq Waris**
- **Valery Louis**
- **Teghpreet**

Time spent: **27** hours spent in total

## Summary

This document provides a summary of our project building process for our app, **App Name Here**

## Milestone Requirements

<!-- Please be sure to change the [ ] to [x] for any features you completed.  If a feature is not checked [x], you might miss the points for that item! -->

The following REQUIRED features are completed:

- [X] Assign features to each member of your group
- [X] Establish a goal time for completing each feature

The following REQUIRED files are included:

- [X] Updated 📄 `project_spec.md`, which contains:
    - [X] App Overview (Milestone 1)
    - [X] App Spec (Milestone 1)
    - [X] Checked off 2+ completed features
      - [X] API calls will fetch data from Nutrition API
      - [X] User will be able to enter the desired food through an EditText View. Which CalorieCalc will take user's input to make API calls to get information about the food entered by the user from the Nutrition API
      - [X] Implemented functionality so user must enter value in both EditText in order to proceed.
      - [X] Toast is displayed to user stating to "Please enter values in both fields" if user did not enter values in both fields.
      - [X] Created a Food Class to construct Food Objects from JSONArray
      - [X] Fragment is working and displaying fetched food data from API
      - [X] The user is asked "What is your calorie intake goal for today?". The purpose of this feature is for the user to be able to add food to the list until the calorie amount reaches his/her calorie intake goal for the day.
      - [X] Section for the user to type the food he/she desires as well as a Search button to search for the desired food.
- [X] 2+ Videos/GIFs of build progress
  - UI Building Process (attached below)
  - Food Class Building Process (attached below)

- [ ] Our 🎥 Demo Video
    - [ ] We have also added the Demo Video Link to the Group Info Form on the course portal.

The following EXTRA features are implemented:
- [] List anything else that you added to improve your submission!
    


## 🎥 Demo Video

Here's a video that demos all of the app's implemented features:

<img src='Videos/UI_Building_Process.mp4' title='Main Page UI Building Process' width='450' alt='Main Page UI Building Process' />
<img src='Videos/Food_Building_Process.mp4' title='Food Object Building Process' width='450' alt='Food Object Building Process' />

VIDEO created with **KAP**

## Notes

Here's a place for any other notes on this milestone!

- PowerPoint Presentation for CalorieCalc was created as well

Things Learned:
- An intial idea made not go as planned when it comes to coding some adjustments must be made
- API KEY cannot be sent on URL for Security Reasons
- API KEY must be added to the headers
- Our approach was making a Food Class to construct a Food object from the JSONArray. There are several ways we could have gone, we chose to go with this approach.
- Learned to convert user's input in an EditText to Double 