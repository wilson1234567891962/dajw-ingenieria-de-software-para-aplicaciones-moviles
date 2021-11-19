# dajw-ingenieria-de-software-para-aplicaciones-moviles
# Vinyls

Este proyecto contiene el codigo fuente de la aplicacion de android

## Comenzando 🚀

_Estas instrucciones te permitirán obtener una copia del proyecto en funcionamiento en tu máquina local para propósitos de desarrollo y pruebas._

Mira **Deployment** para conocer como desplegar el proyecto.


### Pre-requisitos 📋

Para poder ejecutar de manera correcta el proyecto debe tener configurado las siguientes herramientas en su maquina

```
Git,               Version  2.21.0
Kraken,            Version  1.0.9  
ADB Android ,      Version  30.0.5-6877874   
ChromeDriver       Version  ChromeDriver 90.0.4430.24
Java               Version  1.8.0_91
Android studio     Version  ArticFox
```

### Instalación 🔧

En este caso para ejecutar el proyecto debe haber instalado las herramientas indicadas anteriormente en el paso de **Pre-requisitos**, una vez instaladas debe ejecutar lo siguiente 

Pasos

```
Revisar que se encuentre configurado node de manera correcta, se realiza de la siguiente manera
```

* Abrir la terminal de su equipo, esta guia estara para un sistema operativo Windows, pero si configuro de manera exitosa las herramientas nombradas en  **Pre-requisitos** no deberia haber diferencia.

