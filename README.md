# R24SA010_Darshan — Java OOP Practical Project

## 🎬 Movie Ticket Booking System

A **console-based Movie Ticket Booking System** developed in Java to demonstrate core **Object-Oriented Programming (OOP)** concepts and fundamental Java programming requirements.

---

## 👨‍🎓 Student Information

| Field | Details |
|---|---|
| **Student Name** | Darshan J |
| **SRN / Register No.** | R24SA010 |
| **Program** | B.Sc. (BSTCs) |
| **Semester** | V |
| **Subject** | Java Programming |
| **University** | REVA University |
| **Project Type** | Java OOP Practical Project |

---

## 📌 Project Overview

The **Movie Ticket Booking System** is a menu-driven Java console application that simulates the basic workflow of a movie ticket booking counter.

The application allows a user to:

- Register a customer
- View available movies
- Search for a movie by ID or title keyword
- Select a movie and seat type
- Book one or more seats
- Calculate the ticket amount
- Apply a service fee and GST
- Process the payment
- View booking history
- Exit the application

The project is intentionally implemented as a console application so that the focus remains on **Java programming, OOP design, control structures, arrays, methods, packages, interfaces, inheritance, abstraction, and exception handling**.

---

## 🎯 Objectives

The main objectives of this project are:

1. To develop a real-world application using Java.
2. To apply important Object-Oriented Programming concepts.
3. To demonstrate encapsulation using private data members and public methods.
4. To demonstrate inheritance, abstraction, polymorphism, and interfaces.
5. To use arrays of objects for managing movies and bookings.
6. To implement constructor and method overloading.
7. To use enums for fixed categories such as movie genres and seat types.
8. To implement console input validation.
9. To calculate booking charges using Java expressions and constants.
10. To organize the program into multiple custom packages.

---

# ✨ Features

### 1. Customer Registration
The application allows a customer to enter:

- Name
- Phone number
- Email address

A `Customer` object is created and registered.

### 2. Movie Listing
The system displays the currently loaded movies with:

- Movie ID
- Movie title
- Genre
- Duration

### 3. Movie Search
Movies can be searched using:

- Movie ID
- Movie title keyword

Title search is case-insensitive and uses `trim()`, `toLowerCase()`, and `contains()`.

### 4. Seat Type Selection

Three seat types are available:

| Seat Type | Price / Seat |
|---|---:|
| Regular | ₹150 |
| Premium | ₹220 |
| Recliner | ₹300 |

The seat types are implemented using the `SeatType` enum.

### 5. Ticket Booking
The system creates a ticket containing:

- Ticket ID
- Movie
- Customer
- Seat type
- Number of seats
- Payment status

Ticket IDs are generated automatically, starting from `T1001`.

### 6. Amount Calculation

The ticket amount is calculated using:

```text
Base Amount = Seat Price × Number of Seats
Service Fee = ₹20 × Number of Seats
GST = 18% of Base Amount

Total = Base Amount + Service Fee + GST
```

For example, two Premium seats:

```text
Base Amount = ₹220 × 2 = ₹440
Service Fee = ₹20 × 2 = ₹40
GST = ₹440 × 0.18 = ₹79.20

Total = ₹559.20
```

### 7. Payment Processing
The `Ticket` implements the `Payable` interface.

The booking service uses a `Payable` reference to calculate the amount and mark the ticket as paid.

### 8. Booking History
All successfully created tickets are stored in an array and can be displayed through the **View Bookings** option.

### 9. Input Validation
The `InputUtil` class validates integer input and repeatedly asks for valid input when the entered value is not an integer.

The application also validates:

- Movie ID
- Seat type
- Positive seat count
- Maximum ticket capacity

---

# 🏗️ Project Structure

```text
R24SA010_Darshan_JavaProject/
│
├── README.md
│
├── src/
│   └── com/
│       └── reva/
│           └── movie/
│               ├── app/
│               │   └── MovieBookingApp.java
│               │
│               ├── model/
│               │   ├── Customer.java
│               │   ├── Genre.java
│               │   ├── Movie.java
│               │   ├── Payable.java
│               │   ├── Person.java
│               │   ├── SeatType.java
│               │   ├── Staff.java
│               │   └── Ticket.java
│               │
│               ├── service/
│               │   ├── BookingService.java
│               │   └── MovieService.java
│               │
│               └── util/
│                   └── InputUtil.java
│
└── docs/
    ├── UML.txt
    ├── sample_output.txt
    └── test_run.txt
```

