# Hermes API

Hermes API is a programming interface to allow developers to write some plugins for Hermes Discord bots.

## Installation

[![Maven Central](https://img.shields.io/maven-central/v/fr.blueberry-studio.hermes/hermes-api.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22fr.blueberry-studio.hermes%22%20AND%20a:%22hermes-api%22)

### Maven

```xml
    <dependency>
      <groupId>fr.blueberry-studio.hermes</groupId>
      <artifactId>hermes-api</artifactId>
      <version>0.9.1-ALPHA</version>
      <scope>provided</scope>
    </dependency>
```

## Usage

Create a Java project in your favorite IDE. We recommand you to setup your project with Maven for facilities.

### Adding plugin.yml 

Add a file named `plugin.yml` at the top root of your project or in the resources folder if you are using Maven, and fill it with your plugin informations.

```yml
name: <your plugin name>
main: <your package>.<your main class>
version: <your plugin version>
author: <your username>
description: <your plugin description>
```

### Creating your plugin main class

Create a Java Class and extends it with Plugin class from the API package.
By example :

```java
import fr.blueberry.studio.hermes.api.plugins.Plugin;

public class MyPlugin extends Plugin {
}
```

### Start coding !

Once your main is created, you've several methods to get started.

```java
import fr.blueberry.studio.hermes.api.plugins.Plugin;

public class MyPlugin extends Plugin {

    //When the plugin is loaded by Hermes
    public void onLoad() {}

    //When the plugin is enabled by Hermes
    public void onEnable() {}

    //When the plugin is disabled by Hermes
    public void onDisable() {}

    //When Hermes has no connected bots to serve your events and commands.
    public void onNoTriggerer() {}

    //When all the others plugins are enabled and everything is working fine. Usefull to hook into others plugins.
    public void onPostStart() {}
}
```

### Documentation

The documentation is in progress. You can find all the documented methods in the javadoc of the project.


## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
[GPL-3.0](https://choosealicense.com/licenses/gpl-3.0)

## Thank you !

Massive thank you to everyone using Hermes ! Happy coding !