<h1>Mysterious Biomes</h1>
<h5>Made during SpookyJam 2017, Mysterious Biomes (Formerly Spooky Biomes) is a bundle of some spooky feeling and miscellaneous nice to have biomes to enhance your gameplay!</h5>
<h5>Don't get too spooked! And remember to keep your ears alert for dangers that lurk in the mist...</h5>

<a href="https://discord.tophatcat.dev">
    <img src="https://img.shields.io/badge/Discord-CattusMods-brightgreen.svg?style=flat&logo=Discord" alt="Discord server invite."/>
</a>

<a href="https://tophatcat.dev/">
    <img src="https://img.shields.io/badge/Website-tophatcat.dev-brightgreen.svg?style=flat" alt="Website link."/>
</a>

<a href="https://github.com/kiris-mods/mysterious-biomes/commits/dev">
    <img src="https://img.shields.io/github/last-commit/kiris-mods/mysterious-biomes.svg" alt="Latest commit.">
</a>

### Getting Started with IntelliJ IDEA

1. Clone or download this repository.
2. Open the project in IntelliJ IDEA.
3. If your default JVM/JDK is not Java 17 you will encounter an error when opening the project.  
   This error is fixed by going to `File > Settings > Build, Execution, Deployment > Build Tools > Gradle > Gradle JVM`
   and changing the value to a valid Java 17 JVM. You will also need to set the Project SDK to Java 17.  
   This can be done by going to `File > Project Structure > Project SDK`.  
   Once both have been set open the Gradle tab in IDEA and click the refresh button to reload the project.
4. Open the Gradle tab in IDEA if it has not already been opened. Navigate to `Your Project > Common > Tasks > vanilla gradle > decompile`. Run this task to decompile Minecraft. (You can also do this per loader but not required)
5. Once everything has refreshed and finished importing, restart IntelliJ, then open your Run/Debug Configurations.  
   Under the Application category there should now be options to run NeoForge, Fabric and Quilt clients and servers. Select one of these and try to run it.
6. Assuming you were able to run the game in step 5 your workspace should now be set up.  
