# This document contains all the useful command to either run or deploy the app


##  Heroku commands
==============================
- To add the git repo to existing heroku app

```
heroku git:remote -a 
```
- To deploy the app to heroku

```
git push heroku master
```
- To deploy the app from other than master branch

```
git push heroku testbranch:master
```
- If heroku fails with error " remote rejected master -> master (pre-receive hook declined)
error: failed to push some refs to 'https://git.heroku.com/wordjumble.git'". restart heroku
```
heroku restart
```

### pre-requisite 
- heroku should be installed on machine


##  Commands for java
=====================

- To clean the project and then compile
```
mvn clean compile package
```
- To install maven dependencies
```
mvn install
```


