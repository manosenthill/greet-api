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

Now, What is Docker?
Docker is a tool which helps in developing, shipping, and running your applications on containers and enables you to separate your applications from your infrastructure so you can deliver software quickly.


Image Source
It provides the ability to package and run an application in an isolated environment i.e; containers. The isolation and security allows you to run many containers simultaneously on a given host.

Some basic Docker terminology
Docker Engine
The Docker Engine is the core containerization technology responsible for creating and managing all the containers and other Docker objects. It acts a client-server application consisting of:

The Docker Daemon, which is a daemon process that runs in the background, keeps listening for any API requests and manages the Docker objects accordingly
A set of APIs in order to communicate with the Docker daemon
The Docker CLI client which helps users to communicate with the docker daemon and carry out the user’s requests by using these Docker APIs
Docker Image
A Docker image is just a template which includes a set of instructions or commands that are used in order to create the actual container. We can use the same docker image to create multiple docker containers

Docker Container
A Docker container is the actual instance which is based off of an image, and packages all the dependencies, libraries that an application needs and runs it in loosely coupled isolation

References
https://docs.docker.com/get-started/overview/
https://www.ibm.com/cloud/blog/containers-vs-vms
https://opensource.com/resources/virtualization
Apache Kafka: A Basic Intro
In this blog post I’ll be giving a brief and basic introduction regarding Apache Kafka and the terminology that would…
medium.com

Follow for more articles related to Docker and Software Engineering in general :)

You can also find me on
• GitHub
• Dev.to

13