---

# 📦 Package Description

The project is divided into four custom packages.

### `com.reva.movie.app`

Contains the main application class.

- `MovieBookingApp.java`

This class controls the menu, user interaction, and overall application flow.

### `com.reva.movie.model`

Contains the main data/model classes.

- `Person`
- `Customer`
- `Staff`
- `Movie`
- `Ticket`
- `Payable`
- `Genre`
- `SeatType`

### `com.reva.movie.service`

Contains classes responsible for application operations.

- `MovieService`
- `BookingService`

### `com.reva.movie.util`

Contains reusable utility functionality.

- `InputUtil`

---

# 🧩 OOP Design

The project demonstrates multiple Java OOP concepts.

## 1. Encapsulation

Classes use `private` fields and public getter/setter methods.

Examples:

```java
private String name;
private String phone;
```

Access is provided through methods such as:

```java
getName()
setName()
getPhone()
setPhone()
```

Important encapsulated classes include:

- `Person`
- `Customer`
- `Movie`
- `Ticket`
- `Staff`

---

## 2. Abstraction

`Person` is declared as an abstract class:

```java
public abstract class Person
```

It contains the abstract method:

```java
public abstract String getRole();
```

This forces subclasses to provide their own role implementation.

---

## 3. Inheritance

The project uses the following inheritance hierarchy:

```text
             Person
            /      \
           /        \
     Customer       Staff
```

Both `Customer` and `Staff` extend `Person`.

---

## 4. `super` Keyword

The child classes call the parent constructor using `super(...)`.

Example:

```java
super(name, phone);
```

This initializes the common fields defined in `Person`.

---

## 5. Method Overriding

Both subclasses override:

```java
getRole()
```

`Customer` returns:

```text
Customer
```

while `Staff` returns:

```text
Staff
```

---

## 6. Dynamic Binding / Runtime Polymorphism

The application demonstrates runtime polymorphism using:

```java
Person personReference = new Staff(
    "Counter Staff",
    "9999999999",
    "STF01"
);
```

The method:

```java
personReference.getRole()
```

executes the overridden `Staff.getRole()` implementation.

---

## 7. Interface

The project defines the `Payable` interface:

```java
public interface Payable
```

It contains:

```java
double calculateAmount();
```

and a default method:

```java
printPaymentStatus()
```

`Ticket` implements this interface:

```java
public class Ticket implements Payable
```

---

## 8. Interface Reference

`BookingService` demonstrates programming through an interface:

```java
Payable payable = ticket;
```

The payment operation then calls:

```java
payable.calculateAmount();
```

This demonstrates polymorphic use of an interface reference.

---

## 9. Constructor Overloading

Constructor overloading is demonstrated in classes such as:

- `Person`
- `Customer`
- `Movie`

For example, `Customer` provides:

```java
Customer()
Customer(String name, String phone, String email)
```

---

## 10. Method Overloading

`MovieService` provides two versions of `findMovie()`:

```java
findMovie(int id)
findMovie(String title)
```

The method selected depends on the argument type.

---

## 11. Static Members

Static members are used to maintain object counts.

Examples:

```java
Person.personCount
Movie.movieCount
```

Static getter methods provide access to these counters.

---

## 12. Final Members

The project demonstrates `final` using:

```java
public static final double GST_RATE = 0.18;
```

and:

```java
private static final int MAX_TICKETS = 50;
```

The `printIdentity()` method in `Person` is also declared `final`.

`InputUtil` is a `final` utility class to prevent inheritance.

---

## 13. `this` Reference

Constructors use `this` to distinguish object fields from parameters.

Example:

```java
this.name = name;
this.phone = phone;
```

---

## 14. Object Method Overriding

The project overrides:

```java
toString()
equals()
```

For example, `Ticket` overrides `equals()` using its ticket ID and overrides `toString()` for formatted booking information.

---

## 15. Enum

Two enums are used:

### `Genre`

