# OOP_java_task

# Task 1: Can You OOP?

**Deadline:** 22/4/2025 11:59 PM

## Goal

Build a console-based chat system in Java using Object-Oriented Programming (OOP).

Your program must include an interactive menu where the user can perform actions.

---

## Requirements

### 1. Core Idea

Your system should allow:

* Creating users
* Sending messages
* Viewing messages

---

### 2. Required Classes

You must create at least:

* A class that represents a user
* A class that represents a message
* A class that manages the system (chat system)

You can choose your own class names.

---

### 3. Interactive Menu

Your program must run in a loop like this:

1. Create User
2. Send Message
3. View Messages
4. Exit

The program should keep running until the user chooses **Exit**.

---

### 4. Features

#### Create User

* Ask for user name
* Store the user

#### Send Message

* Choose sender
* Choose receiver
* Enter message content
* Store the message

#### View Messages

* Choose a user
* Show all messages received by that user

---

## Design Rules

You must:

* Use objects (not just functions)
* Use private variables
* Use methods to interact with data
* Store users and messages using arrays or `ArrayList`

---

## OOP Requirement

You must include **at least one** of the following:

* Different types of users (for example: Admin, Regular)
* Different types of messages
* Different behavior for a method

### Example

Admin can send message to all users.

---

## Example Flow

```text
1 → Create User → "Ali"
1 → Create User → "Sara"
2 → Send Message → Ali → Sara → "Hello"
3 → View Messages → Sara
```

### Example Output

```text
Sara received:
From Ali: Hello
```

---

## Small Challenge (Required)

Add **one extra feature** (select from the following):

* Delete a message
* Edit a message
* Broadcast message to all users

---

## What Not to Do

* Do not put everything in one class
* Do not use only static methods
* Do not store everything as plain strings

---

## Deliverables

* Working Java program
* Interactive menu
* Clean class design
