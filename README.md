MBARARA UNIVERSITY OF SCIENCE AND TECHNOLOGY
Faculty of Computing and Informatics
A PROJECT REPORT on Notification in Android 6 and 9, Telephone API (Calls, SMS, Email) and Preference, Instant Messaging in Mobile Health Application Programming. Code: HIT 6124 SUBMITTED BY 

EZEOBI DENNIS PEACE 2018/MHIT/004/PS

MIRIA KYOKUSIIMA 2018/MHIT/016/PS

Lecturers in charge; Dr. John Businge, PhD and Mr. Richard Kimera
March, 2019

Documentation on MyImmunizationApp

Immunization of children should be done well in time to protect the children from various diseases. Unfortunately, today’s life style results in parents load with too many responsibilities and stress. Due to this life styles, most times parent forget the date of getting their child immunized. Uganda has been reportedly ranked low on immunization coverage. Studies have proved that the Country records lower immunization coverage which is mostly as a result of parents not taking their children for immunization (Namuwaya, 2017) (Edward, 2013) (Catherine, 2016). Our proposed solution aims at having a high immunization coverage in Uganda (Namuwaya, 2017). The purpose of this project is to develop an Immunization Reminder App for Ugandans.

MyImmunizationApp is an android application which has been designed for parents to be notified of the important immunization dates and keep a track of the immunization schedules for their child. User will get notification one day before the scheduled immunization date. The main features of the App include; Notification on android 6 and 9, Telephone API (Call, SMS, Emails) and Preferences, Instant messaging.

Features

Login
The user signup by clicking on the signup button, and then click on update to update the stored information. Then the user can login successfully with the user profile page presented. If the user inputs wrong details or the user is not registered, the application will notify the user.

Notification
Notifications provide short, timely information about events on the app while it's not in use.
To get started, you need to set the notification's content and channel using a NotificationCompat.Builder.
The notification priority, set by setPriority(). The priority determines how intrusive the notification should be on Android 7.1 and lower. (For Android 8.0 and higher, you must instead set the channel importance.)

The main difference between notification in android 6 and 9 is that in Android 8.0 (API level 26) and higher, all notifications must be assigned to a channel or it will not appear. By categorizing notifications into channels, users can disable specific notification channels for your app (instead of disabling all your notifications), and users can control the visual and auditory options for each channel—all from the Android system settings. Users can also long-press a notification to change behaviors for the associated channel.

While on devices running Android 7.1 (API level 25) and lower, users can manage notifications on a per-app basis only (effectively each app only has one channel on Android 7.1 and lower).

Instant messaging is an online chat that offers real-time text transmission over the Internet. we created a group chat for our users to be able to interact with medical practitioners. It uses Firebase's real-time database to store the group chat messages.

Call and SMS
This allows individuals to make call and send message using the App. The design was made on the XML file while the action for the call button was implemented from the sendmessage java activity using the OnClickListener method. For the App to have access to the individuals phone contacts and to allow phone call, permission to read contacts and call phone was passed on the Manifest file. 

Email
This allows individuals to send email using their preferred App (such as Gmail and Yahoo) by clicking on the start email button. The design was made on the XML file while the action for the start email button was implemented from the email java activity using the OnClickListener method. For the App to send an email, permission to access internet was passed on the Manifest file. 
 
Preference
Preferences Activity allows the implementation of Settings screen in many android apps through which the user can configure the app preferences to their choice. For example, a user can change the message delivery notification sound or change the text font while messaging on the App using the App settings. These preferences can be used inside different applications and information are easily save to SharedPreferences and then easily access from within the App.   

Android manifest
Android manifest was used in defining application activities on how they should launch starting with the MainActivity as the main Launcher and permissions for reading and accessing phone contacts as well as External storage.
 
RegisterActivity
To register, a class called RegisterActivity was created which defines a method called insertDataIntoSQLiteDatabase() which creates an instance of contentvalues from the ContentValues class that helps in inserting data into the database.

DataBase
For admin login SQLite database was used and a class SQLiteHelper that extends SQLOpenHelper that helped me to create a database and do version control for the database.
 
Login Method
To login a method called loginFunction() is created which users the cursor to point on records in the table for user email and password.
 
Notification in android 8 and 9
In order for a user to send a notification, a class called Notification was created which extends the Application and defines a method createNotificationChannels() which helps to create two channels for API level 26 and above for android 8 and 9.
 
Notifier
A Notifier class was used to call the Notification class through the imports and defines its two methods for the notification channels that is sendOnChannel1() and sendOnChannel2() respectively as shown
 
A Service is an Android application component without a UI that runs on the main thread (of the hosting process). It also has to be declared in the AndroidManifest.xml.