![Terminal](https://user-images.githubusercontent.com/78820446/117479939-8cc0dd80-af26-11eb-85a5-b3559aa18ac5.PNG)


* Ejecutar el comando node -v en la terminal, si aparece la version  esto indicaria que se encuentre instalado de manera correcta, en caso contrario debera revisar la instalacion de node en su maquina 

![Node ](https://user-images.githubusercontent.com/78820446/117480756-9eef4b80-af27-11eb-98bd-cb7756ef43ac.PNG)


El siguiente paso 

```
Revisar que se encuentre configurado cypress de manera correcta, se realiza de la siguiente manera
```

* Abrir la terminal de su equipo, puede ser la misma que abrio en el paso anterior para verificar  la instalacion de node

![Terminal](https://user-images.githubusercontent.com/78820446/117479939-8cc0dd80-af26-11eb-85a5-b3559aa18ac5.PNG)

* Ahora ejecutar el siguiente comando **Cypress -v**, en caso que no aparesca las versiones en cada campo deberia revisar la instalacion del cypress

![Cypress version](https://user-images.githubusercontent.com/78820446/117480168-dd383b00-af26-11eb-84f1-c3ef654e1a8a.PNG)


El siguiente paso 

```
Revisar que tenga instalado git en su maquina, se realiza de la siguiente manera
```

* Abrir la terminal de su equipo, puede ser la misma que abrio en el paso anterior para verificar  la instalacion de node

![Terminal](https://user-images.githubusercontent.com/78820446/117479939-8cc0dd80-af26-11eb-85a5-b3559aa18ac5.PNG)

* Ahora ejecutar el siguiente comando **git --version**, en caso que no aparesca la version debera revisar la instalacion de git

![git](https://user-images.githubusercontent.com/78820446/117470240-351d7480-af1c-11eb-9032-03f81b674975.PNG)



El siguiente paso

```
Revisar que tenga instalado ruby de manera correcta
```

* Sobre la terminal ejecutada debe ejecutar el siguiente comando **ruby -v**, en caso que no aparesca la version debera revisar la instalacion de **ruby**

![ruby](https://user-images.githubusercontent.com/78820446/117545809-028f7c80-afed-11eb-9e57-9ce0ac6c87d5.PNG)



El siguiente paso

```
Revisar que tenga instalado java  y configurado 
```

* Sobre la terminal ejecutada debe ejecutar el siguiente comando **java  -version** en caso que no aparesca la version deberia revisar la instalacion 

![Java](https://user-images.githubusercontent.com/78820446/117546069-2ef7c880-afee-11eb-9eda-64cd2bdd8a10.PNG)

* Si se reconoce el comando **java -version** debera configurar las siguientes variables de entorno en el computador 

  - JAVA_HOME Ingresar la ruta donde se encuentra instalado su JDK 

![JAVA ENTORNO](https://user-images.githubusercontent.com/78820446/117546738-80558700-aff1-11eb-85c4-91102e2994dd.PNG)

  - Adicional agregar las siguientes variables de entorno en la opcion de **path**:  **%JAVA_HOME%\bin** 

![JAVA ENTORNO](https://user-images.githubusercontent.com/78820446/117546768-b72b9d00-aff1-11eb-9bc9-324525a90433.PNG)




El siguiente paso

```
Revisar que tenga configurado adb de manera correcta y se reconozca el comando por la terminal 

```

* Sobre la terminal ejecutada debe ejecutar el siguiente comando **adb --version** en caso que no aparesca la version deberia revisar la instalacion 


![ab](https://user-images.githubusercontent.com/78820446/117546179-cc52fc80-afee-11eb-9788-d93a68e83aa5.PNG)

* Si se encuentra configurado el **adb** de manera correcta deberan configurar las siguientes variables de entorno adicionales para el correcto funcionamiento

  - ANDROID_HOME
  
![Android  sdk](https://user-images.githubusercontent.com/78820446/117546292-54d19d00-afef-11eb-93b4-9197aa4e9880.PNG)

![SDK configuracion](https://user-images.githubusercontent.com/78820446/117546341-93675780-afef-11eb-959a-6c230f0e6253.PNG)

  - Adicional agregar las siguientes variables de entorno en la opcion de **path**:  **%ANDROID_HOME%\tools** **%ANDROID_HOME%\tools\bin** **C:\Users\wilso\AppData\Local\Android\Sdk\platform-tools poner la ruta de su SDK** 

![entorno](https://user-images.githubusercontent.com/78820446/117546536-7da66200-aff0-11eb-804c-8101510b99b9.png)


El siguiente paso 


```
Clonar el repositorio a traves de git siguiendo los siguientes pasos 
```

* Crear una carpeta vacia en cualquier ubicacion de su equipo, es importante que no contenga espacios en blanco 
 
* Abrir la terminal y ubicarse en la ruta donde se encuentra creada la carpeta a traves de la terminal 


* Clonar el repositorio a traves del siguiente commando  **git clone https://github.com/wilson1234567891962/dajw-ingenieria-de-software-para-aplicaciones-moviles.git**

![git](https://user-images.githubusercontent.com/78820446/117548460-c7944580-affa-11eb-87bd-e5e574837e68.PNG)



El siguiente paso 


```
Dirigirse a  la carpeta clonada con la terminal del paso anterior 
```

* Sobre la carpeta creada en el paso anterior y el proyecto clonado, debe ejecutarse el siguiente comando **cd dajw-ingenieria-de-software-para-aplicaciones-moviles/**

![Captura](https://user-images.githubusercontent.com/33532595/140616455-b1ab21e2-d646-410b-a6ff-b103cf6c5361.JPG)


* Ahora una ves clonado el repositorio, vamos abrir el proyecto con android studio es importante que sea la version indica **Fox**

**Imagen de visualizacion de android**

![Captura](https://user-images.githubusercontent.com/33532595/140616497-0d368124-e521-4bab-91fb-5ef1265375cf.JPG)

**Imagen para abrir el proyecto**

![Captura](https://user-images.githubusercontent.com/33532595/140616525-140baddb-ece6-4e0e-b428-abc8be708502.JPG)

Ahora va empezar a sincronizar el proyecto debemos esperar que termine el proceso

![Captura](https://user-images.githubusercontent.com/33532595/140616568-039a190d-9e9c-4918-a8cb-f6fbbf005a42.JPG)

Por ultimo vamos a crear un emulador  superior o igual a la version 21 de android studio. En el siguiente enlace se explica como crear un emulador u correr la app. https://developer.android.com/studio/run/emulator

## Video para correr el proyecto 🚗

En siguiente video encontrara una breve explicacion de cuales seran los pasos para correr el proyecto 

https://uniandes-my.sharepoint.com/:v:/g/personal/w_gonzalezg_uniandes_edu_co/EZIyjgvk20xIv9iHBL6-nP4BbgVWOHdO_4pgb8wX8lDzPQ?e=btearI


# Ejecutando las pruebas de Expresso  ⚙️

Para ejecutar unicamente debe  hacer lo siguiente:

1. **Para ejecutar las pruebas automatizadas unicamente** debe ejecutar los siguientes comandos en la terminal de android studio

   - Ejecutar un sync del proyecto por seguridad y esperar que termine

![Captura](https://user-images.githubusercontent.com/33532595/140617946-38fd10ad-4980-4806-a405-f0f0cd73762f.JPG)

 - Ahora ejecutar el siguiente comando **gradlew tasks**

![Captura](https://user-images.githubusercontent.com/33532595/140617885-046a78f6-adce-4479-a3cf-034c02ac9058.JPG)

 - Por ultimo el siguiente comando **gradlew test connectedAndroidTest**, en caso de que alguna prueba falle mostrara un mensaje con **BUILD FAILED**

![Captura](https://user-images.githubusercontent.com/33532595/140617907-59e71264-8781-4e20-a208-b25189ee0538.JPG)

# Video de como ejecutar las pruebas automatizadas  ⚙️

https://user-images.githubusercontent.com/33532595/140618095-56ed7d7e-ee1f-4ab0-a303-4f73adb3771f.mp4



## Construido con 🛠️

_Herramientas usadas para crear el proyecto_

* [Node 12.17.0](https://nodejs.org/es/download/releases/) - Node
* [Cypress](https://www.cypress.io/) - Cypress
* [Android studio](https://developer.android.com/studio) - Android
* [Chromium](https://www.chromium.org/getting-involved/download-chromium) - Chromium
* [JAVA](https://www.java.com/es/download/ie_manual.jsp) - Java
* [Kraken](https://github.com/TheSoftwareDesignLab/KrakenMobile/archive/refs/tags/1.0.9.zip.) - Kraken
* [Chrome](https://www.google.com/intl/es/chrome/?brand=UUXU&gclid=CjwKCAjw7diEBhB-EiwAskVi10CI0gLPlO0E3zn_0-3gOnt60O2j_i2Jr_gHLJIEkfyP0JssFBki4hoC4sYQAvD_BwE&gclsrc=aw.ds) - Chrome
* [Javascript](https://developer.mozilla.org/es/docs/Web/JavaScript) - Javascript
* [Git](https://git-scm.com/downloads) - Git
* [Ghost](https://github.com/TryGhost/Ghost/tree/3.3.0) - Ghost
* [Chromedriver](https://chromedriver.chromium.org/downloads) - chromedriver
* [Ruby](https://rubyinstaller.org/) - Ruby

## Autores ✒️

_Autor_

* **Wilson Alejandro Gonzalez Gaitan** - *Trabajo Inicial* - [Alejito29](https://github.com/Alejito29)
* **Dario Fernando Herrera Gonzalez** - *Trabajo Inicial* - [dherrera54](https://github.com/dherrera54)
* **Angelica Maria Rodriguez Torres** - *Trabajo Inicial* - [angelicamariarodriguez](https://github.com/angelicamariarodriguez9)
* **Jorge Ivan Barrera Rea** - *Trabajo Inicial* - [ivanbrij](https://github.com/ivanbrij)




## Licencia 📄

Este proyecto está bajo la Licencia (Copyleft) - mira el archivo [LICENSE.md](LICENSE.md) para detalles