```text
ACTION
COMEDY
DRAMA
THRILLER
SCI_FI
```

### `SeatType`

```text
REGULAR
PREMIUM
RECLINER
```

`SeatType` also stores the price associated with each seat category.

---

# 📋 Mandatory Feature Traceability

| Java / OOP Requirement | Implementation in Project |
|---|---|
| Encapsulated classes | `Person`, `Customer`, `Staff`, `Movie`, `Ticket` use private fields with access methods |
| Data types | `int`, `double`, `boolean`, `String`, enum types |
| `final` keyword | `GST_RATE`, `MAX_TICKETS`, `MAX_MOVIES`, final fields and methods |
| Variable scope | Local variables, instance fields, static fields and method parameters |
| Operators and precedence | `Ticket.calculateAmount()` uses arithmetic expressions for booking calculation |
| Type conversion / casting | `MovieBookingApp` explicitly casts `double` ticket amount to `int` |
| Enum | `Genre` and `SeatType` |
| `if-else` / conditional logic | Validation and movie/booking checks throughout the application |
| `switch` | Main menu and seat type selection in `MovieBookingApp` |
| Loops | `while` menu loop and `for` loops for movies/bookings |
| `break` | Menu cases and validation flow |
| `continue` | Invalid seat type / invalid seat count handling |
| `return` | Methods return movies, tickets, validation results and values |
| Arrays of objects | `Movie[] movies` and `Ticket[] tickets` |
| Console I/O | `Scanner`, `System.out`, `System.out.printf` |
| Formatted output | `printf()` and `String.format()` |
| Constructor overloading | `Person`, `Customer`, `Movie` |
| Method overloading | `MovieService.findMovie(int)` and `findMovie(String)` |
| Static members | `personCount`, `movieCount` and related static methods |
| `this` reference | Constructors in model classes |
| String methods | `trim()`, `toLowerCase()`, `contains()` |
| Inheritance | `Person → Customer` and `Person → Staff` |
| `super` | `Customer` and `Staff` constructors |
| Method overriding | `getRole()`, `toString()`, `equals()` |
| Dynamic binding | `Person personReference = new Staff(...)` |
| Abstract class | `Person` |
| Abstract method | `Person.getRole()` |
| Interface | `Payable` |
| Interface implementation | `Ticket implements Payable` |
| Interface reference | `Payable payable = ticket` |
| Default interface method | `Payable.printPaymentStatus()` |
| Object method override | `Ticket.equals()`, `Ticket.toString()`, `Movie.toString()` |
| Final method | `Person.printIdentity()` |
| Final class | `InputUtil` |
| Multiple custom packages | `app`, `model`, `service`, `util` |

---

# 💰 Ticket Amount Calculation

The system uses an 18% GST rate and a service fee of ₹20 per seat.

The calculation implemented in `Ticket.calculateAmount()` is:

```java
double base = seatType.getPrice() * seatCount;
double serviceFee = 20.0 * seatCount;
return base + serviceFee + (base * GST_RATE);
```

### Example

For:

```text
Seat Type  : Premium
Seats      : 2
```

Calculation:

```text
Base amount  = 220 × 2 = ₹440.00
Service fee  = 20 × 2  = ₹40.00
GST          = 18%     = ₹79.20

Total        = ₹559.20
```

---

# 🧪 Testing

The project includes testing/output documentation inside the `docs/` directory.

### `docs/test_run.txt`

Contains a recorded test run covering the major application flow:

1. Customer registration
2. Movie listing
3. Ticket booking
4. Seat type selection
5. Amount calculation
6. Payment
7. Booking history
8. Application exit

### `docs/sample_output.txt`

Contains a readable example of the expected console interaction and output.

### Input Validation Tested

The source code also handles:

- Invalid integer input
- Invalid movie ID
- Invalid seat type
- Zero/negative seat count
- Maximum ticket capacity

---

# ▶️ How to Compile and Run

## Prerequisites

Install **Java Development Kit (JDK)**.

Verify the installation:

```bash
java -version
javac -version
```

A standard modern JDK is sufficient for this project.

---

## Compile

Open a terminal in the project root and run:

