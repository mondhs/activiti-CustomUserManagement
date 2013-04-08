activiti-CustomUserManagement
=============================

Activiti - custom user management

Forum topics:
* Exchange IdentityService (or other services) http://forums.activiti.org/en/viewtopic.php?f=4&t=427
* Use own User/Group-tables: http://forums.activiti.org/en/viewtopic.php?f=3&t=345
* How to Use own User Maangement instead of Activiti provided http://forums.activiti.org/en/viewtopic.php?f=6&t=6155

This sample uses spring for configuration: src/main/resources/META-INF/spring/custom-activiti-beans.xml

Idea that 3 Activiti classes shoudl be changed:
* Explorer login should use custom implementatin./src/main/java/org/activiti/custom/explorer/ui/login/CustomDefaultLoginHandler.java 
* Custome User Manager factory that creates CustomUserEntityManager instead od UserEntityManager  ./src/main/java/org/activiti/custom/spring/CustomUserEntityManagerFactory.java 
* Custom User Manager services adapter ./src/main/java/org/activiti/custom/spring/CustomUserEntityManager.java
