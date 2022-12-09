# Chat messenger
Brief explanation of project and what the TA's can currently do
* In order to run the program, navigate to start/Main, and run both the client and the server. Server port should be 4396, use "127.0.0.1" for ip (the loopback address). If you want to test the request friend feature, start a new project on intellij with the link to this project and have 2 window of this project open at the same time. Use a different client port on the second window to avoid conflicts and comment out the newServer() method in main to only start the program. If you want to test the program on 2 or more different device, make sure all devices are connect to the same wifi, and uses the LAN ip address of the client computer as the server ip on all clients.

## Designs: 
# Clean architecture:
* The program (both client and the server) completely follow the clean architecture design. The server side contains all four layers and the classes are packaged according to the layer they are in. The core logic is been handled on the server's interactors. All module dependencies are correctly inverted so that outer layers depend on the inner layers and not the other way aroud. On the client side, only the other 2 layers are required because the client does not handle the core logic, it rather adapts the user input data (as well as some stored data such as uid) into a String and receive the processed data and store it in the Model and the View. Once again, the majority of these classes use the functions of another class (such as the model calling the view's update method) through the interfaces the other class implement to avoid concrete dependencies across boundaries.

* Note: the project contains a few classes that has the same name, but in the actual deployment of the code of the project, the server package can be refactored into a seperate project (same with the client) and all classes would have different names.

## A User Can: 
* create account
* register
* add delete friend
* change profile
* change rating
* send message
* create private and group chat

* Make a GroupChat
  * Uses 2 usecases: retrieve_friendslist and create_gc

## Instructions to use the program

If an instruction has no operands, put a space bar after the instruction.
HELP = $help

* Message operations (put a space behind instructions that don't require inputs):
* SEND_CHAT = $send <content> (view the chat that you want to send the message to first by calling the $chat <chatUid> instruction!)
* EDIT_CHAT = $edt <msgUid>
* Sign in Sign out:
* LOGIN = $lgn <uid> <password>
* REGISTER = $reg <name> <password>
* LOGOUT = $logout 
* DELETE_ACCOUNT = $del_account

* Friends:
* REQUEST_FRIEND = $ref <friendUid>
* ACCEPT_FRIEND = $acp <uid>
* REJECT_FRIEND = $rej <uid>
* DELETE_FRIEND = $dtf <uid>

*View:
* View info:
* VIEW_CHAT = $cht <chatUid>
* VIEW_FRIENDS = $vwf
* VIEW_PROFILE = $vpr
*Change self:
* Change Profile:
* CHANGE_NAME = $chn
* CHANGE_DESC = $chd

* RATING = $rate <uid> <rating>
 

## Notes


## Entities
* Chat (abstract)
* Private Chat 
* Group Chat 
* User
* UserFactory
* Profile (abstract)
* GroupProfile
* UserProfile
* Message <I>
* Rating
* On the client side, entities are used to store data, and there are additionally a few entities belonging only to the client:
* Self extends User
* Friend extends user


## Usecases
1. usecases.create_gc.CreateGCInteractor
   * usecases.create_gc.CreateGCInteractor(CreateGCDBGateway database, CreateGCOutputBoundary output_adapter)
   * creates a new GroupChat with the relevant UIDs
2. usecases.delete_account.DeleteInteractor
   * usecases.delete_account.DeleteInteractor()
3. usecases.delete_message.DeleteInteractor
   * usecases.delete_message.DeleteInteractor()
4. usecases.edit_message.EditInteractor
   * usecases.edit_message.EditInteractor()
5. usecases.friendinteractors.addfriend.add_friend_interactor
   * usecases.friendinteractors.addfriend.add_friend_interactor()
6. usecases.friendinteractors.deletefriend.delete_friend_interactor
   * usecases.friendinteractors.deletefriend.delete_friend_interactor()
7. usecases.friendinteractors.viewfriend.view_friend_interactor
   * usecases.friendinteractors.viewfriend.view_friend_interactor()
8. usecases.login.LoginInteractor
   * usecases.login.LoginInteractor()
9. usecases.logout.LogoutInteractor
   * usecases.logout.LogoutInteractor()
10. usecases.profile_changes.ChangeProfileInteractor
    * usecases.profile_changes.ChangeProfileInteractor()
11. usecases.rating_changes.SendRatingInteractor
    * usecases.rating_changes.SendRatingInteractor()
12. usecases.register.RegisterInteractor
    * usecases.register.RegisterInteractor()
13. usecases.retrieve_friendslist.RetrieveFriendsListInteractor
    * usecases.retrieve_friendslist.RetrieveFriendsListInteractor()
    * returns the Unique IDs (UIDs) and usernames of all the user's friends
14. usecases.send_chat.SendChatInteractor
    * usecases.send_chat.SendChatInteractor()

