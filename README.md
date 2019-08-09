# Android_Sprint1_Challenge

## Introduction

For this challenge, you will create an app which will allow you to add movies to a list, give them a title and mark them as read or not.

<img src="https://github.com/LambdaSchool/Android_Sprint1_Challenge/blob/master/Sprint1Challenge.gif?raw=true" width="250">

## Instructions
This sprint challenge is designed to ensure that you are competent with the concepts taught during this first sprint. Please read this entire README to make sure you understand what is expected of you. Failure to read and follow the instructions and requirements will be reflected in your results.

In your solution, it is especially important that you follow best practices such as good, consistent code style. You will be scored on these aspects as well as the project requirements below.

This app will consist of two activities a list page and an edit page. Users will start in the list activity, move to the edit activity and the edit activity will return data to be used to create and add a movie to the list. The edit activity will be used to add a movie and to edit a movie. This app will be built using the Model View Controller architecture.

**You will have 3 hours to complete this sprint challenge**

* list page some how represent to user that the movie has been watch
* button on list page to add a new movie (takes you to edit page)
* tap movie on list page takes you to movies page to edit movie (pass movie to page as serializable object)
* upon leaving the edit activity, return a result which will be the new values for the movie and handle it in the list activity
> Tip: when a movie is clicked, remove the movie from the list and then re-add it when they return from the edit activity. That way you won't have to determine if the returned movie already exists

* This is very similar to our journal app, however, there are two functionality changes
  * Added Save button for user to not have to press back to return
  * Added Delete button and functionality. This will work very similarly to the add/edit functionality. Check the `ArrayList` documentation if you need help figuring out how to remove items from a list

1