```bash
javac -d bin src/com/reva/movie/model/*.java src/com/reva/movie/service/*.java src/com/reva/movie/util/*.java src/com/reva/movie/app/*.java
```

The compiled `.class` files will be placed inside the `bin` directory.

---

## Run

Run the application using:

```bash
java -cp bin com.reva.movie.app.MovieBookingApp
```

---

# 🖥️ Main Menu

When the program starts, the following menu is displayed:

```text
1. Register Customer
2. View Movies
3. Search Movie
4. Book Tickets
5. View Bookings
6. Exit
```

---

# 🎞️ Movies Included

The application initially loads four movies:

| ID | Title | Genre | Duration |
|---:|---|---|---:|
| 101 | Sky Warriors | ACTION | 145 min |
| 102 | Laugh Out Loud | COMEDY | 120 min |
| 103 | The Last Signal | THRILLER | 132 min |
| 104 | Future Earth | SCI_FI | 150 min |

These movies are loaded by the `MovieService` constructor.

---

# 📐 UML / Class Relationships

The project contains a UML description in:

```text
docs/UML.txt
```

The main class relationships are:

```text
                 Person (abstract)
                  /            \
                 /              \
          Customer              Staff

Ticket --------implements------> Payable
  |
  |------> Movie
  |
  |------> Customer

MovieService ----manages----> Movie[]
BookingService --manages----> Ticket[]

MovieBookingApp
       |
       +----> MovieService
       |
       +----> BookingService
```

---

# 🗂️ Submission Contents

The project submission contains:

```text
README.md
src/
docs/
```

### Source Code

The `src/` directory contains all Java source files organized into packages.

### Documentation

The `docs/` directory contains:

- `UML.txt` — class relationship/UML description
- `sample_output.txt` — sample application output
- `test_run.txt` — recorded test run

### README

This file documents:

- Project information
- Project overview
- Objectives
- Features
- Project structure
- OOP concepts
- Mandatory requirement traceability
- Compilation and execution
- Testing
- UML relationships
- Submission contents

---

# 🔍 Key Classes

| Class | Responsibility |
|---|---|
| `MovieBookingApp` | Main application, menu and user interaction |
| `Person` | Abstract base class for people |
| `Customer` | Stores customer information |
| `Staff` | Represents staff and demonstrates inheritance |
| `Movie` | Stores movie information |
| `Ticket` | Stores booking information and calculates payment |
| `MovieService` | Manages movies and movie searching |
| `BookingService` | Creates, pays for and lists tickets |
| `InputUtil` | Handles reusable console input |
| `Payable` | Defines payment-related behaviour |
| `Genre` | Represents movie genres |
| `SeatType` | Represents seat categories and prices |

---

# 📚 Technologies Used

- **Java**
- **Java OOP**
- **Java Collections:** Not required; the project intentionally uses arrays of objects for the practical requirements.
- **Console I/O:** `Scanner`, `System.out`
- **Exception handling:** `NumberFormatException`
- **Custom packages**
- **Enums**
- **Interfaces**
- **Abstract classes**

---

# 🚫 Scope and Limitations

This project is a **console-based academic OOP project**, so it intentionally keeps the system simple.

Current limitations include:

- No graphical user interface
- No database
- No online payment gateway
- No persistent storage after program termination
- No individual seat-number allocation
- Movie data is predefined in the source code
- Booking capacity is limited to the fixed in-memory ticket array

These limitations keep the implementation focused on the Java/OOP requirements of the practical project.

---

# ✅ Conclusion

The **Movie Ticket Booking System** demonstrates how Java OOP concepts can be applied to a simple real-world application.

The project combines:

- Encapsulation
- Abstraction
- Inheritance
- Polymorphism
- Interfaces
- Method and constructor overloading
- Method overriding
- Enums
- Arrays of objects
- Static and final members
- Input validation
- Exception handling
- Multiple custom packages

The application provides a complete basic flow from **customer registration → movie selection → ticket booking → amount calculation → payment → booking history**.

---

## 👤 Author

**Darshan J**  
**SRN: R24SA010**  
**B.Sc. (BSTCs), Semester V**  
**REVA University**

---

### 📌 Academic Project

This project was developed as part of the **Java Programming / OOP Practical Project**.
