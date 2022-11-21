# Chat messenger

Brief explanation of project and what the TA's can currently do

## A User Can: (once we write the UI)
* create account
  * requires username and password
  * confirms account creation
* log in
  * requires username and password
  * 

* Make a GroupChat
  * Uses 2 usecases: retrieve_friendslist and create_gc


## Notes


## Entities
* Chat <I>
* ChatList
* CommonUser
* CommonUserFactory
* FriendsList
* GroupChat
* GroupProfile
* Message <I>
* PrivateChat
* Profile <I>
* Rating
* User <I>
* UserFactory <I>
* UserProfile

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
