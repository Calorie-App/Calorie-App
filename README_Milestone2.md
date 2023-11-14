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
      - [X] API calls fetches data from Nutrition API
      - [X] User will be able to enter the desired food through an EditText View. Which CalorieCalc will take user's input to make API calls
      - [X] Implemented functionality so user must enter value in both EditText in order to proceed.
      - [X] Toast is displayed to user stating to "Please enter values in both fields" if user did not enter values in both fields.
      - [X] Created a Food Class to construct Food Objects from JSONArray
      - [X] Fragment is working and displaying food data fetched from API
      - [X] The user is asked "What is your calorie intake goal for today?". 
      - [X] Functionality implemented where user is not able to change the calorie goal. The calorie goal value is set to user's initial input and remains constant.
      - [X] Functionality implemented to allow user to keep on adding food to the list until the calorie goal is reached.
      - [X] Functionality implemented to keep calorie count as food is added
      - [X] Toast displays message "Food can't be added since the calorie goal has been reached" once calorie goal is reached.
      - [X] Section for the user to type the food he/she desires as well as a Search button to search for the desired food.
- [X] 2+ Videos/GIFs of build progress
  Notes: Please download the GIFs. The file size is too big to view on GitHub itself.
    - UI Building Process (attached below)
    - Food Class Building Process (attached below)

- [X] Our 🎥 Demo Video
    - [X] We have also added the Demo Video Link to the Group Info Form on the course portal.
    - [X] PowerPoint: We've also created a PowerPoint for CalorieCalc
 

The following EXTRA features are implemented:
- [X] List anything else that you added to improve your submission!
  - [X] CalorieCalc takes user's calorie goal input in EditText, turns it into Text and then converts to Double
  - [X] User must first enter calorie goal and food that wants to search in order to proceed. Calorie goal is set to user's input and remains constant. Since it would be unnecessary to obligate user to enter calorie goal and food to be searched in order to proceed, functionality was implemented so the user does not have to put both inputs to proceed, user can just enter food that he/she wants to search.  
 
    

## 🎥 Demo Video


Here's a video that demos all of the app's implemented features:


## 2+ Videos/GIFs of build progress

<img src='Videos/UI_Building_Process.mp4' title='Main Page UI Building Process' width='450' alt='Main Page UI Building Process' />
<img src='Videos/Food_Building_Process.mp4' title='Food Object Building Process' width='450' alt='Food Object Building Process' />

VIDEO created with **Loom**

## CalorieCalc Narrated Demo Video
 <div>
    <a href="https://www.loom.com/share/e14c26d51ee34f0985dae92d8a7921a8">
      <p>CalorieCalc Narrated Demo Video - Watch Video</p>
    </a>
    <a href="https://www.loom.com/share/e14c26d51ee34f0985dae92d8a7921a8">
      <img style="max-width:300px;" src="https://cdn.loom.com/sessions/thumbnails/e14c26d51ee34f0985dae92d8a7921a8-with-play.gif">
    </a>
  </div>

<div style="position: relative; padding-bottom: 62.5%; height: 0;"><iframe src="https://www.loom.com/embed/e14c26d51ee34f0985dae92d8a7921a8?sid=1f6545b1-0e85-46be-89ca-1c24699c0b80" frameborder="0" webkitallowfullscreen mozallowfullscreen allowfullscreen style="position: absolute; top: 0; left: 0; width: 100%; height: 100%;"></iframe></div>


## Notes

Here's a place for any other notes on this milestone!

- PowerPoint Presentation for CalorieCalc was created as well

Things Learned:
- An intial idea made not go as planned when it comes to coding some adjustments must be made
- API KEY cannot be sent on URL for Security Reasons
- API KEY must be added to the headers
- Our approach was making a Food Class to construct a Food object from the JSONArray. There are several ways we could have gone, we chose to go with this approach.
- Learned to convert user's input in an EditText to Double 