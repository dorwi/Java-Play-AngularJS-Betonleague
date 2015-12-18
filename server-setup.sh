sudo apt-get update
sudo apt-get install -y openjdk-7-jre-headless

# we also need to set the java home evnironment



## Configuring the application secret for play
## In the application.conf file set
# play.crypto.secret="changeme"
# play.crypto.secret=${?APPLICATION_SECRET}
## Also at the cloud base set the environment value APPLICATION_SECRET

# adding new user for handling the deploy
adduser deploy
# fro changing to the new user
sudo su deploy
# to grant sudo privilages use the: visudo command

# for unzipping the file
sudo apt-get install -y zip


