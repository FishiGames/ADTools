<!-- PROJECT LOGO -->
<br />
<p align="center">
  <a href="https://github.com/FishiGames/ADTools">
    <img src="https://cdn.worldvectorlogo.com/logos/active-directory-1.svg" alt="Logo">
  </a>

<h3 align="center">Java ActiveDirectory Tools</h3>

  <p align="center">
    Simple Java ActiveDirectory API
    <br />
    <a href="https://github.com/FishiGames/ADTools/issues"><strong>Report Bug »</strong></a>
    <br />
    <br />
  </p>

<!-- INTEGRATION -->
## Maven integration
```xml
<repositories>
    <repository>
        <id>unrealshards-repo</id>
        <url>https://unrealshards.com/repositories</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>at.fischer</groupId>
        <artifactId>adtools</artifactId>
        <version>1.0-SNAPSHOT</version>
        <scope>compile</scope>
    </dependency>
</dependencies>
```

<!-- USAGE EXAMPLES -->
## API-Activation
```java
//DC-Serv | "Domain" | "Admin-User" | "Password"
ADTools.activate("DomainController-01", "AD.UnrealShards.com", "FishiGames", "P4ssw0rd12E");
```


## User example:
```java
ADUser adUser = ADTools.getADUserHandler().findADUser("fishigames");
adUser.getGroups().forEach(System.out::println);
```


## Output:

```shell
$ Domain Admins
```

<!-- ROADMAP -->
## Roadmap

See the [open issues](https://github.com/FishiGames/ADTools/issues) for a list of proposed features (and known issues).


<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to be learn, inspire, and create. Any contributions you make are **greatly appreciated**.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request


<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE` for more information.
\
This API is unofficial, and we are in no way affiliated with the Microsoft Corporation.


<!-- CONTACT -->
## Contact

Twitter - [@FishiGames](https://twitter.com/FishiGames)
\
YouTube - [@FishiGames](https://www.youtube.com/channel/UC1DY8vlCtV-5fm41qsO19Qw)
\
Twitch - [@FishiGamesXD](https://twitch.tv/FishiGamesXD)
\
Project Link: [https://github.com/FishiGames/ADTools](https://github.com/FishiGames/ADTools)
