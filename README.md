# EV3OpCodes Library

## Overview
EV3OpCodes is a Java library for constructing and handling commands sent to the LEGO Mindstorms EV3 Intelligent Brick 45500. It provides an object-oriented approach to command creation, making it easier to generate and manage messages that control the EV3 brick via Bluetooth.

## Features
- Object-oriented representation of EV3 brick's opcodes
- Support for command chaining and structured message creation
- Compatible with Java projects using **Processing**
- Designed for seamless Bluetooth communication with the EV3 brick
- Lightweight and easy to integrate

## Installation
### Requirements
- **Java 8 or later**
- **Gradle** (for building the library)
- **Processing (optional)** for interfacing with the EV3 Intelligent Brick

### Building the Library
To compile and package the library, navigate to the project root and run:

```sh
./gradlew build
```

### Adding to Your Project
Include the compiled JAR file in your Java project:

```sh
javac -cp ev3opcodes.jar YourProgram.java
java -cp ev3opcodes.jar:YourProgram YourMainClass
```

## Usage Examples

### 1. Sending a Simple Command

To send a simple command, such as stopping all motors, follow these steps:

```java
StopMotors stopMotors = new StopMotors();
DirectCommand m_directCommand = new DirectCommand((short) 0, DirectCommandType.NO_REPLY_REQUIRED);

m_directCommand.addCommand(stopMotors);

Byte[] m_commandBytes = m_directCommand.getBytes();
```

Here, `DirectCommandType.NO_REPLY_REQUIRED` means that the EV3 brick does not need to send back a response. `DirectCommand` is created with a unique sequence number to ensure command order.

---

### 2. Sending a Command with Parameters

If a command requires parameters, such as specifying which motors to start, you need to prepare those parameters before sending the command. The example below demonstrates how to specify which motors should be activated:

```java
ChainLayerNumber chainLayerNumber = new ChainLayerNumberValue(ChainLayerNumber.ZERO);
MotorBitFieldValue m_motorBitField = new MotorBitFieldValue(true, false, false, false);

MoveStart moveStartCommand = new MoveStart(chainLayerNumber, m_motorBitField);
DirectCommand m_directCommand = new DirectCommand((short) 0, DirectCommandType.NO_REPLY_REQUIRED);

m_directCommand.addCommand(moveStartCommand);
Byte[] m_commandBytes = m_directCommand.getBytes();
```

- `ChainLayerNumber.ZERO` specifies the default chain layer.
- `MotorBitFieldValue` determines which motors will be activated (first motor in our case).

---

### 3. Reading Data from the EV3 Brick

To request data from the EV3 brick, you need to use a command that expects a response. The following example demonstrates how to read the battery level:

```java
BatteryLevelMemoryBlock memoryBlock = new BatteryLevelGlobalMemoryBlock(0);
ReadBatteryLevel m_batteryLevel = new ReadBatteryLevel(memoryBlock);
DirectCommand m_directCommand = new DirectCommand((short) 0, DirectCommandType.REPLY_REQUIRED);

m_directCommand.addCommand(m_batteryLevel);

Byte[] m_commandBytes = m_directCommand.getBytes();
```

Since the command requires a reply, `DirectCommandType.REPLY_REQUIRED` is used.

To process the response from the EV3 brick, use:

```java
Integer readBatteryLevel(Byte[] responseBytes) {
    if (responseBytes.length > 0)
    {
        DirectResponse response = DirectResponse.fromByteCode(responseBytes);
        if (response.getResponseType() == DirectResponseType.OK)
        {
            ResponseBuffer responseBuffer = response.getResponseBuffer();
            ReadBatteryLevel.ReturnedValues returnedValues = m_batteryLevel.getReturnedValues(responseBuffer);

            return returnedValues.getBatteryLevel();
        }
        else
        {
            throw new RuntimeException("Response of type ERROR.");
        }
    }
    else
    {
        throw new RuntimeException("No response bytes.");
    }
}
```

---

### 4. Sending Multiple Commands in One Request

To send multiple commands within a single `DirectCommand`, such as displaying an image on the EV3 LCD screen, you can queue commands together. The example below demonstrates the process:

```java
Color color = new ColorValue(Color.WHITE);
YStart yStart = new YStartValue(y);
YSize ySize = new YSizeValue(0);  // 0 means fill the entire screen

FillWindow fillWindow = new FillWindow(color, yStart, ySize);

XStart xStart = new XStartValue(x);
FileName fileName = new FileNameValue(filePath);

color = new ColorValue(Color.BLACK);
DrawBitmap drawBitmap = new DrawBitmap(color, xStart, yStart, fileName);

Update update = new Update();

DirectCommand m_directCommand = new DirectCommand((short) 0, DirectCommandType.NO_REPLY_REQUIRED);
m_directCommand.addCommand(fillWindow);
m_directCommand.addCommand(drawBitmap);
m_directCommand.addCommand(update);

Byte[] m_commandBytes = m_directCommand.getBytes();
```

- The screen buffer is cleared using `FillWindow`.
- The image is loaded into the buffer with `DrawBitmap`.
- The screen is updated using `Update`.

By chaining multiple commands, you ensure that all required operations execute in sequence without separate requests to the EV3 brick.

---

## Documentation
The full documentation, including opcode descriptions and communication details, is available in the included **PDF guides**:
- **EV3 Communication Developer Kit**

## License
This project is licensed under the **MIT License**. See the LICENSE file for details.

## Contributing
Contributions are welcome! Please open an issue or submit a pull request.

## Author
Developed by **Arkadiusz Rataj**

