# What Is Docker And Why Do We Need It?
First, let’s define the problem statement and see how Docker solves it
## The Problem Statement
Let’s consider that you’re working on an application which requires multiple technologies to be used for developing the different components like the Frontend, Backend, Database etc… Everything seems to be good, but while you’re working with all these technologies on your machine, most often there arises a problem where one technology needs one version of a dependency and some other technology needs a different one to work. Adding to this, it might also happen that your application may not work the same way on someone else’s machine or when you deploy it to different environments with different OS or hardware, it fails to run.

In order to solve all these frequent problems we use something called virtualization, let’s discuss this in more detail

### The Solution: Virtualization
Virtualization is a process whereby a software is used to create an abstraction layer over computer hardware that allows the hardware elements of a single computer to be divided into multiple virtual computers. The main idea of virtualization would be to isolate the components of our application and their dependencies into individual self-contained units that can run anywhere without any dependency or OS conflicts.

Now that we know what virtualization means, we can use it in order to solve our above stated problem. There are two ways to achieve this by leveraging the concept virtualization:

1. Virtual Machines
A Virtual Machine is essentially an emulation of a real computer that executes programs like a real computer. Virtual machines run on top of a physical machine using a Hypervisor. A hypervisor, in turn, runs on a host machine.

A Hypervisor is a piece of software, firmware, or hardware that a virtual machine runs on top of. The host machine provides the virtual machines with resources, including RAM and CPU. These resources are divided between virtual machines and can be distributed based on the applications that run on individual virtual machines.


Even though, virtual machines have solved the problem by now making our applications to run in isolation, with their own set of dependencies/libraries and OS requirements, the main issue here is that they’re very heavy since each virtual machine has it’s own Guest operating system thereby consuming a higher portion of the host machine’s resources and so take up a lot of time to start or create. This is where containers come to the rescue.
####
Containers are a light-weight, more agile way of handling virtualization, and since they don’t use a software like hypervisor, you can enjoy faster resource provisioning and speedier availability of new applications. Unlike virtual machines which provide a hardware level virtualization, containers provide an operating-system level virtualization due to which they’re very simple and easy to work with.


Image Source
Since containers are lightweight, they consume a lot less resources of the host machine compared to virtual machines. You can easily share containers while you work, and be sure that everyone you share with gets the same container that works in the same way irrespective of version conflicts between dependencies or OS.

### Now, What is Docker?
Docker is a tool which helps in developing, shipping, and running your applications on containers and enables you to separate your applications from your infrastructure so you can deliver software quickly.
It solves the problem of “it runs on my machine”. Instead of delivering jars, wars, whatever — you deliver “images”.

All someone needs to run your “image” on their machine is Docker installed.

This is awesome because the previous standard was to deliver artifacts, which means there was a dependency on environment setup and dependencies installed. But now, all of that is delivered in your image! “It runs on my machine” is now much much less of a thing.

#### Here we are going create a Dockerfile for a simple java application, build an image, push our image to Amazon's ECR, and run our containerized application.
Ensure that you have docker installed by running by checking with the following command in your terminal:

#### Dockerfile
$ docker --version
#### Clone A Java Application
```$ git clone https://github.com/manosenthill/greet-api.git```

```Cloning into 'greet-api'...
remote: Enumerating objects: 54, done.
remote: Counting objects: 100% (54/54), done.
remote: Compressing objects: 100% (43/43), done.
remote: Total 54 (delta 13), reused 22 (delta 0), pack-reused 0
Unpacking objects: 100% (54/54), done.
```
Navigate to the completed project and add an empty file in this directory called Dockerfile 

```$ cd greet-api```
```$ touch Dockerfile```

### what a Dockerfile does.
First, a Dockerfile always starts with another image called a “base-image”. This is the building block for our image, and examples include things like a red hat image or an Ubuntu image. This image can be as fat or as lean as you’d like, as we can add things to this image or build “layers”.

So, if you start with an image that already has Java installed, we won’t have to install Java later in the Dockerfile. If you don’t start with an image that is already installed, then we’ll have to install Java. At the end, this Dockerfile will be used to build another image. This final image (with all dependencies and your application added) can be delivered to those who want to run your application.

#### Building the dockerfile
    Before building our Dockerfile we have to build our application using
    ``` ./gradlew build```
    Now our jar file is ready.If you are using gradle the jar should be inside the folder '''build/libs/'''  .If it's Maven  it should be in ```target```
##### Get the base image
```FROM openjdk:8-jdk-alpine```
 which pulls jdk 8 installed on alpine os.
##### Copy the jar file into the current directory
``` COPY build/libs/greet-api-1.0-SNAPSHOT.jar .```
##### Run the application
An ENTRYPOINT instruction is used to set executables that will always run when the container is initiated.
```ENTRYPOINT ["java","-jar","/greet-api-1.0-SNAPSHOT.jar"]```
our Dockerfile will be 
``` FROM openjdk:8-jdk-alpine
COPY build/libs/greet-api-1.0-SNAPSHOT.jar .
ENTRYPOINT ["java","-jar","/greet-api-1.0-SNAPSHOT.jar"] 
```
save the Dockerfile.
##### Build the dockerImage
To build the image with the name first-image
```docker build . -t first-image```
```
Sending build context to Docker daemon  18.98MB
Step 1/3 : FROM openjdk:8-jdk-alpine
 ---> a3562aa0b991
Step 2/3 : COPY build/libs/greet-api-1.0-SNAPSHOT.jar .
 ---> 3d6d1e83d5c6
Step 3/3 : ENTRYPOINT java -jar /greet-api-1.0-SNAPSHOT.jar
 ---> Running in 7ad871461550
 ---> d03c3507dd02
Removing intermediate container 7ad871461550
Successfully built d03c3507dd02
Successfully tagged first-image:latest
```
You can verify the image built correctly with docker images :
```$ docker images ```
```
REPOSITORY                                              TAG                 IMAGE ID            CREATED             SIZE
first-image                                             latest              d03c3507dd02        6 minutes ago       122MB
```
Finally run our docker image using run command.Here the port 8090 is used .


```docker run -e SERVER_PORT=8090 -p 8090:8090 first-image```
thats our image is Up and running. Just right there we have an alpine machine running our java application. 
