# greet-api
## Test locally
### Clone repo
Here we clone the repo into current local directory using the following with ssh enabled
      ```git clone git@github.com:manosenthill/greet-api.git```
### gradle build
We should make sure we are inside the project.
    ```cd greet-api```
    ```(base) PathmanabansMBP:greet-api pathmanaban.p$ ls```
    ```README.md	gradle		gradlew.bat	src```
    ```build.gradle	gradlew		settings.gradle```
 ###### BUILD SUCCESSFUL in 7s 
Now Jar file is created.we are going to publish our artifact into artifact repo.There are numerous artifact repo in market.Here we are going to publish it in AWS CodeArtifact. 

### publish articate
#### 1. Create Domain
#### 2. Create Repositories
         
#### 3. make sure that user has AWSCodeArtifactAdminAccess IAM policy Attached.
#### 4. 
```(base) PathmanabansMBP:greet-api pathmanaban.p$ export CODEARTIFACT_AUTH_TOKEN=`aws codeartifact get-authorization-token --domain padhu --domain-owner 146958887```
#### 5.add the maven-publish plugin to the plugins section of the project's build.gradle file.
       ```plugins {
    id 'java-library'
    id 'maven-publish'
}```
add a publishing section to the project build.gradle file.
```publishing {
  publications {
      mavenJava(MavenPublication) {
          groupId = 'org.myorg'
          artifactId = 'greet-api'
          version = '1.0'
          from components.java
      }
  }
  repositories {
      maven {
          url 'https://padhu-146958887687.d.codeartifact.us-east-1.amazonaws.com/maven/greet_trial/'
          credentials {
              username "aws"
              password System.env.CODEARTIFACT_AUTH_TOKEN
          }'''
  We have to specify groupid,artifactId and version.
  The maven-publish plugin generates a POM file based on the groupId, artifactId, and version specified in the publishing section.

   After these changes to build.gradle are complete, run the following command to build the project and upload it to the repository.
   ```./gradlew publish```
